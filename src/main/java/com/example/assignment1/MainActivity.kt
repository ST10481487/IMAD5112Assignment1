package com.example.assignment1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId" , "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the button, Text View and Edit Text using the id we set on the user interface

        val submitButton = findViewById<Button>(R.id.submitButton)
        val menuButton = findViewById<Button>(R.id.menuButton)
        val editName = findViewById<EditText>(R.id.editName)
        val textDisplay = findViewById<TextView>(R.id.textDisplay)

        // map of meal suggestions based on time of day
        val mealSuggestions = mapOf(
            "morning" to "French Toast and Oatmeal" ,
            "mid-morning" to "Bacon and Cheese, and Muffins" ,
            "afternoon" to "Club sandwiich, Buffalo chicken wrap, Pizza and Chicken Salaad" ,
            "mid-afternoon" to "Chicken Fried Rice, Vaggie Sandwich, BBQ Sheet-Pan Chicken, Pasta Salaad " +
                    "and Big Mac Crunchwrap" ,
            "dinner" to "Steak, Spagghetti, Chicken and Big Mac Crunchwrap"
        )
        submitButton.setOnClickListener {
            val inputText = editName.text.toString().trim().lowercase()

            if (inputText in mealSuggestions) {
                textDisplay.text = "meal suggestions: ${mealSuggestions[inputText]}"
            } else {
                textDisplay.text =
                    "Error: Enter a valid time of day (morning, mid-day, afternoon, mid-afternoon, dinner)."
                Toast.makeText(
                    this , "Invalid input. Try again" ,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        menuButton.setOnClickListener {
            editName.text.clear()
            textDisplay.text= ""
        }
} }











