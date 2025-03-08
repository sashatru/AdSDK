package com.example.adsdk.data.sources

import android.app.Activity
import com.example.adsdk.domain.models.AdState
import kotlinx.coroutines.flow.Flow

interface AdProvider {
    fun loadInterstitialAd()
    fun showInterstitialAd(activity: Activity)
    fun loadNativeAd()
    val interstitialAdState: Flow<AdState>
    val nativeAdState: Flow<AdState>
}

