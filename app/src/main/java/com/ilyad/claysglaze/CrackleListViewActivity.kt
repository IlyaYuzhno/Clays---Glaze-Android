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
    var item = ""
    var temperature = ""
    var mode = ""
    var intentToNextActivity = Intent()

    companion object {
        const val ITEM_NAME = "item_name"
        const val TEMPERATURE = "temperature"
        const val MODE = "mode"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crackle_list_view)
        listView = findViewById<ListView>(R.id.CrackleListView)
        item = intent.getStringExtra(CrackleListViewActivity.ITEM_NAME).toString()
        temperature = intent.getStringExtra(CrackleListViewActivity.TEMPERATURE).toString()
        mode = intent.getStringExtra(CrackleListViewActivity.MODE).toString()
        title = "Количество цека на " + temperature
        setListView()
        goToGlazesForClayActivity()
    }

    private fun setListView() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, crackleList)
        listView.adapter = adapter
    }

    private fun goToGlazesForClayActivity() {
        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedCrackle = crackleList[position]

            if (mode.equals("clay")) {
                intentToNextActivity = Intent(context, GlazesForClayActivity::class.java)
                intentToNextActivity.putExtra(GlazesForClayActivity.CLAY_NAME, item)
                intentToNextActivity.putExtra(GlazesForClayActivity.TEMPERATURE, temperature)
                intentToNextActivity.putExtra(GlazesForClayActivity.CRACKLE, selectedCrackle)
            }
            if (mode.equals("glaze")){
                intentToNextActivity = Intent(context, ClaysForGlazesActivity::class.java)
                intentToNextActivity.putExtra(ClaysForGlazesActivity.GLAZE_NAME, item)
                intentToNextActivity.putExtra(ClaysForGlazesActivity.TEMPERATURE, temperature)
                intentToNextActivity.putExtra(ClaysForGlazesActivity.CRACKLE, selectedCrackle)
            }

            startActivity(intentToNextActivity)
        }
    }
}