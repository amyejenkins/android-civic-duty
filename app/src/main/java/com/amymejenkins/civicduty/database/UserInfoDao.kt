package com.amymejenkins.civicduty.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserInfoDao {

    @Insert
    fun insert(user: UserInfo)

    @Update
    fun update(user: UserInfo)

    @Query("SELECT * FROM user_info_table WHERE userId = :key")
    fun getUser(key: Long): UserInfo

    @Query("SELECT * FROM user_info_table ORDER BY userId DESC LIMIT 1")
    fun getMostRecentUser(): UserInfo

    @Query("SELECT * FROM user_info_table ORDER BY address ASC")
    fun getAllUsers(): LiveData<List<UserInfo>>
}