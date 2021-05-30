package com.ilyad.claysglaze

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class CrackleListViewActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private val crackleList = arrayOf("Много", "Мало", "Нет")

    companion object {
        const val CLAY_NAME = "clay_name"
        const val TEMPERATURE = ""

//        fun newIntent(context: Context, selectedTemperature: String, clayName: String): Intent {
//            val intent = Intent(context, CrackleListViewActivity::class.java)
//
//            intent.putExtra(CLAY_NAME, clayName)
//            intent.putExtra(TEMPERATURE, selectedTemperature)
//
//            return intent
//        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crackle_list_view)
        title = "Количество цека:"
        setListView()
    }

    private fun setListView() {
        listView = findViewById<ListView>(R.id.CrackleListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, crackleList)
        listView.adapter = adapter
    }
}