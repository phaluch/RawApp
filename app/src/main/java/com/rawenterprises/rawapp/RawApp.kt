package com.rawenterprises.rawapp

import android.app.Application
import com.parse.Parse
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

@HiltAndroidApp
class RawApp : Application() {

    // Initializes Parse SDK as soon as the application is created
    override fun onCreate() {
        super.onCreate()
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId("hYqvNNWshu88Ch6ItwORC4Prm1otQVLEgbxGh2bB")
                .clientKey("kl5lorpvdyoLj6i371AVVakqV4psFkw3drSreuNH")
                .server("https://parseapi.back4app.com")
                .build()
        )
    }

}
