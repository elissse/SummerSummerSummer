package com.summersummersummer.day1

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.snackbar.Snackbar
import com.summersummersummer.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private var viewBinding: ActivityMainBinding? = null
    private val emailPattern = Patterns.EMAIL_ADDRESS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding .inflate(layoutInflater)
        setContentView(viewBinding?.root)
        initViewsModern()
    }

    private fun initViewsModern() {
        viewBinding?.apply {
            emailEt.doOnTextChanged { text, start, before, count ->
                text?.let {
                    sendTextBtn?.isEnabled = emailPattern.matcher(text).matches()
                }
            }
            sendTextBtn.setOnClickListener {
                Snackbar.make(
                    root,
                    "message",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
//            sendTextButton?.setOnClickListener {
//                Toast.makeText(
//                    this@MainActivity2,
//                    "Current Email: ${emailEt.text}",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
