package com.ilyad.claysglaze

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView

open class ClayTemperatureActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private var temperatureList = arrayListOf<String>()
    var clay = ""

    companion object {
        const val CLAY_NAME = "clay_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clay_temperature)
        listView = findViewById<ListView>(R.id.ClaysTemperaturesListView)
        clay = intent.getStringExtra(ClayTemperatureActivity.CLAY_NAME).toString()
        title = "Обжиг массы " + clay + " на:"
        getTemperatures(clay)
        goToCrackleActivity()
    }

    open fun getTemperatures(item: String) {
        listView.isEnabled = true
        temperatureList = BasicList.getClayTemperature(
            item,
            this)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, temperatureList)
        listView.adapter = adapter
        if (temperatureList[0] == "No info available...") {
            listView.isEnabled = false
        }
    }

    open fun goToCrackleActivity() {
        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedTemperature = temperatureList[position]
            val intent = Intent(context, CrackleListViewActivity::class.java)
            intent.putExtra(CrackleListViewActivity.ITEM_NAME, clay)
            intent.putExtra(CrackleListViewActivity.TEMPERATURE, selectedTemperature)
            intent.putExtra(CrackleListViewActivity.MODE, "clay")
            startActivity(intent)
        }
    }

}