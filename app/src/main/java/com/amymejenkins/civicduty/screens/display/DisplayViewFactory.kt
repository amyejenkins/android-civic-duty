package com.amymejenkins.civicduty.screens.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amymejenkins.civicduty.database.UserInfoDao
import com.amymejenkins.civicduty.screens.display.DisplayViewModel

class DisplayViewModelFactory(
    private val dataSource: UserInfoDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DisplayViewModel::class.java)) {
            return DisplayViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
