package com.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_example.view.*
import java.util.*
import kotlin.collections.ArrayList

class ExampleAdapter(private val datas: ArrayList<String>) : RecyclerView.Adapter<ExampleAdapter.ViewHolder>(), ItemTouchHelperInterface {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_example, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(datas[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(dataStr: String) {
            itemView.textView.text = dataStr
        }
    }

    fun removeAt(position: Int) {
        datas.removeAt(position)
        notifyItemRemoved(position)
    }

    fun editAt(position: Int, str: String) {
        datas[position] = str
        notifyItemChanged(position)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(datas, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(datas, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        datas.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

}