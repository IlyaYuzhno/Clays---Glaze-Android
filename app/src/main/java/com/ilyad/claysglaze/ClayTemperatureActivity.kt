package com.ilyad.claysglaze

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ClayTemperatureActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private var temperatureList = arrayListOf<String>()

    companion object {
        const val CLAY_NAME = "clay_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clay_temperature)
        title = "Обжиг массы " + CLAY_NAME + " на:"
        getTemperatures()
        goToCrackleActivity()
    }

    private fun getTemperatures() {
        listView = findViewById<ListView>(R.id.ClaysTemperaturesListView)
        temperatureList = BasicList.getTemperature("PT", this)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, temperatureList)
        listView.adapter = adapter

    }

    private fun goToCrackleActivity() {
        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedTemperature = temperatureList[position]
           // val intent = CrackleListViewActivity.newIntent(context, selectedTemperature, CLAY_NAME)
            val intent = Intent(context, CrackleListViewActivity::class.java)
            intent.putExtra(CrackleListViewActivity.CLAY_NAME, CLAY_NAME)
            intent.putExtra(CrackleListViewActivity.TEMPERATURE, selectedTemperature)
            startActivity(intent)
        }
    }

}