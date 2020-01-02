package com.amymejenkins.civicduty.screens.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amymejenkins.civicduty.database.UserInfoDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class EditViewModel(
    val database: UserInfoDao
) : ViewModel() {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)

    private var _address = MutableLiveData<String>()
    val address: LiveData<String>
        get() = _address

    private var _eventAddressUpdated = MutableLiveData<Boolean>()
    val eventAddressUpdated: LiveData<Boolean>
        get() = _eventAddressUpdated

    private var users = database.getAllUsers()

    init {
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel() // cancel all coroutines.
    }
//
//    fun updateAddress() {
////        _address.value = updatedAddress
//        _eventAddressUpdated.value = true
//    }
}