package com.ilyad.claysglaze

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible


class InformationActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var infoTextView: TextView
    private lateinit var infoImage: ImageView
    private var storage: FirebaseStorageActivity = FirebaseStorageActivity()
    private var extractedName = ""
    var item = ""
    var info = ""
    var mode = ""

    companion object {
        const val ITEM_NAME = "item_name"
        const val MODE = "mode"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        titleTextView = findViewById(R.id.titleTextView)
        infoTextView = findViewById(R.id.infoTextView)
        infoTextView.movementMethod = ScrollingMovementMethod()
        infoImage = findViewById(R.id.imageView)
        setViews()
        openFullSizeImage()
    }

    private fun setViews() {
        item = intent.getStringExtra(InformationActivity.ITEM_NAME).toString()
        mode = intent.getStringExtra(InformationActivity.MODE).toString()
        info = Interactor.getInformation(mode, item, this)
        titleTextView.text = item
        infoTextView.text = info
        setImage(item)
   }

    private fun setImage(clay: String) {

        // Extract clay name for storage query
        when (mode) {
            "clay" -> {extractedName = item.substringBefore(",", item)}
            "glaze" -> {extractedName = item.substringBefore(" ", item)}
        }

        // Storage query
        storage.getFirebaseImage(mode, extractedName, infoImage, this)
    }

    private fun openFullSizeImage() {
        infoImage.setOnClickListener { _ ->
            val intent = Intent(this, FullScreenImage::class.java)
            intent.putExtra(FullScreenImage.IMAGE_NAME, extractedName)
            intent.putExtra(FullScreenImage.MODE, mode)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Runtime.getRuntime().gc()
    }


}