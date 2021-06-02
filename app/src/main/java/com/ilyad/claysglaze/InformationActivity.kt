package com.ilyad.claysglaze

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class InformationActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var infoTextView: TextView
    private lateinit var infoImage: ImageView
    var clay = ""
    var info = ""

    companion object {
        const val CLAY_NAME = "clay_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        titleTextView = findViewById(R.id.titleTextView)
        infoTextView = findViewById(R.id.infoTextView)
        infoTextView.movementMethod = ScrollingMovementMethod()
        infoImage = findViewById(R.id.imageView)
        setViews()
    }

    private fun setViews() {
        clay = intent.getStringExtra(InformationActivity.CLAY_NAME).toString()
        info = BasicList.getInformation(clay, this)
        titleTextView.text = clay
        infoTextView.text = info
   }

    private fun setImage() {



 }


}