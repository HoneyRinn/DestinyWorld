package com.example.destinyworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern.compile

class RegistrationActivity : AppCompatActivity() {
    lateinit var  name: EditText
    lateinit var  phone: EditText
    lateinit var  email: EditText
    lateinit var  pass: EditText
    lateinit var  nextpass: EditText
    lateinit var pattern: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        name = findViewById(R.id.name)
        phone = findViewById(R.id.phone)
        email = findViewById(R.id.email)
        pass = findViewById(R.id.pass)
        nextpass = findViewById(R.id.nextpass)
        pattern = ("[a-z0-9]{1,50}"+
                "\\@"+
                "[a-z]{1,10}" +
                "\\." +
                "[a-z]{1,3}")
    }

    fun EmailValid(email: String):Boolean{
       return compile(pattern).matcher(email).matches()
    }

    fun return_activity(view: android.view.View) {
        if(name.text.isNotEmpty() &&
            phone.text.isNotEmpty() &&
            email.text.isNotEmpty() &&
            pass.text.isNotEmpty() &&
            nextpass.text.isNotEmpty()){
            if(!pass.text.toString().equals(nextpass.text.toString())){
                if(EmailValid(email.text.toString()))
                {
                    Toast.makeText(this,"Успешно", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    val alert = AlertDialog.Builder(this)
                        .setTitle("Ошибка Email")
                        .setMessage("Проверьте правильность email!")
                        .setPositiveButton("Ok", null)
                        .create()
                        .show()
                }
            }
            else
            {
                val alert = AlertDialog.Builder(this)
                    .setTitle("Ошибка входа")
                    .setMessage("Пароли не совпадают!")
                    .setPositiveButton("Ok", null)
                    .create()
                    .show()
            }
        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка входа")
                .setMessage("У вас есть незаполненные поля!")
                .setPositiveButton("Ok", null)
                .create()
                .show()
        }
    }
    fun back(view: android.view.View) {
        val intent = Intent(this, SingUpActivity::class.java)
        startActivity(intent)
    }


}