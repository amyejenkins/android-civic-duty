package com.amymejenkins.civicduty

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView



const val ADDRESS = "com.amymejenkins.civicduty.ADDRESS"
const val ADDRESS_CODE = 0

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addressEditButton: Button = findViewById(R.id.address_edit_button)

        addressEditButton.setOnClickListener {
            openEditText()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            ADDRESS_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    val newText = data!!.getStringExtra(ADDRESS)
                    val addressTextView = findViewById<TextView>(R.id.address_text)

                    addressTextView.text = newText
                }
            }
        }
    }

    fun openEditText() {
        val addressTextView: TextView = findViewById(R.id.address_text)
        val address = addressTextView.text.toString()
        val intent = Intent(this, EditAddressActivity::class.java).apply {
            putExtra(ADDRESS, address)
        }
        startActivityForResult(intent, ADDRESS_CODE)
    }
}
