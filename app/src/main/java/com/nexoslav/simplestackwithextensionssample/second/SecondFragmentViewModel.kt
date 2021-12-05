package com.nexoslav.simplestackwithextensionssample.second

import android.util.Log
import com.nexoslav.simplestackwithextensionssample.ScopedViewModel
import com.nexoslav.simplestackwithextensionssample.third.ThirdScreen
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.ScopedServices

class SecondFragmentViewModel(
    private val savedState: SecondScreen,
    private val backstack: Backstack,
    private val scopedViewModel: ScopedViewModel
) : ScopedServices.Activated {

    override fun onServiceActive() {
        Log.d("SecondFragmentViewModel", "onServiceActive: ${savedState.sameIntParam}")
    }

    override fun onServiceInactive() {
        Log.d("SecondFragmentViewModel", "onServiceInactive")
    }

    fun onLabelClicked() {
        //using scopped viewmodel inside viewmodel
        //this feature can be used to seperate functionality into parent scope and listen to
        //live data to map here
        scopedViewModel.doSomething()
        backstack.goTo(ThirdScreen())
    }
}