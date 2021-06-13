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

    public val userEmail : String = ""

    // Initializes Parse SDK as soon as the application is created
    override fun onCreate() {
        super.onCreate()
    }

}
