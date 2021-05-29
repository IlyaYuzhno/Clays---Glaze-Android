package com.ilyad.claysglaze

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    internal var expandableListView: ExpandableListView? = null
    internal var adapter: ExpandableListAdapter? = null
    internal var titleList: List<String> ? = null


    val data: HashMap<String, List<String>>
        get() {
            val listData = HashMap<String, List<String>>()

            //var witgert = ArrayList<String>()
            val witgert = BasicList.getClaysFromFile("clays_info.json", "Witgert", this)
            listData["Witgert"] = witgert

            //var donbass = ArrayList<String>()
            val donbass = BasicList.getClaysFromFile("clays_info.json", "Donbass", this)
            listData["Донбасс"] = donbass

            //var lagunaClay = ArrayList<String>()
            val lagunaClay = BasicList.getClaysFromFile("clays_info.json", "LagunaClay", this)
            listData["Laguna Clay"] = lagunaClay

            //var labCeramica = ArrayList<String>()
            val labCeramica = BasicList.getClaysFromFile("clays_info.json", "LabCeramica", this)
            listData["Lab Ceramica"] = labCeramica

            //var valentineClays = ArrayList<String>()
            val valentineClays = BasicList.getClaysFromFile("clays_info.json", "ValentineClays", this)
            listData["Valentine Clays"] = valentineClays

            //var konakovsky = ArrayList<String>()
            val konakovsky = BasicList.getClaysFromFile("clays_info.json", "Konakovsky", this)
            listData["Конаковский шамот"] = konakovsky

            //var spain = ArrayList<String>()
            val spain = BasicList.getClaysFromFile("clays_info.json", "SiO2, Spain", this)
            listData["SiO2, Spain"] = spain

            //var goerg = ArrayList<String>()
            val goerg = BasicList.getClaysFromFile("clays_info.json", "GOERG & SCHNEIDER", this)
            listData["GOERG & SCHNEIDER"] = goerg

            //var raoul = ArrayList<String>()
            val raoul = BasicList.getClaysFromFile("clays_info.json", "Raoult & Beck", this)
            listData["Raoult & Beck"] = raoul

            return listData
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Выбери массу:"
        getInfo()
        goNextActivity()
        // list view item click listener

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

    fun goNextActivity() {
//        expandableListView!!.onItemClickListener =
//            AdapterView.OnItemClickListener { parent, view, position, id ->
//                val selectedItemText = parent.getItemAtPosition(position).toString()
//                val intent = Intent(this, ClayTemperatureActivity::class.java)
//                intent.putExtra(ClayTemperatureActivity.CLAY_NAME, selectedItemText)
//                startActivity(intent)
//
//
//                Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show()
//            }


        // ExpandableListView on child click listener
        expandableListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->

            Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show()

            true
        }
    }


    fun toastMe(view: View) {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }

}