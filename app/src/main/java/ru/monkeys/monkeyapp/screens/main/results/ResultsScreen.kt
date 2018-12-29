package ru.monkeys.monkeyapp.screens.main.results

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.result_activity.*
import ru.monkeys.monkeyapp.R
import ru.monkeys.monkeyapp.utils.BaseActivity

class ResultsScreen: BaseActivity(), View.OnClickListener {

    lateinit var adapter: ResultsAdapterImpl
    val builder: ResultsBuilderImpl = ResultsBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)
        initRecycler()
        addResults()
    }

    private fun addResults() {
        adapter.addItem(ResultModel("metalink", 10000))
        adapter.addItem(ResultModel("gaket", 9876))
        adapter.addItem(ResultModel("shamTay", 9780))
        adapter.addItem(ResultModel("Artur", 9600))
        adapter.addItem(ResultModel("Denis", 8995))
        adapter.addItem(ResultModel("Katya", 8790))
        adapter.addItem(ResultModel("Kirdyck", 8697))
        adapter.addItem(ResultModel("Агуша", 7803))
        adapter.addItem(ResultModel("Соня", 3902))
        adapter.addItem(ResultModel(sharedPreferences.getString(NICKNAME, "") ?: "", 0))

    }

    private fun initRecycler() {
        list.layoutManager = LinearLayoutManager(this)
        builder.setRecycler(list)
        builder.setOnClickListener(this)
        adapter = builder.build()
        list.adapter = adapter.getRecyclerViewAdapter()
    }

    override fun onClick(p0: View?) {

    }
}
