package com.example.todolistapp.fragments.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.R
import com.example.todolistapp.data.models.Priority
import com.example.todolistapp.data.models.ToDoData

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var dataList = emptyList<ToDoData>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.row_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.titleEditText).text = dataList[position].title
        holder.itemView.findViewById<TextView>(R.id.descriptionTextView).text =
            dataList[position].description
        when (dataList[position].priority) {
            Priority.HIGH -> holder.itemView.findViewById<CardView>(R.id.priorityIndicator)
                .setCardBackgroundColor(ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.red))
            Priority.MEDIUM -> holder.itemView.findViewById<CardView>(R.id.priorityIndicator)
                .setCardBackgroundColor(ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.yellow))
            Priority.LOW -> holder.itemView.findViewById<CardView>(R.id.priorityIndicator)
                .setCardBackgroundColor(ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.green))
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setData(toDoData: List<ToDoData>){
        this.dataList = toDoData
        notifyDataSetChanged()
    }
}