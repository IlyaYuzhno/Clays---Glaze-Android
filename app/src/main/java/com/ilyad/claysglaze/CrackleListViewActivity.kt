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
    var clay = ""
    var temperature = ""

    companion object {
        const val CLAY_NAME = "clay_name"
        const val TEMPERATURE = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crackle_list_view)
        listView = findViewById<ListView>(R.id.CrackleListView)
        clay = intent.getStringExtra(CrackleListViewActivity.CLAY_NAME).toString()
        temperature = intent.getStringExtra(CrackleListViewActivity.TEMPERATURE).toString()
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
            val intent = Intent(context, GlazesForClayActivity::class.java)
            intent.putExtra(GlazesForClayActivity.CLAY_NAME, clay)
            intent.putExtra(GlazesForClayActivity.TEMPERATURE, temperature)
            intent.putExtra(GlazesForClayActivity.CRACKLE, selectedCrackle)
            startActivity(intent)
        }
    }
}