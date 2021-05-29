package com.ilyad.claysglaze

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    internal var expandableListView: ExpandableListView? = null
    internal var adapter: ExpandableListAdapter? = null
    internal var titleList: List<String> ? = null

    val data: HashMap<String, List<String>>
        get() {
            val listData = HashMap<String, List<String>>()

            var witgert = ArrayList<String>()
            witgert = BasicList.getClaysFromFile("clays_info.json", "Witgert", this)
            listData["Witgert"] = witgert

            var donbass = ArrayList<String>()
            donbass = BasicList.getClaysFromFile("clays_info.json", "Donbass", this)
            listData["Донбасс"] = donbass

            var lagunaClay = ArrayList<String>()
            lagunaClay = BasicList.getClaysFromFile("clays_info.json", "LagunaClay", this)
            listData["Laguna Clay"] = lagunaClay

            var labCeramica = ArrayList<String>()
            labCeramica = BasicList.getClaysFromFile("clays_info.json", "LabCeramica", this)
            listData["Lab Ceramica"] = labCeramica

            var valentineClays = ArrayList<String>()
            valentineClays = BasicList.getClaysFromFile("clays_info.json", "ValentineClays", this)
            listData["Valentine Clays"] = valentineClays

            var konakovsky = ArrayList<String>()
            konakovsky = BasicList.getClaysFromFile("clays_info.json", "Konakovsky", this)
            listData["Конаковский шамот"] = konakovsky

            var spain = ArrayList<String>()
            spain = BasicList.getClaysFromFile("clays_info.json", "SiO2, Spain", this)
            listData["SiO2, Spain"] = spain

            var goerg = ArrayList<String>()
            goerg = BasicList.getClaysFromFile("clays_info.json", "GOERG & SCHNEIDER", this)
            listData["GOERG & SCHNEIDER"] = goerg

            var raoul = ArrayList<String>()
            raoul = BasicList.getClaysFromFile("clays_info.json", "Raoult & Beck", this)
            listData["Raoult & Beck"] = raoul

            return listData
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getInfo()

        val context = this
    }

    private fun getInfo() {
    expandableListView = findViewById(R.id.ClaysExpandableListView)
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