package com.amymejenkins.civicduty.screens.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amymejenkins.civicduty.database.UserInfoDao

class EditViewModelFactory(
    private val dataSource: UserInfoDao,
    private val userId: Long
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditViewModel::class.java)) {
            return EditViewModel(dataSource, userId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
