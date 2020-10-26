package com.mangesh.carnot

import android.app.Application
import android.content.Context
import android.util.Log
import com.amitshekhar.DebugDB

class CarnotApplication:Application() {

    init {
        Log.d("CarnotApplication", ": "+ DebugDB.getAddressLog())
        instance=this
    }

    companion object {
        private var instance: CarnotApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

}