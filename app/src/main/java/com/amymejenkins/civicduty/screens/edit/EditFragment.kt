package com.amymejenkins.civicduty.screens.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.amymejenkins.civicduty.R
import com.amymejenkins.civicduty.databinding.FragmentEditBinding


class EditFragment : Fragment() {
    private lateinit var vm: EditViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vm = ViewModelProviders.of(this).get(EditViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentEditBinding>(
            inflater,
            R.layout.fragment_edit, container, false
        )
        binding.editViewModel = vm
        binding.lifecycleOwner = this

        vm.eventAddressUpdated.observe(this, Observer { addressUpdated ->
            if (addressUpdated) {
                NavHostFragment.findNavController(this)
                    .navigate(R.id.action_editFragment_to_displayFragment)
            }
        })

        return binding.root
    }
}
