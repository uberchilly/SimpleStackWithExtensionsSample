package com.nexoslav.simplestackwithextensionssample.first

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.nexoslav.simplestackwithextensionssample.R
import com.nexoslav.simplestackwithextensionssample.ScopedViewModel
import com.zhuinden.simplestackextensions.fragments.KeyedFragment
import com.zhuinden.simplestackextensions.fragmentsktx.lookup

class FirstFragment : KeyedFragment(R.layout.first_fragment_layout) {
    private val viewModel by lazy { lookup<FirstFragmentViewModel>() }
    private val scopedViewModel by lazy { lookup<ScopedViewModel>() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val key: FirstScreen = getKey() // params
        val labelView = view.findViewById<TextView>(R.id.label)
        labelView.text = "First fragment ${key.userName}"
        labelView.setOnClickListener {
            viewModel.onLabelViewClicked()
        }
        scopedViewModel.doSomething()
    }
}