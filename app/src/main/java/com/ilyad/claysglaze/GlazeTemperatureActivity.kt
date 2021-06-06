package com.ilyad.claysglaze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class GlazeTemperatureActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private var temperatureList = arrayListOf<String>()
    var glaze = ""

    companion object {
        const val GLAZE_NAME = "clay_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glaze_temperature)
        listView = findViewById<ListView>(R.id.GlazeTemperaturesListView)
        glaze = intent.getStringExtra(GlazeTemperatureActivity.GLAZE_NAME).toString()
        title = "Обжиг глазури " + glaze + " на:"
        getGlazeTemperature(glaze)
        goToCrackleActivity()
    }

    private fun getGlazeTemperature(item: String) {
        listView.isEnabled = true
        temperatureList = Interactor.getGlazeTemperature(
            item,
            this)
        if (temperatureList[0] == "No info available...") {
            listView.isEnabled = false
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, temperatureList)
        listView.adapter = adapter
    }

    private fun goToCrackleActivity() {
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedTemperature = temperatureList[position]
            val intent = Intent(this, CrackleListViewActivity::class.java)
            intent.putExtra(CrackleListViewActivity.ITEM_NAME, glaze)
            intent.putExtra(CrackleListViewActivity.TEMPERATURE, selectedTemperature)
            intent.putExtra(CrackleListViewActivity.MODE, "glaze")
            startActivity(intent)
        }

    }


}