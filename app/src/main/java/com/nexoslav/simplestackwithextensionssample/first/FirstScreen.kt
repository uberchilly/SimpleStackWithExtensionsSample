package com.nexoslav.simplestackwithextensionssample.first

import androidx.fragment.app.Fragment
import com.zhuinden.simplestack.ScopeKey
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import com.zhuinden.simplestackextensions.services.DefaultServiceProvider
import com.zhuinden.simplestackextensions.servicesktx.add
import kotlinx.parcelize.Parcelize

@Parcelize
data class FirstScreen(val userName: String) : DefaultFragmentKey(),
    DefaultServiceProvider.HasServices, ScopeKey.Child {
    override fun instantiateFragment(): Fragment = FirstFragment()

    override fun getScopeTag(): String {
        return javaClass.name
    }

    override fun bindServices(serviceBinder: ServiceBinder) {
        with(serviceBinder) {
            add(FirstFragmentViewModel(getKey(), backstack))
        }
    }

    override fun getParentScopes(): List<String> {
        return listOf("scoped_service")
    }
}