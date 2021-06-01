package com.ilyad.claysglaze

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.ExpandableListView.OnGroupClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    internal var expandableListView: ExpandableListView? = null
    internal var adapter: ExpandableListAdapter? = null
    internal var titleList: List<String> ? = null

    val data: HashMap<String, List<String>>
        get() {
            val listData = HashMap<String, List<String>>()

            val witgert = BasicList.getClaysFromFile("clays_info.json", "Witgert", this)
            listData["Witgert"] = witgert

            val donbass = BasicList.getClaysFromFile("clays_info.json", "Donbass", this)
            listData["Донбасс"] = donbass

            val lagunaClay = BasicList.getClaysFromFile("clays_info.json", "LagunaClay", this)
            listData["Laguna Clay"] = lagunaClay

            val labCeramica = BasicList.getClaysFromFile("clays_info.json", "LabCeramica", this)
            listData["Lab Ceramica"] = labCeramica

            val valentineClays = BasicList.getClaysFromFile("clays_info.json", "ValentineClays", this)
            listData["Valentine Clays"] = valentineClays

            val konakovsky = BasicList.getClaysFromFile("clays_info.json", "Konakovsky", this)
            listData["Конаковский шамот"] = konakovsky

            val spain = BasicList.getClaysFromFile("clays_info.json", "SiO2, Spain", this)
            listData["SiO2, Spain"] = spain

            val goerg = BasicList.getClaysFromFile("clays_info.json", "GOERG & SCHNEIDER", this)
            listData["GOERG & SCHNEIDER"] = goerg

            val raoul = BasicList.getClaysFromFile("clays_info.json", "Raoult & Beck", this)
            listData["Raoult & Beck"] = raoul

            return listData
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        expandableListView = findViewById(R.id.ClaysExpandableListView)
        title = "Выбери массу:"
        getInfo()
    }

    private fun getInfo() {
    if (expandableListView != null) {
        val listData = data
        titleList = ArrayList(listData.keys)
        adapter = CustomExpandableListAdapter(this,
            titleList as ArrayList<String>,
            listData)
        expandableListView!!.setAdapter(adapter)

    }
  }



}


