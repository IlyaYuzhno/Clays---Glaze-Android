package com.ilyad.claysglaze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class GlazesForClayActivity: AppCompatActivity() {

    private lateinit var listView: ListView
    private var glazesList = ArrayList<String>()
    var clay = ""
    var temperature = ""
    var crackle = ""

    companion object {
        const val CLAY_NAME = "clay_name"
        const val TEMPERATURE = "temperature"
        const val CRACKLE = "crackle"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glazes_for_clay)
        listView = findViewById<ListView>(R.id.GlazesForClayListView)
        extractNames()
        title = "Подходящие глазури:"
        setListView()
    }

     private fun setListView() {
         glazesList = Interactor.getGlazesForClay(
             clay,
             temperature,
             crackle,
             this)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, glazesList)
        listView.adapter = adapter
         listView.isEnabled = false
    }

    private fun extractNames() {

        // Extract intent extras
        clay = intent.getStringExtra(GlazesForClayActivity.CLAY_NAME).toString()
        temperature = intent.getStringExtra(GlazesForClayActivity.TEMPERATURE).toString()

        // Convert crackle strings for json query
        when (intent.getStringExtra(GlazesForClayActivity.CRACKLE).toString()) {
            "Много" -> crackle = "mnogo"
            "Мало" -> crackle = "malo"
            "Нет" -> crackle = "no"
        }
    }


}
