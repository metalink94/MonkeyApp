package ru.monkeys.monkeyapp.screens.main.results

import android.view.ViewGroup
import org.jetbrains.anko.layoutInflater
import ru.monkeys.monkeyapp.R
import ru.monkeys.monkeyapp.utils.adapter.DelegateAdapter

class ResultsDelegate: DelegateAdapter.Delegate<ResultModel, ResultViewHolder>() {
    override fun createViewHolder(parent: ViewGroup): ResultViewHolder {
        val view = parent.context.layoutInflater.inflate(R.layout.row, parent, false)
        return ResultViewHolder(view)
    }

    override fun bind(viewHolder: ResultViewHolder, model: ResultModel) {
        viewHolder.bind(model)
    }
}
