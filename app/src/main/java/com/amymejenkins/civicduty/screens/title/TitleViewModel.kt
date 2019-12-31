package com.amymejenkins.civicduty.screens.title

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amymejenkins.civicduty.database.UserInfoDao

class TitleViewModel(
    var database: UserInfoDao
): ViewModel () {
    private var _address = MutableLiveData<String>()
    val address: LiveData<String>
        get() = _address

    init {
        _address.value = "115 Main Street, Anytown NW 00000"
    }
}