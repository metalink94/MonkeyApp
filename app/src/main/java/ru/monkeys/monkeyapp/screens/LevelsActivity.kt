package ru.monkeys.monkeyapp.screens

import android.os.Bundle
import kotlinx.android.synthetic.main.levels_activity.*
import ru.monkeys.monkeyapp.R
import ru.monkeys.monkeyapp.utils.BaseActivity

class LevelsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.levels_activity)
        lvlOne.setOnClickListener {

        }
    }
}