package com.amymejenkins.civicduty.screens.display

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amymejenkins.civicduty.database.UserInfo
import com.amymejenkins.civicduty.database.UserInfoDao
import kotlinx.coroutines.*

class DisplayViewModel(
    var database: UserInfoDao
): ViewModel () {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)

    private var _user = MutableLiveData<UserInfo>()
    val user: LiveData<UserInfo>
        get() = _user

    init {
        initializeUser()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel() // cancel all coroutines.
    }

    private fun initializeUser() {
        uiScope.launch {
            _user.value = getMostRecentUser()

            if (_user.value == null) {
                val newUser = UserInfo(address = "start address!!!")
                insert(newUser)
                _user.value = getMostRecentUser()
            }
        }
    }

    private suspend fun insert(user: UserInfo) {
        withContext(Dispatchers.IO) {
            database.insert(user)
        }
    }

    private suspend fun getMostRecentUser(): UserInfo? {
        return withContext(Dispatchers.IO) {
            database.getMostRecentUser()
        }
    }

}