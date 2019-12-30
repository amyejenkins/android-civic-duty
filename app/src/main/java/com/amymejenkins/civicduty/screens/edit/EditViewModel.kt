package com.amymejenkins.civicduty.screens.edit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EditViewModel : ViewModel () {

    var address = MutableLiveData<String>()

    init {
        address.value = "115 Main Street, Anytown NW 00000"
    }
}