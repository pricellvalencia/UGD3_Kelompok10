package com.example.ugd3_kelompok10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    //Atribut yang akan kita pakai
    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private  lateinit var mainLayout: ConstraintLayout

    lateinit var user: String
    lateinit var pass: String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ubah Title pada App Bar Aplikasi
        setTitle("User Login")

        //hubungkan variabel dengan view di layoutnya
        inputUsername = findViewById(R.id.inputanLayoutUsername)
        inputPassword = findViewById(R.id.inputanLayoutPassword)
        mainLayout = findViewById(R.id.mainLayout)
        val btnRegister: Button = findViewById(R.id.btnRegister)
        val btnLogin: Button = findViewById(R.id.btnLogin)

        btnRegister.setOnClickListener(View.OnClickListener {
            val moveRegister = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(moveRegister)
        })

        //aksi pada btnLogin
        btnLogin.setOnClickListener(View.OnClickListener {
            var checkLogin = false
            val username: String = inputUsername.getEditText()?.getText().toString()
            val password: String = inputPassword.getEditText()?.getText().toString()

            //pengecekan apakah inputan username kosong
            if (username.isEmpty()) {
                inputUsername.setError("Username must be filled with text")
                checkLogin = false
            }

            //pengecekan apakah inputan password kosong
            if (password.isEmpty()) {
                inputPassword.setError("Password must be filled with text")
                checkLogin = false
            }

            if(username==user&&password==pass) checkLogin=true
            if (!checkLogin) return@OnClickListener
            val moveHome = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(moveHome)

        })

    }
}