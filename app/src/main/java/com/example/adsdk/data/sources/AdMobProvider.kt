package com.example.adsdk.data.sources

import android.app.Activity
import android.content.Context
import android.util.Log
import com.example.adsdk.BuildConfig
import com.example.adsdk.domain.models.AdState
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.nativead.NativeAd
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class AdMobProvider(private val context: Context) : AdProvider {
    private val _interstitialAdState = MutableStateFlow<AdState>(AdState.Loading)
    override val interstitialAdState: StateFlow<AdState> = _interstitialAdState

    private val _nativeAdState = MutableStateFlow<AdState>(AdState.Loading)
    override val nativeAdState: StateFlow<AdState> = _nativeAdState

    private var interstitialAd: InterstitialAd? = null
    private var nativeAd: NativeAd? = null

    init {
        MobileAds.initialize(context)
        loadInterstitialAd()
        loadNativeAd()
    }

    override fun loadInterstitialAd() {
        Log.d("BugFix", "AdMobProvider loadInterstitialAd")

        InterstitialAd.load(
            context,
            BuildConfig.INTERSTITIAL_AD_ID, // Test ID
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    _interstitialAdState.value = AdState.InterstitialLoaded(ad)
                    Log.d("BugFix", "AdMobProvider onAdLoaded")
                    activityForShowAd?.let {showInterstitialAd(it)}
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    _interstitialAdState.value = AdState.Failed(error.message)
                    Log.e("BugFix", "AdMobProvider onAdFailedToLoad error: ${error.message}")
                }
            }
        )
    }

    private var activityForShowAd: Activity? = null

    override fun showInterstitialAd(activity: Activity) {
        activityForShowAd = activity
        interstitialAd?.let {
            Log.d("BugFix", "Showing Interstitial Ad: $it")
            it.show(activity)
        } ?: Log.d("BugFix", "Interstitial Ad not ready")
    }


    override fun loadNativeAd() {
        val adLoader = AdLoader.Builder(context, BuildConfig.NATIVE_AD_ID) // Test ID
            .forNativeAd { ad ->
                nativeAd = ad
                _nativeAdState.value = AdState.NativeAdLoaded(ad)
            }
            .build()

        adLoader.loadAd(AdRequest.Builder().build())
    }
}
