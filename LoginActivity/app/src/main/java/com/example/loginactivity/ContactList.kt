package com.example.loginactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginactivity.databinding.ActivityContactListBinding
import com.example.loginactivity.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_contact_list.*
import java.util.zip.Inflater

class ContactList : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityContactListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=linearLayoutManager
    }
}