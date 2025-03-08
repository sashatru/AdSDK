package com.example.adsdk.domain.models

import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.nativead.NativeAd

sealed class AdState {
    data object Loading : AdState()
    data class NativeAdLoaded(val nativeAd: NativeAd) : AdState()
    data class InterstitialLoaded(val interstitialAd: InterstitialAd) : AdState()
    data class Failed(val error: String) : AdState()
}