package com.example.adsdk.data.sources

import android.app.Activity
import android.content.Context

class AdManager(context: Context) {
    private val adProvider: AdProvider = AdMobProvider(context)

    fun getInterstitialAdState() = adProvider.interstitialAdState

    fun getNativeAdState() = adProvider.nativeAdState

    fun loadInterstitialAd() {
        adProvider.loadInterstitialAd()
    }

    fun showInterstitialAd(activity: Activity) {
        adProvider.showInterstitialAd(activity)
    }

    fun loadNativeAd() {
        adProvider.loadNativeAd()
    }
}