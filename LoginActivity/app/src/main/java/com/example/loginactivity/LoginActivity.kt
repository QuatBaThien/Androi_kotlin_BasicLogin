package com.example.loginactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.loginactivity.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

import kotlinx.android.synthetic.main.activity_resister.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val StringEmail = intent.getStringExtra("name").toString()
        val StringPwd = intent.getStringExtra("pwd").toString()
        val btn_login = binding.signIn
        // dki su kien
        btn_login.setOnClickListener {
            var txt_email = binding.loginEmail.text.toString()
             var txt_pwd = binding.loginPwd.text.toString()
            val intent: Intent = Intent(this,ContactList ::class.java)
            if(txt_email == StringEmail && txt_pwd== StringPwd ) {
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "$StringEmail, $StringPwd tk mk sai moi nhap lai", Toast.LENGTH_SHORT).show()
            }
        }

    }
}