package com.kh.mdaily

import android.app.Application
import com.google.firebase.FirebaseApp

class MDaily : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}