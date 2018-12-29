package ru.monkeys.monkeyapp.screens.main.results

import android.support.v7.widget.RecyclerView
import android.view.View

interface ResultsAdapterImpl {

    fun removeItems(items: List<*>)
    fun addItems(items: List<*>)
    fun clear()
    fun removeItem(item: Any)
    fun addItems(pos: Int, items: List<*>)
    fun addItem(pos: Int, item: Any)
    fun addItem(item: Any)
    fun size(): Int
    fun getItem(pos: Int): Any
    fun getRecyclerViewAdapter() : RecyclerView.Adapter<*>
}

interface ResultsBuilderImpl {

    fun setRecycler(recyclerView: RecyclerView)
    fun setOnClickListener(onClickListener: View.OnClickListener)
    fun build(): ResultsAdapterImpl
}
