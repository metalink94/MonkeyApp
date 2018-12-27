package ru.monkeys.monkeyapp.screens.main

import android.os.Bundle
import ru.monkeys.monkeyapp.R
import ru.monkeys.monkeyapp.utils.BaseActivity

class SettingsActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
    }
}