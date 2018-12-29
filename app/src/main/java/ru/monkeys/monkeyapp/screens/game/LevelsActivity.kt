package ru.monkeys.monkeyapp.screens.game

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.levels_activity.*
import ru.monkeys.monkeyapp.R
import ru.monkeys.monkeyapp.dialog.LvlDialog
import ru.monkeys.monkeyapp.dialog.LvlDialogListener
import ru.monkeys.monkeyapp.dialog.LvlEnum
import ru.monkeys.monkeyapp.screens.game.tictactoe.PlayGameWithComputer
import ru.monkeys.monkeyapp.utils.BaseActivity

class LevelsActivity : BaseActivity(), LvlDialogListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.levels_activity)
        lvlOne.setOnClickListener {
            showDialog(LvlEnum.FIRST)
        }
        lvlTwo.setOnClickListener {
            showDialog(LvlEnum.SECOND)
        }
        lvlThree.setOnClickListener {
            showDialog(LvlEnum.THIRD)
        }
    }

    private fun showDialog(enum: LvlEnum) {
        val dialog = LvlDialog.getInstance(enum)
        dialog.listener = this
        supportFragmentManager.beginTransaction().add(dialog, "tag").commitAllowingStateLoss()
    }

    override fun onAcceptClick(lvlEnum: LvlEnum?) {
        when (lvlEnum) {
            LvlEnum.FIRST -> startActivity(Intent(this, LvlOneActivity::class.java))
            LvlEnum.SECOND -> startActivity(Intent(this, PlayGameWithComputer::class.java))
            LvlEnum.THIRD -> startActivity(Intent(this, LvlThreeActivity::class.java))
        }
    }
}