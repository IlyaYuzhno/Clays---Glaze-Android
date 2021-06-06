package com.ilyad.claysglaze

import android.os.Bundle

class MainGlazesActivity : MainActivity() {

    override val data: HashMap<String, List<String>>
        get() {
            val listData = HashMap<String, List<String>>()

            val labCeramica = Interactor.getGlazesFromFile("Lab Ceramica", this)
            listData["Lab Ceramica"] = labCeramica

            val prodesco = Interactor.getGlazesFromFile("Prodesco",this)
            listData["Prodesco"] = prodesco

            val amaco = Interactor.getGlazesFromFile("Amaco",this)
            listData["Amaco"] = amaco

            val terracolor = Interactor.getGlazesFromFile("Terracolor",this)
            listData["Terracolor"] = terracolor

            val mayco = Interactor.getGlazesFromFile("Mayco",this)
            listData["Mayco"] = mayco

            val botz = Interactor.getGlazesFromFile("Botz",this)
            listData["Botz"] = botz

            val spectrum = Interactor.getGlazesFromFile("Spectrum",this)
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