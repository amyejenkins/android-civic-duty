package com.amymejenkins.civicduty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

const val ADDRESS = "com.amymejenkins.civicduty.ADDRESS"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var addressSubmitButton: Button = findViewById(R.id.address_submit_button)

        addressSubmitButton.setOnClickListener {
            editText(it)
        }
    }

    fun editText(view: View) {
        var addressTextView: TextView = findViewById(R.id.address_text)
        val address = addressTextView.text.toString()
        val intent = Intent(this, EditAddressActivity::class.java).apply {
            putExtra(ADDRESS, address)
        }
        startActivity(intent)
    }
}
