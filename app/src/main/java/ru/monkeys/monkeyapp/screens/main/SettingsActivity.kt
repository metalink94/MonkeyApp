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
        val level = sharedPreferences.getString(LEVEL, "средний") ?: "средний"
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
        levelChange.text = String.format("Поменять сложность: с $level")
        light.setOnClickListener {
            Toast.makeText(this, "Установлен лёгкий уровень сложности", Toast.LENGTH_LONG).show()
            updateLevel("лёгкий")
        }
        middle.setOnClickListener {
            Toast.makeText(this, "Установлен средний уровень сложности", Toast.LENGTH_LONG).show()
            updateLevel("средний")
        }
        hard.setOnClickListener {
            Toast.makeText(this, "Установлен высокий уровень сложности", Toast.LENGTH_LONG).show()
            updateLevel("высокий")
        }
    }

    private fun updateLevel(levelName: String) {
        sharedPreferences.edit().putString(LEVEL, levelName).apply()
        levelChange.text = String.format("Поменять сложность: с $levelName")
    }
}
