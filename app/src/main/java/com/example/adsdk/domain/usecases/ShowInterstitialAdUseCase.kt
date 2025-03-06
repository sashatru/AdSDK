package com.example.adsdk.domain.usecases

import com.example.adsdk.AdManager

class ShowInterstitialAdUseCase(private val adManager: AdManager) {
    fun execute() {
        adManager.showInterstitialAd()
    }
}
