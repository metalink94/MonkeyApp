package ru.monkeys.monkeyapp.screens.game

import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.ViewFlipper
import kotlinx.android.synthetic.main.activity_lvl1.*
import ru.monkeys.monkeyapp.R
import ru.monkeys.monkeyapp.dialog.CongratulationDialog
import ru.monkeys.monkeyapp.dialog.DialogListener
import ru.monkeys.monkeyapp.utils.BaseActivity
import kotlin.random.Random

class LvlOneActivity : BaseActivity(), DialogListener {

    private var pos = 0
    private var loseAttempt = 0
    private var height = 0
    private var width = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvl1)
        getScreenSettings()
        startGame()
    }


    private fun getScreenSettings() {
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        width = metrics.widthPixels / 5
        height = metrics.heightPixels / 3
    }

    private fun startGame() {
        loseAttempt = 0
        reDrawCircles()
        setWinnerPosition()
        setGridLayout()
    }

    private fun setWinnerPosition() {
        pos = Random.nextInt(8) + 1
        Log.d("FB", "get random number $pos")
    }

    private fun setGridLayout() {
        gridLayout.removeAllViews()
        addViews()
    }

    private fun addViews() {
        for (i in 1..8) {
            val flipView = ViewFlipper(this)
            flipView.setInAnimation(this, android.R.anim.fade_in)
            flipView.setOutAnimation(this, android.R.anim.fade_out)
            flipView.addView(addFlipperContent(i, flipView))
            flipView.addView(addFlipperIconContent(i))
            flipView.setPadding(8, 8, 8, 8)
            gridLayout.addView(flipView)
        }
    }

    private fun addFlipperIconContent(i: Int): View {
        val relative2 = RelativeLayout(this)
        relative2.layoutParams =
                ViewGroup.LayoutParams(width, width)
        relative2.setBackgroundResource(R.drawable.rectangle_grey)
        relative2.addView(addIcon(i))
        return relative2
    }

    private fun addIcon(position: Int): View {
        val icon = ImageView(this)
        val layoutParams = RelativeLayout.LayoutParams(height / 3 * 2, height / 3 * 2)
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
        icon.layoutParams = layoutParams
        if (position == pos) {
            icon.setImageResource(R.drawable.ic_banana)
        } else {
            icon.setImageResource(R.drawable.ic_cross)
        }
        return icon
    }

    private fun addIconPreview(): View {
        val icon = ImageView(this)
        val layoutParams = RelativeLayout.LayoutParams(height / 3 * 2, height / 3 * 2)
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
        icon.layoutParams = layoutParams
        icon.setImageResource(getImageResource())
        return icon
    }

    private fun getImageResource(): Int {
        val r = Random.nextInt(20)
        return when {
            r % 3 == 0 -> R.drawable.ic_monkey
            r % 4 == 0 -> R.drawable.ic_lion
            r % 5 == 0 -> R.drawable.ic_ostrich
            r % 7 == 0 -> R.drawable.ic_parrot
            else -> R.drawable.ic_tiger
        }
    }

    private fun addFlipperContent(i: Int, flipView: ViewFlipper): View {
        val relative1 = RelativeLayout(this)
        relative1.layoutParams = ViewGroup.LayoutParams(width, width)
        relative1.setBackgroundResource(R.drawable.rectangle_grey)
        relative1.addView(addIconPreview())
        relative1.setOnClickListener { onCardClick(i, flipView) }
        return relative1
    }


    private fun onCardClick(position: Int, flipView: ViewFlipper) {
        if (position == pos) {
            flipView.showNext()
            showDialog(true)
        } else {
            checkAttempt(flipView)
        }
    }

    private fun showDialog(state: Boolean) {
        Handler().postDelayed(
            {
                showWinnerDialog(state)
            }, 100
        )
    }

    private fun checkAttempt(flipView: ViewFlipper) {
        loseAttempt += 1
        reDrawCircles()
        if (loseAttempt < 3) {
            flipView.showNext()
        } else {
            flipView.showNext()
            showDialog(false)
        }
    }

    private fun reDrawCircles() {
        when (loseAttempt) {
            0 -> drawWhite()
            1 -> circle1.setBackgroundResource(R.drawable.circle_with_corner)
            2 -> circle2.setBackgroundResource(R.drawable.circle_with_corner)
            3 -> circle3.setBackgroundResource(R.drawable.circle_with_corner)
        }
    }

    private fun drawWhite() {
        circle1.setBackgroundResource(R.drawable.circle)
        circle2.setBackgroundResource(R.drawable.circle)
        circle3.setBackgroundResource(R.drawable.circle)
    }

    private fun showWinnerDialog(isWin: Boolean) {
        val fragment = CongratulationDialog.getInstance(isWin)
        fragment.listener = this
        supportFragmentManager.beginTransaction().add(fragment, "").commitAllowingStateLoss()
    }

    override fun onButtonClick() {
        startGame()
    }


    companion object {
        private const val TEXT_SIZE = 24f
    }
}
