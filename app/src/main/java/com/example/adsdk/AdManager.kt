package com.example.adsdk

import android.content.Context
import com.example.adsdk.data.sources.AdMobProvider

open class AdManager(context: Context) {
    private val adProvider: AdProvider = AdMobProvider(context)

    open fun getInterstitialAdState() = adProvider.interstitialAdState

    open fun getNativeAdState() = adProvider.nativeAdState

    open fun loadInterstitialAd() {
        adProvider.loadInterstitialAd()
    }

    open fun showInterstitialAd() {
        adProvider.showInterstitialAd()
    }

    open fun loadNativeAd() {
        adProvider.loadNativeAd()
    }
}
