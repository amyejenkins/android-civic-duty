package com.amymejenkins.civicduty.screens.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.amymejenkins.civicduty.R
import com.amymejenkins.civicduty.databinding.FragmentEditBinding


class EditFragment : Fragment() {

    private lateinit var vm: EditViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.inflate<FragmentEditBinding>(
            inflater,
            R.layout.fragment_edit, container, false
        )

        vm = ViewModelProviders.of(this).get(EditViewModel::class.java)

        vm.address.observe(this, Observer { newAddress ->
            binding.addressEditText.setText(newAddress)
        })

        binding.addressSubmitButton.setOnClickListener { view: View ->
            vm.address.value = binding.addressEditText.text.toString()
            view.findNavController().navigate(R.id.action_editFragment_to_displayFragment)
        }

        return binding.root
    }
}
