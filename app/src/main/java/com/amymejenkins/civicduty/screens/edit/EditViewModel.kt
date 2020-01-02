package com.amymejenkins.civicduty.screens.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amymejenkins.civicduty.database.UserInfo
import com.amymejenkins.civicduty.database.UserInfoDao
import kotlinx.coroutines.*

class EditViewModel(
    val database: UserInfoDao,
    private val userId: Long
) : ViewModel() {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)

    private var _user = MutableLiveData<UserInfo>()
    val user: LiveData<UserInfo>
        get() = _user

    private var _eventAddressUpdated = MutableLiveData<Boolean>()
    val eventAddressUpdated: LiveData<Boolean>
        get() = _eventAddressUpdated

    init {
        getUserInfo()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel() // cancel all coroutines.
    }

    private fun getUserInfo() {
        uiScope.launch {
            _user.value = getUser()
        }
    }

    private suspend fun getUser(): UserInfo? {
        return withContext(Dispatchers.IO) {
            database.getUser(userId)
        }
    }
}