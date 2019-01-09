package ru.monkeys.monkeyapp.utils

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    companion object {
        const val APP_PREFERENCES = "mysettings"
        const val NICKNAME = "nickname"
        const val LEVEL = "level"
    }


    protected lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
