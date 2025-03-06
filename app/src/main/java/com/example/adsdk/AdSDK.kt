package com.example.adsdk

import android.app.Application
import com.example.adsdk.di.adSdkModule
import org.koin.core.context.startKoin

class AdSDK : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(adSdkModule)
        }
    }
}
