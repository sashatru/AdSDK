package com.example.adsdk

import kotlinx.coroutines.flow.Flow

interface AdProvider {
    fun loadInterstitialAd()
    fun showInterstitialAd()
    fun loadNativeAd()
    val interstitialAdState: Flow<AdState>
    val nativeAdState: Flow<AdState>
}

sealed class AdState {
    data object Loading : AdState()
    data class Loaded(val ad: Any) : AdState()
    data class Failed(val error: String) : AdState()
}
