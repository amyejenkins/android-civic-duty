package com.amymejenkins.civicduty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.amymejenkins.civicduty.databinding.FragmentEditBinding


class EditFragment : Fragment() {

    private val vm: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.inflate<FragmentEditBinding>(inflater, R.layout.fragment_edit, container, false)
        binding.addressText.setText(vm.address)

        binding.addressSubmitButton.setOnClickListener{ view: View ->
            vm.address = binding.addressText.text.toString()
            view.findNavController().navigate(R.id.action_editFragment_to_displayFragment)
        }

        return binding.root
    }
}
