package com.amymejenkins.civicduty.screens.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amymejenkins.civicduty.database.UserInfoDao

class EditViewModel(
    val database: UserInfoDao
) : ViewModel() {

    private var _address = MutableLiveData<String>()
    val address: LiveData<String>
        get() = _address

    private var _eventAddressUpdated = MutableLiveData<Boolean>()
    val eventAddressUpdated: LiveData<Boolean>
        get() = _eventAddressUpdated

    fun updateAddress() {
//        _address.value = updatedAddress
        _eventAddressUpdated.value = true
    }
}