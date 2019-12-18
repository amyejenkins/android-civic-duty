package com.amymejenkins.civicduty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.app.Activity



class EditAddressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_address)

        val submitButton: Button = findViewById(R.id.address_submit_button)

        val address = intent.getStringExtra(ADDRESS)
        val addressTextView: TextView = findViewById(R.id.address_text)
        addressTextView.text = address;

        submitButton.setOnClickListener {
            changeAddressAndReturn()
        }
    }

    fun changeAddressAndReturn() {
        val addressText = findViewById<TextView>(R.id.address_text).text
        val resultIntent = Intent()

        resultIntent.putExtra(ADDRESS, addressText.toString())
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}
