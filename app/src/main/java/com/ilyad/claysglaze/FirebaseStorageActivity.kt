package com.ilyad.claysglaze

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
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

    fun getFirebaseImage(get: String, item: String, imageView: ImageView, context: Context) {
        val storageRef = storage.reference
        if (get.equals("clay")){
            var imageRef = storageRef.child("images/clays/" + item +".png")
            Glide.with(context)
                .load(imageRef)
                .into(imageView)
        }
        if (get.equals("glaze")){
            var imageRef = storageRef.child("images/glazes/" + item +".png")
            Glide.with(context)
                .load(imageRef)
                .into(imageView)
        }
    }

}