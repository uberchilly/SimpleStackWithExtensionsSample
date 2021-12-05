package com.nexoslav.simplestackwithextensionssample

import android.util.Log
import com.zhuinden.simplestack.ScopedServices

class ScopedViewModel : ScopedServices.Registered, ScopedServices.Activated {
    override fun onServiceRegistered() {
        Log.d("ScopedViewModel", "onServiceRegistered")
    }

    override fun onServiceUnregistered() {
        Log.d("ScopedViewModel", "onServiceUnregistered")
    }

    fun doSomething() {
    }

    override fun onServiceActive() {
        Log.d("ScopedViewModel", "onServiceActive")
    }

    override fun onServiceInactive() {
        Log.d("ScopedViewModel", "onServiceInactive")
    }

}