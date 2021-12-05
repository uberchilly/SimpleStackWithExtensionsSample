package com.nexoslav.simplestackwithextensionssample.third

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.nexoslav.simplestackwithextensionssample.R
import com.zhuinden.simplestackextensions.fragments.KeyedFragment
import com.zhuinden.simplestackextensions.fragmentsktx.backstack

class ThirdFragment : KeyedFragment(R.layout.third_fragment_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val label = view.findViewById<TextView>(R.id.label)
        label.setOnClickListener {
            backstack.jumpToRoot()
        }
    }
}