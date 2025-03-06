package com.example.adsdk.data.sources

import android.app.Activity
import android.content.Context
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.nativead.NativeAd
import com.example.adsdk.AdProvider
import com.example.adsdk.AdState
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
        InterstitialAd.load(
            context,
            "ca-app-pub-3940256099942544/1033173712", // Test ID
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    _interstitialAdState.value = AdState.Loaded(ad)
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    _interstitialAdState.value = AdState.Failed(error.message)
                }
            }
        )
    }

    override fun showInterstitialAd() {
        (context as? Activity)?.let { interstitialAd?.show(it) }
    }

    override fun loadNativeAd() {
        val adLoader = AdLoader.Builder(context, "ca-app-pub-3940256099942544/2247696110") // Test ID
            .forNativeAd { ad ->
                nativeAd = ad
                _nativeAdState.value = AdState.Loaded(ad)
            }
            .build()

        adLoader.loadAd(AdRequest.Builder().build())
    }
}
