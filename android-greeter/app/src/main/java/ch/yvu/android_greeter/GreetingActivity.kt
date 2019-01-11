package ch.yvu.android_greeter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_greeting.*

class GreetingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)
    }

    fun sayHi(v: View) {
        val nameValue = name.text.toString()
        if (isValidName(nameValue)) {
            greeting.setText(resources.getString(R.string.greeting, nameValue))
        } else {
            Snackbar.make(name, R.string.errorNoNameEntered, Snackbar.LENGTH_LONG).show()
        }
    }
}