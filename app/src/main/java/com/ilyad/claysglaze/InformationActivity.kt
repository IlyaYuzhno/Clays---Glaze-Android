package com.ilyad.claysglaze

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class InformationActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var infoTextView: TextView
    private lateinit var infoImage: ImageView
    private var storage: FirebaseStorageActivity = FirebaseStorageActivity()
    private var extractedName = ""
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
        openFullSizeImage()
    }

    private fun setViews() {
        clay = intent.getStringExtra(InformationActivity.CLAY_NAME).toString()
        info = BasicList.getInformation(clay, this)
        titleTextView.text = clay
        infoTextView.text = info
        setImage(clay)
   }

    private fun setImage(clay: String) {

        // Extract clay name for storage query
        extractedName = clay.substringBefore(",", clay)

        // Storage query
        storage.getFirebaseImage("clay", extractedName, infoImage, this)
    }


    private fun openFullSizeImage() {
        infoImage.setOnClickListener { _ ->
            val intent = Intent(this, FullScreenImage::class.java)
            intent.putExtra(FullScreenImage.IMAGE_NAME, extractedName)
            //ContextCompat.startActivity(this, intent, Bundle())
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Runtime.getRuntime().gc()
    }


}