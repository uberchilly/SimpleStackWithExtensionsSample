package com.nexoslav.simplestackwithextensionssample.start

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.nexoslav.simplestackwithextensionssample.R
import com.nexoslav.simplestackwithextensionssample.first.FirstScreen
import com.zhuinden.simplestackextensions.fragments.KeyedFragment
import com.zhuinden.simplestackextensions.fragmentsktx.backstack

class StartFragment : KeyedFragment(R.layout.start_fragment_layout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val labelView = view.findViewById<TextView>(R.id.label)
        labelView.setOnClickListener {
            backstack.goTo(FirstScreen("Nemanja"))
        }
    }
}