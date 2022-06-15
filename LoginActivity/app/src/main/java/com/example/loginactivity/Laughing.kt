package com.example.loginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginactivity.databinding.ActivityLaughingBinding

class Laughing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLaughingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val wl_btn_sign_in= binding.wwlSignIn
        wl_btn_sign_in.setOnClickListener {
            val intent: Intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        //sign up
        val wl_btn_sign_up = binding.signUp
        wl_btn_sign_up.setOnClickListener{
            val intent: Intent = Intent(this, Resister::class.java)
            startActivity(intent)
        }


    }
}