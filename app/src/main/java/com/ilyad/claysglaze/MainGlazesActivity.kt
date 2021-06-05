package com.ilyad.claysglaze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView

class MainGlazesActivity : MainActivity() {

    override val data: HashMap<String, List<String>>
        get() {
            val listData = HashMap<String, List<String>>()

            val labCeramica = BasicList.getGlazesFromFile("Lab Ceramica", this)
            listData["Lab Ceramica"] = labCeramica

            val prodesco = BasicList.getGlazesFromFile("Prodesco",this)
            listData["Prodesco"] = prodesco

            val amaco = BasicList.getGlazesFromFile("Amaco",this)
            listData["Amaco"] = amaco

            val terracolor = BasicList.getGlazesFromFile("Terracolor",this)
            listData["Terracolor"] = terracolor

            val mayco = BasicList.getGlazesFromFile("Mayco",this)
            listData["Mayco"] = mayco

            val botz = BasicList.getGlazesFromFile("Botz",this)
            listData["Botz"] = botz

            val spectrum = BasicList.getGlazesFromFile("Spectrum",this)
            listData["Spectrum"] = spectrum

            return listData

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_glazes)
        expandableListView = findViewById(R.id.GlazesExpandableListView)
        title = "Выбери глазурь:"
        showList("glaze")
    }

}