package com.example.destinyworld

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.destinyworld.net.ApiRet
import com.example.destinyworld.net.MyRetrofit
import retrofit2.Call
import retrofit2.Response
import java.util.regex.Pattern
import java.util.regex.Pattern.compile


class SingUpActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        sharedPreferences = getSharedPreferences("main", MODE_PRIVATE)
    }

    fun next_activity(view: android.view.View) {
        if(email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty())
        {
            if(EmailValid(email.text.toString()))
            {
                val log = MyRetrofit().getRetrofit()
                val getApi = log.create(ApiRet::class.java)
                var hashMap: HashMap<String,String> = HashMap<String,String>()
                hashMap.put("email", email.text.toString())
                hashMap.put("password", password.text.toString())
                val log_call:retrofit2.Call<login> = getApi.getAuth(hashMap)
                log_call.enqueue(object : retrofit2.Callback<login>{
                    override fun onResponse(call: Call<login>, response: Response<login>) {
                        if(response.isSuccessful){
                            val editor = sharedPreferences.edit()
                            editor.putString("email", response.body()?.email)
                            editor.putString("avatar", response.body()?.avatar)
                            editor.putString("name", response.body()?.nickName)
                            editor.apply()
                            val intent = Intent(this@SingUpActivity, MenuActivity::class.java)
                            startActivity(intent)
                        }
                        else
                        {
                            Toast.makeText(this@SingUpActivity,"Неверный пароль!", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<login>, t: Throwable) {
                        Toast.makeText(this@SingUpActivity,t.message, Toast.LENGTH_SHORT).show()
                    }

                })
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

    val pattern = ("[a-z0-9]{1,50}"+
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