package com.example.ugd3_kelompok10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity : AppCompatActivity() {
    private lateinit var username : TextInputEditText
    private lateinit var email : TextInputEditText
    private lateinit var noPhone : TextInputEditText
    private lateinit var tglLahir : TextInputEditText
    private lateinit var password : TextInputEditText
    private lateinit var btnRegister : Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setTitle("")

        username = findViewById(R.id.username)
        email = findViewById(R.id.email)
        noPhone = findViewById(R.id.phone)
        tglLahir = findViewById(R.id.tanggallahir)
        password = findViewById(R.id.password)
        btnRegister = findViewById(R.id.RegisterBtn)

        btnRegister.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            val mBundle = Bundle()
            mBundle.putString("username",username.text.toString())
            mBundle.putString("email",email.text.toString())
            mBundle.putString("noPhone",noPhone.text.toString())
            mBundle.putString("tanggalLahir",tglLahir.text.toString())
            mBundle.putString("password",password.text.toString())

            intent.putExtra("register", mBundle)
            startActivity(intent)
        }
        val backlogin: Button = findViewById(R.id.backlogin)
        backlogin.setOnClickListener(View.OnClickListener {
            val moveRegister = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(moveRegister)
        })
    }
}