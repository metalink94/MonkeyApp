package ru.monkeys.monkeyapp.screens

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.monkeys.monkeyapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newGame.setOnClickListener {
            startActivity(Intent(this, LevelsActivity::class.java))
        }
        settings.setOnClickListener {

        }
        scores.setOnClickListener {

        }
    }
}
