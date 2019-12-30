package com.amymejenkins.civicduty.screens.title

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleViewModel: ViewModel () {
    private var _address = MutableLiveData<String>()
    val address: LiveData<String>
        get() = _address

    init {
        _address.value = "115 Main Street, Anytown NW 00000"
    }
}