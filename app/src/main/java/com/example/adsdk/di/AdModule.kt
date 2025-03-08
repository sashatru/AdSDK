package com.example.adsdk.di

import com.example.adsdk.data.sources.AdManager
import com.example.adsdk.data.sources.AdMobProvider
import org.koin.dsl.module

val adSdkModule = module {
    single { AdMobProvider(get()) }
    single { AdManager(get()) }
}
