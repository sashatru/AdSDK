package com.example.adsdk

import android.content.Context
import com.example.adsdk.data.sources.AdMobProvider

open class AdManager(context: Context) {
    private val adProvider: AdProvider = AdMobProvider(context)

    fun getInterstitialAdState() = adProvider.interstitialAdState
    fun getNativeAdState() = adProvider.nativeAdState

    fun loadInterstitialAd() {
        adProvider.loadInterstitialAd()
    }

    fun showInterstitialAd() {
        adProvider.showInterstitialAd()
    }

    fun loadNativeAd() {
        adProvider.loadNativeAd()
    }
}
