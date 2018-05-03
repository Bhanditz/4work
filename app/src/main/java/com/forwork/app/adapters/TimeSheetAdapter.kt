package com.forwork.app.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.forwork.app.App
import com.forwork.app.R
import com.forwork.app.models.TimeSheet

import kotlinx.android.synthetic.main.item_time_sheet.view.*

class TimeSheetAdapter(private val timeSheets: MutableList<TimeSheet>) : RecyclerView.Adapter<TimeSheetAdapter.ViewHolder>() {
    private val context: Context = App.context

    override fun getItemCount(): Int {
        return timeSheets.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val timeSheet = timeSheets[position]
        holder.bind(timeSheet)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_time_sheet, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(timeSheet: TimeSheet) {
            itemView.tvw_start_of_work.text = timeSheet.startOfWork.toString()
        }
    }
}