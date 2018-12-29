package ru.monkeys.monkeyapp.screens.main.results

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.row.view.*

class ResultViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(model: ResultModel) {
        itemView.nickname.text = model.nickname
        itemView.result.text = model.result.toString()
    }

}
