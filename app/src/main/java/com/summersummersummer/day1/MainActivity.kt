package com.summersummersummer.day1

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.widget.doOnTextChanged
import com.summersummersummer.R
import com.summersummersummer.databinding.ActivityMainBinding
import com.summersummersummer.ui.theme.SummerSummerSummerTheme

class MainActivity : ComponentActivity() {
    private var header: TextView? = null
    private var button: Button? = null
    private var viewBinding: ActivityMainBinding? = null
    private val emailPattern = Patterns.EMAIL_ADDRESS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* for classic initialization of view
        setContentView(R.layout.activity_main)
        initViewsClassic() */
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding?.root)
        initViewsModern()
    }

    private fun initViewsClassic() {
        this.header = findViewById(R.id.header)
        this.button = findViewById(R.id.button)
        var counter = 0
        button?.setOnClickListener {
            header?.text = "button clicked ${++counter} times"
            Toast.makeText(this, "${counter} hearts broken ;(", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initViewsModern() {
        viewBinding?.apply {
            emailEt.doOnTextChanged { text, start, before, count ->
                text?.let {
                    button?.isEnabled = emailPattern.matcher(text).matches()
                }
            }
        }
//        viewBinding?.let { binding ->
//            var counter = 0
//            binding.button.setOnClickListener {
//                binding.header.text = "button clicked ${++counter} times"
//            }
//        } ?: println("TEST TAG - binding is null")
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SummerSummerSummerTheme {
        Greeting("Android")
    }
}
