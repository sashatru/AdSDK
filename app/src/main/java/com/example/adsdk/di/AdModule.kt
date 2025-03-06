package com.example.adsdk.di

import com.example.adsdk.AdManager
import com.example.adsdk.data.sources.AdMobProvider
import org.koin.dsl.module

val adSdkModule = module {
    single { AdMobProvider(get()) }
    single { AdManager(get()) }
}
