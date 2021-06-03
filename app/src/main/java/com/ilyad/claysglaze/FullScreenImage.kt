package com.ilyad.claysglaze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class FullScreenImage : AppCompatActivity() {

    private lateinit var fullScreenImage: ImageView
    private var storage: FirebaseStorageActivity = FirebaseStorageActivity()

    companion object {
        const val IMAGE_NAME = "image_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_image)
        fullScreenImage = findViewById(R.id.fullScreenImage)

        // Get image name and show image from Firebase
        val clay = intent.getStringExtra(FullScreenImage.IMAGE_NAME).toString()
        storage.getFirebaseImage("clay", clay, fullScreenImage, this)
    }


    override fun onDestroy() {
        super.onDestroy()
        Runtime.getRuntime().gc()
    }

    override fun onStop() {
        super.onStop()
        Runtime.getRuntime().gc()
    }


}