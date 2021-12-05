package com.nexoslav.simplestackwithextensionssample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nexoslav.simplestackwithextensionssample.start.StartScreen
import com.zhuinden.simplestack.GlobalServices
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.SimpleStateChanger
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.navigator.Navigator
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentStateChanger

class MainActivity : AppCompatActivity(), SimpleStateChanger.NavigationHandler {

    private lateinit var fragmentStateChanger: DefaultFragmentStateChanger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentStateChanger = DefaultFragmentStateChanger(supportFragmentManager, R.id.container)

        Navigator.configure()
            .setScopedServices(ServiceProvider())
            .setStateChanger(SimpleStateChanger(this))
            .setGlobalServices(
                GlobalServices.builder()
                    .addService("appContext", applicationContext)
                    .build()
            )
            .install(this, findViewById(R.id.container), History.of(StartScreen()))
    }

    override fun onBackPressed() {
        if (!Navigator.onBackPressed(this)) {
            super.onBackPressed()
        }
    }

    override fun onNavigationEvent(stateChange: StateChange) {
        fragmentStateChanger.handleStateChange(stateChange)
    }
}