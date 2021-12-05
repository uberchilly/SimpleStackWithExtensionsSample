package com.nexoslav.simplestackwithextensionssample.second

import androidx.fragment.app.Fragment
import com.zhuinden.simplestack.ScopeKey
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import com.zhuinden.simplestackextensions.services.DefaultServiceProvider
import com.zhuinden.simplestackextensions.servicesktx.add
import com.zhuinden.simplestackextensions.servicesktx.get
import com.zhuinden.simplestackextensions.servicesktx.lookup
import kotlinx.parcelize.Parcelize

@Parcelize
data class SecondScreen(val sameIntParam: Int) : DefaultFragmentKey(),
    DefaultServiceProvider.HasServices, ScopeKey.Child {
    override fun instantiateFragment(): Fragment = SecondFragment()

    override fun getScopeTag(): String {
        return javaClass.name
    }

    override fun bindServices(serviceBinder: ServiceBinder) {
        with(serviceBinder) {
            add(SecondFragmentViewModel(getKey(), backstack, lookup()))
        }
    }

    override fun getParentScopes(): List<String> {
        return listOf("scoped_service")
    }
}