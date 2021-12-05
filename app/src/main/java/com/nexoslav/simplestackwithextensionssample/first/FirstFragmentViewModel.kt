package com.nexoslav.simplestackwithextensionssample.first

import android.util.Log
import com.nexoslav.simplestackwithextensionssample.second.SecondScreen
import com.nexoslav.simplestackwithextensionssample.third.ThirdScreen
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.ScopedServices

class FirstFragmentViewModel(private val key: FirstScreen, private val backstack: Backstack) :
    ScopedServices.Registered,
    ScopedServices.Activated {

    override fun onServiceRegistered() {
        Log.d("FirstFragmentViewModel", "onServiceRegistered")
    }

    override fun onServiceUnregistered() {
        Log.d("FirstFragmentViewModel", "onServiceUnregistered")
    }

    override fun onServiceActive() {
        Log.d("FirstFragmentViewModel", "onServiceActive: ${key.userName}")
    }

    override fun onServiceInactive() {
        Log.d("FirstFragmentViewModel", "onServiceInactive")
    }

    fun onLabelViewClicked() {
        backstack.goTo(SecondScreen(200))
//        backstack.goTo(ThirdScreen())
    }
}