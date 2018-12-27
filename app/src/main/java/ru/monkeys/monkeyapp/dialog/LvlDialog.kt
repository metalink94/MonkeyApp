package ru.monkeys.monkeyapp.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import kotlinx.android.synthetic.main.lvl_dialog.*
import ru.monkeys.monkeyapp.R

class LvlDialog: DialogFragment() {

    var listener: LvlDialogListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return inflater.inflate(R.layout.lvl_dialog, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cancel.setOnClickListener {
            dismissAllowingStateLoss()
        }
        accept.setOnClickListener {
            listener?.onAcceptClick(arguments?.getSerializable(KEY_ENUM) as LvlEnum?)
            dismissAllowingStateLoss()
        }
    }

    companion object {

        private val KEY_ENUM = "enum"

        fun getInstance(enum: LvlEnum): LvlDialog = LvlDialog().apply {
            arguments = Bundle().apply {
                putSerializable(KEY_ENUM, enum)
            }
        }
    }
}

interface LvlDialogListener {
    fun onAcceptClick(lvlEnum: LvlEnum?)
}

enum class LvlEnum {
    FIRST,
    SECOND,
    THIRD
}