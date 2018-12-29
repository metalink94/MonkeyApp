package ru.monkeys.monkeyapp.screens.main

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.monkeys.monkeyapp.R
import ru.monkeys.monkeyapp.dialog.NickNameDialog
import ru.monkeys.monkeyapp.screens.game.LevelsActivity
import ru.monkeys.monkeyapp.utils.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkShared()
        newGame.setOnClickListener {
            startActivity(Intent(this, LevelsActivity::class.java))
        }
        settings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
        scores.setOnClickListener {

        }
    }

    private fun checkShared() {
        if (!sharedPreferences.contains(NICKNAME) || sharedPreferences.getString(NICKNAME, "").isEmpty()) {
            val dialog = NickNameDialog()
            supportFragmentManager.beginTransaction().add(dialog, "tag").commitAllowingStateLoss()
        }
    }
}
