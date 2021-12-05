package com.nexoslav.simplestackwithextensionssample.second

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.nexoslav.simplestackwithextensionssample.R
import com.nexoslav.simplestackwithextensionssample.ScopedViewModel
import com.zhuinden.simplestackextensions.fragments.KeyedFragment
import com.zhuinden.simplestackextensions.fragmentsktx.lookup

class SecondFragment : KeyedFragment(R.layout.second_fragment_layout) {
    private val viewModel by lazy { lookup<SecondFragmentViewModel>() }
    private val scopedViewModel by lazy { lookup<ScopedViewModel>() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val key: SecondScreen = getKey() // params
        val label = view.findViewById<TextView>(R.id.label)
        label.text = "Second fragment ${key.sameIntParam}"
        label.setOnClickListener {
            viewModel.onLabelClicked()
        }

        scopedViewModel.doSomething()
    }
}