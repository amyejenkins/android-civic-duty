package com.amymejenkins.civicduty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.amymejenkins.civicduty.databinding.FragmentDisplayBinding

class DisplayFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentDisplayBinding>(inflater, R.layout.fragment_display, container, false)

        binding.addressEditButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_displayFragment_to_editFragment)
        )

        return binding.root
    }
}
