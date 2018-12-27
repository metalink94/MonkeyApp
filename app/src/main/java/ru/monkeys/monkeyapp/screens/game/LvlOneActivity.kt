package ru.monkeys.monkeyapp.screens.game

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.ViewFlipper
import kotlinx.android.synthetic.main.activity_lvl1.*
import ru.monkeys.monkeyapp.R
import ru.monkeys.monkeyapp.utils.BaseActivity

class LvlOneActivity: BaseActivity() {

    private var pos = 0
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
        width = metrics.widthPixels / 2
        height = metrics.heightPixels / 3
        /*if (3 * width > metrics.heightPixels / 3 * 2) {
            height = metrics.heightPixels / 3 * 2
            width = height / 4
        }*/
    }

    private fun startGame() {
        setGrid()
    }

    private fun setGrid() {
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

    private fun addFlipperContent(i: Int, flipView: ViewFlipper): View {
        val relative1 = RelativeLayout(this)
        relative1.layoutParams = ViewGroup.LayoutParams(height, height)
        relative1.setBackgroundResource(R.drawable.rectangle_grey)
        relative1.addView(addIcon(i))
        relative1.setOnClickListener { onCardClick(i, flipView) }
        return relative1
    }

    private fun onCardClick(i: Int, flipView: ViewFlipper) {

    }

    private fun addFlipperIconContent(i: Int): View {
        val relative2 = RelativeLayout(this)
        relative2.layoutParams =
                ViewGroup.LayoutParams(height, height)
        relative2.setBackgroundResource(R.drawable.rectangle_grey)
        relative2.addView(addIconPreview())
        return relative2
    }

    private fun addIcon(position: Int): View {
        val icon = ImageView(this)
        val layoutParams = RelativeLayout.LayoutParams(width / 3 * 2, width / 3 * 2)
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
        icon.layoutParams = layoutParams
        icon.setImageResource(R.mipmap.ic_launcher)
        return icon
    }

    private fun addIconPreview(): View {
        val icon = ImageView(this)
        val layoutParams = RelativeLayout.LayoutParams(width / 3 * 2, width / 3 * 2)
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
        icon.layoutParams = layoutParams
        icon.setImageResource(getImageResource())
        return icon
    }

    private fun getImageResource(): Int {
        return R.mipmap.ic_launcher_round
    }
}
