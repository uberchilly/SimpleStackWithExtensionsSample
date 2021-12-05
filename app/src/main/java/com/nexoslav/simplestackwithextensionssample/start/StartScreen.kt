package com.nexoslav.simplestackwithextensionssample.start

import androidx.fragment.app.Fragment
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import com.zhuinden.simplestackextensions.services.DefaultServiceProvider
import kotlinx.parcelize.Parcelize

@Parcelize
class StartScreen : DefaultFragmentKey(),
    DefaultServiceProvider.HasServices {
    override fun instantiateFragment(): Fragment = StartFragment()

    override fun getScopeTag(): String {
        return javaClass.name
    }

    override fun bindServices(serviceBinder: ServiceBinder) {
    }
}