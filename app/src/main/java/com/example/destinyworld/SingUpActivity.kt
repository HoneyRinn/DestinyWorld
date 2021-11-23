package com.example.destinyworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern
import java.util.regex.Pattern.compile


class SingUpActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
    }

    fun next_activity(view: android.view.View) {
        if(email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty())
        {
            if(EmailValid(email.text.toString()))
            {
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            }
            else
            {
                val alert = AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("У вас неправильный e-mail")
                    .setPositiveButton("Ok", null)
                    .create()
                    .show()
            }
        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("У вас есть незаполненные поля!")
                .setPositiveButton("Ok", null)
                .create()
                .show()
        }
    }

    val pattern = ("[a-z0-9]{1,256}"+
            "\\@"+
            "[a-z]{1,10}" +
            "\\." +
            "[a-z]{1,3}")

    fun EmailValid(email: String):Boolean{
        return compile (pattern).matcher(email).matches()
    }

    fun registr_activity(view: android.view.View) {
        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
    }
}