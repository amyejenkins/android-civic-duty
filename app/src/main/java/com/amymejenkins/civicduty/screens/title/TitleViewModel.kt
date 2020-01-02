package com.amymejenkins.civicduty.screens.title

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.amymejenkins.civicduty.database.UserInfo
import com.amymejenkins.civicduty.database.UserInfoDao
import kotlinx.coroutines.*

class TitleViewModel(
    var database: UserInfoDao
): ViewModel () {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)

    private var _user = MutableLiveData<UserInfo>()
    val user: LiveData<UserInfo>
        get() = _user

//    val addressString = Transformations.map(_user) { user ->
//        user.address
//    }

    init {
//        _address.value = "115 Main Street, Anytown NW 00000"
        initializeUser()
    }


    private fun initializeUser() {
        uiScope.launch {
            _user.value = getUserFromDatabase()
        }

    }

    private suspend fun getUserFromDatabase(): UserInfo? {
        return withContext(Dispatchers.IO) {
            database.getMostRecentUser()
        }
    }

}