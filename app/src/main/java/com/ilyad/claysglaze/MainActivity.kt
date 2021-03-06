package com.ilyad.claysglaze

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


open class MainActivity : AppCompatActivity() {

    internal var expandableListView: ExpandableListView? = null
    internal var adapter: ExpandableListAdapter? = null
    internal var titleList: List<String> ? = null

    open val data: HashMap<String, List<String>>
        get() {
            val listData = HashMap<String, List<String>>()

            val witgert = Interactor.getClaysFromFile("clays_info.json", "Witgert", this)
            listData["Witgert"] = witgert

            val donbass = Interactor.getClaysFromFile("clays_info.json", "Donbass", this)
            listData["Донбасс"] = donbass

            val lagunaClay = Interactor.getClaysFromFile("clays_info.json", "LagunaClay", this)
            listData["Laguna Clay"] = lagunaClay

            val labCeramica = Interactor.getClaysFromFile("clays_info.json", "LabCeramica", this)
            listData["Lab Ceramica"] = labCeramica

            val valentineClays = Interactor.getClaysFromFile("clays_info.json", "ValentineClays", this)
            listData["Valentine Clays"] = valentineClays

            val konakovsky = Interactor.getClaysFromFile("clays_info.json", "Konakovsky", this)
            listData["Конаковский шамот"] = konakovsky

            val spain = Interactor.getClaysFromFile("clays_info.json", "SiO2, Spain", this)
            listData["SiO2, Spain"] = spain

            val goerg = Interactor.getClaysFromFile("clays_info.json", "GOERG & SCHNEIDER", this)
            listData["GOERG & SCHNEIDER"] = goerg

            val raoul = Interactor.getClaysFromFile("clays_info.json", "Raoult & Beck", this)
            listData["Raoult & Beck"] = raoul

            return listData
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        expandableListView = findViewById(R.id.ClaysExpandableListView)
        title = "Выбери массу:"
        showList("clay")
    }

    open fun showList(mode: String) {
    if (expandableListView != null) {
        val listData = data
        titleList = ArrayList(listData.keys)
        adapter = CustomExpandableListAdapter(mode,this,
            titleList as ArrayList<String>,
            listData)
        expandableListView!!.setAdapter(adapter)

    }
  }
}


