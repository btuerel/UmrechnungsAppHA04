package com.umrechnung.bis

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Fläche eines Fußballfeldes in Quadratmetern
    private val squareMetersPerFootballField = 7140.0

    @SuppressLint("DefaultLocale", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextSquareMeters = findViewById<EditText>(R.id.editTextSquareMeters)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            val inputText = editTextSquareMeters.text.toString()

            if (inputText.isNotEmpty()) {
                val squareMeters = inputText.toDoubleOrNull()

                if (squareMeters != null && squareMeters >= 0) {
                    val footballFields = squareMeters / squareMetersPerFootballField
                    textViewResult.text = String.format("%.2f Fußballfelder", footballFields)
                } else {
                    textViewResult.text = "Bitte eine gültige Zahl eingeben."
                }
            } else {
                textViewResult.text = "Bitte einen Wert eingeben."
            }
        }
    }
}
