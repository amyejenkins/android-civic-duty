package com.amymejenkins.civicduty.screens.error

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.amymejenkins.civicduty.R

const val MESSAGE = "MESSAGE"

class ErrorDialogFragment : DialogFragment() {
    var errorMessage = R.string.error_message

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)

        return activity?.let {
            val message = arguments?.getInt(MESSAGE) ?: R.string.error_message;
            val builder = AlertDialog.Builder(it)
            builder.setMessage(message)
                .setPositiveButton(
                    R.string.action_ok,
                    DialogInterface.OnClickListener { dialog, id ->
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}