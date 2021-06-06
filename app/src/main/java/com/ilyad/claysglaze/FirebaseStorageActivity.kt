package com.ilyad.claysglaze

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage

class FirebaseStorageActivity : AppCompatActivity() {

    private var storage = FirebaseStorage.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_storage)

        // Get storage
        storage = Firebase.storage
    }

    fun getFirebaseImage(mode: String, item: String, imageView: ImageView, context: Context) {
        // Get storage reference
        val storageRef = storage.reference

        // Set circular progress bar
        val circularProgressBar = CircularProgressDrawable(context)
        circularProgressBar.strokeWidth = 5f
        circularProgressBar.centerRadius = 30f
        circularProgressBar.start()

        // Show image according to mode (clay or glaze)
        if (mode.equals("clay")){
            val imageRef = storageRef.child("images/clays/$item.png")
            Glide.with(context)
                .load(imageRef)
                .placeholder(circularProgressBar)
                .into(imageView)
        }
        if (mode.equals("glaze")){
            val imageRef = storageRef.child("images/glazes/$item.png")
            Glide.with(context)
                .load(imageRef)
                .placeholder(circularProgressBar)
                .into(imageView)
        }
    }

}