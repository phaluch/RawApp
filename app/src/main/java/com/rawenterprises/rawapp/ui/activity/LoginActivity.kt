package com.rawenterprises.rawapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rawenterprises.rawapp.R
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}