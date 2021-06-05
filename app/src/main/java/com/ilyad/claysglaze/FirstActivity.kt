package com.ilyad.claysglaze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class FirstActivity : AppCompatActivity() {

    private lateinit var textViewUpper: TextView
    private lateinit var textViewLower: TextView
    private lateinit var goToClaysButton: Button
    private lateinit var goToGlazesButton: Button

    private var upperText = "Добро пожаловать в справочник керамиста Clays & Glaze. \n\n" +
                            "Здесь собрана информация о соответствиях масс и глазурей и информация по самим материалам. \n\n" +
                            "Для подбора глазурей для массы жми кнопку ниже:"

    private var lowerText = "Для подбора масс для глазури жми эту кнопку:"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        setText()
        setButtons()
    }

    private fun setText() {
        textViewUpper = findViewById<TextView>(R.id.textView)
        textViewLower = findViewById<TextView>(R.id.textView2)
        textViewUpper.text = upperText
        textViewLower.text = lowerText
    }

    private fun setButtons() {
        goToClaysButton = findViewById<Button>(R.id.goToClaysButton)
        goToGlazesButton = findViewById<Button>(R.id.goToGlazesButton)
        goToClaysButton.text = "Массы"
        goToGlazesButton.text = "Глазури"
    }

    fun goToClays(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun goToGlazes(view: View) {
        val intent = Intent(this, MainGlazesActivity::class.java)
        startActivity(intent)
    }

}