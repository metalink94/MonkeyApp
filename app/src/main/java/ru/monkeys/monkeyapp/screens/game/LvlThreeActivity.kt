package ru.monkeys.monkeyapp.screens.game

import android.os.Bundle
import ru.monkeys.monkeyapp.engine.GameActivity
import ru.monkeys.monkeyapp.screens.game.snake.SnakeGamePanel
import ru.monkeys.monkeyapp.screens.game.snake.SnakeListener
import ru.monkeys.monkeyapp.utils.BaseActivity

class LvlThreeActivity: GameActivity(), SnakeListener {

    lateinit var panel: SnakeGamePanel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        panel = SnakeGamePanel(this, this)
        setContentView(panel)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
