package ru.monkeys.monkeyapp.screens.main

import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.settings_activity.*
import ru.monkeys.monkeyapp.R
import ru.monkeys.monkeyapp.utils.BaseActivity

class SettingsActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        val nickname = sharedPreferences.getString(NICKNAME, "") ?: ""
        nick.setText(nickname)
        nick.setSelection(nickname.length)
        refresh.setOnClickListener {
            if (nick.text.toString() == sharedPreferences.getString(NICKNAME, "")) {
                Toast.makeText(this, "Вы не обновили никнейм!", Toast.LENGTH_LONG).show()
            } else {
                sharedPreferences.edit().putString(NICKNAME, nick.text.toString()).apply()
                Toast.makeText(this, "Никнейм обновлён!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
