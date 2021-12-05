package com.nexoslav.simplestackwithextensionssample

import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackextensions.services.DefaultServiceProvider
import com.zhuinden.simplestackextensions.servicesktx.add

class ServiceProvider : DefaultServiceProvider() {
    override fun bindServices(serviceBinder: ServiceBinder) {
        super.bindServices(serviceBinder)

        val scope = serviceBinder.scopeTag

        with(serviceBinder) {
            when (scope) { // explicit shared services
                "scoped_service" -> {
                    add(ScopedViewModel())
                }
                else -> {
                }
            }
        }
    }
}