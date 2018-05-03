package com.forwork.app.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager

import com.forwork.app.R
import com.forwork.app.adapters.TimeSheetAdapter
import com.forwork.app.models.TimeSheet

import kotlinx.android.synthetic.main.activity_time_sheet.*

import java.util.*

class TimeSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_sheet)
        configure()
    }

    private fun configure() {
        val timeSheets = mutableListOf<TimeSheet>()
        timeSheets.add(TimeSheet(Date(), Date()))
        timeSheets.add(TimeSheet(Date(), Date()))
        timeSheets.add(TimeSheet(Date(), Date()))
        rvw_time_sheets.layoutManager = LinearLayoutManager(this)
        rvw_time_sheets.adapter = TimeSheetAdapter(timeSheets)
    }
}