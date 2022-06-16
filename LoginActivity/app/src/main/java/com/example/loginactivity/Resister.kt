package com.example.loginactivity


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider

import com.example.loginactivity.data.UserViewModel
import com.example.loginactivity.data.Users
import com.example.loginactivity.databinding.ActivityResisterBinding
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_resister.*
import java.util.regex.Pattern


class Resister : AppCompatActivity() {
    var emailTextInputLayout: TextInputLayout? = null
    var email: EditText? = null
    var password:EditText? = null
    var signUp: Button? = null
    var emailtext: TextView? = null
    var tickImg: ImageView? = null
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resister)
        val binding = ActivityResisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        signUp = binding.signUp
        email = binding.signUpEmail
        password = binding.signUpPwd
        emailTextInputLayout =binding.emailContaner
        emailtext = binding.txtMail
        tickImg = binding.tick
        email!!.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(email!!.text.toString()).matches()){
                    signUp!!.isEnabled = true
                    emailTextInputLayout?.error = null
                    emailtext!!.setTextColor(getResources().getColor(R.color.Sub_text));
                    tickImg!!.isVisible = true
                }
                else{
                    signUp!!.isEnabled = false
                    tickImg!!.isVisible = false
                    email!!.requestFocus()
                    emailTextInputLayout!!.error = "The email address is incomplete"
                    emailtext!!.setTextColor(getResources().getColor(R.color.Error_text));
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        signUp!!.setOnClickListener {
                val intent: Intent = Intent(this, LoginActivity::class.java)
                val resister_name = binding.signUpEmail.text.toString()
                val resister_pwd = binding.signUpPwd.text.toString()
                intent.putExtra("name", resister_name)
                intent.putExtra("pwd", resister_pwd)
                insertDatatoDataBase()
                startActivity(intent)
        }
    }

    private fun insertDatatoDataBase() {
        val Email = sign_up_Email.text.toString()
        val Pwd = sign_up_pwd.text.toString()
        val user = Users(0,Email,Pwd)
        mUserViewModel.addUser(user)
        Toast.makeText(this,"$Email ---- $Pwd",Toast.LENGTH_SHORT).show()
    }

}