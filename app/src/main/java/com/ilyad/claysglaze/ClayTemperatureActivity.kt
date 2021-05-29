package com.ilyad.claysglaze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ClayTemperatureActivity : AppCompatActivity() {

    companion object {
        const val CLAY_NAME = "clay_name"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clay_temperature)
        title = CLAY_NAME
    }
}