package ru.monkeys.monkeyapp.screens.game

import android.os.Bundle
import ru.monkeys.monkeyapp.engine.GameActivity
import ru.monkeys.monkeyapp.screens.game.snake.SnakeGamePanel
import ru.monkeys.monkeyapp.utils.BaseActivity

class LvlThreeActivity: GameActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        switchFullscreen();
        setContentView(SnakeGamePanel(this))
    }
}
