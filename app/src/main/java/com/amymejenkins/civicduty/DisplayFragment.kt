package com.amymejenkins.civicduty

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.amymejenkins.civicduty.databinding.FragmentDisplayBinding

class DisplayFragment : Fragment() {
    private val vm: ViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentDisplayBinding>(inflater, R.layout.fragment_display, container, false)

        binding.addressEditButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_displayFragment_to_editFragment)
        )

        binding.addressText.text = vm.address

        // tell Android that our TitleFragment has a menu
        setHasOptionsMenu(true)

        return binding.root
    }

    // inflate our new menu resource
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    // If NavigationUI handles the selection, go that route; else directly handle the menu item
    // without navigating
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}
