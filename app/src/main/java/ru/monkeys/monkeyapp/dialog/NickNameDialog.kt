package ru.monkeys.monkeyapp.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.nickname_dialog.*
import ru.monkeys.monkeyapp.R
import ru.monkeys.monkeyapp.utils.BaseActivity.Companion.APP_PREFERENCES
import ru.monkeys.monkeyapp.utils.BaseActivity.Companion.NICKNAME

class NickNameDialog: DialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return inflater.inflate(R.layout.nickname_dialog, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save.setOnClickListener {
            if (nickname.text.isEmpty()) {
                Toast.makeText(requireActivity(), "Никнейм должен содержать хотя бы 1 букву или цыфру!", Toast.LENGTH_LONG).show()
            } else {
                val sharedPreferences = requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
                sharedPreferences.edit().putString(NICKNAME, nickname.text.toString()).apply()
                dismissAllowingStateLoss()
            }
        }
    }
}
