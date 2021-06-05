package com.ilyad.claysglaze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ClaysForGlazesActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private var glazesList = ArrayList<String>()
    var glaze = ""
    var temperature = ""
    var crackle = ""

    companion object {
        const val GLAZE_NAME = "clay_name"
        const val TEMPERATURE = "temperature"
        const val CRACKLE = "crackle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clays_for_glazes)
        listView = findViewById<ListView>(R.id.ClaysForGlazesListView)
        extractNames()
        title = "Подходящие массы:"
        setListView()
    }

    private fun setListView() {
        glazesList = BasicList.getClaysForGlaze(
            glaze,
            temperature,
            crackle,
            this
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, glazesList)
        listView.adapter = adapter
    }

    private fun extractNames() {

        // Extract intent extras
        glaze = intent.getStringExtra(ClaysForGlazesActivity.GLAZE_NAME).toString()
        temperature = intent.getStringExtra(ClaysForGlazesActivity.TEMPERATURE).toString()

        // Convert crackle strings for json query
        when (intent.getStringExtra(ClaysForGlazesActivity.CRACKLE).toString()) {
            "Много" -> crackle = "mnogo"
            "Мало" -> crackle = "malo"
            "Нет" -> crackle = "no"
        }
    }



}