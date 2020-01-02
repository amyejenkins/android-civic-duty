package com.amymejenkins.civicduty.screens.display

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.amymejenkins.civicduty.R
import com.amymejenkins.civicduty.database.UserInfoDatabase
import com.amymejenkins.civicduty.databinding.FragmentDisplayBinding
import com.amymejenkins.civicduty.screens.edit.DisplayViewModelFactory

class DisplayFragment : Fragment() {
    private lateinit var viewModel: DisplayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val application = requireNotNull(this.activity).application

        val dataSource = UserInfoDatabase.getInstance(application).userInfoDao

        val displayModelFactory = DisplayViewModelFactory(dataSource)

        viewModel = ViewModelProviders.of(this, displayModelFactory).get(DisplayViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentDisplayBinding>(inflater,
            R.layout.fragment_display, container, false)

        binding.displayViewModel = viewModel
        binding.lifecycleOwner = this

        binding.editInfoButton.setOnClickListener{
            val action = DisplayFragmentDirections.actionDisplayFragmentToEditFragment(1)
            it.findNavController().navigate(action)
        }

        // tell Android that our DisplayFragment has a menu
        setHasOptionsMenu(true)

        return binding.root
    }

    // inflate our new menu resource
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)

        menu.findItem(R.id.share)?.isVisible = hasShareCapabilities()
    }

    // If NavigationUI handles the selection, go that route; else directly handle the menu item
    // without navigating
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun getShareIntent() : Intent {
        return ShareCompat.IntentBuilder.from(activity)
            .setText(getString(R.string.share_address_text, "My address ?"))
            .setType("text/plain")
            .intent
    }

    private fun hasShareCapabilities() : Boolean {
        // package manager (from the activity) knows about every activity registered in the android manifest across every
        // application. so it can be used to see if our implicit intent will resolve to something
        return null != getShareIntent().resolveActivity(activity!!.packageManager)
    }

    private fun shareSuccess() {
        getShareIntent()
            .run(::startActivity)
    }
}
