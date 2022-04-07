package com.example.test


import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.test.callback.LoginActivityCallback
import com.example.test.databinding.ActivityLoginBinding

import com.example.test.util.CustomeProgressDialog
import com.example.test.viewmodel.LoginViewModel
import com.example.test.viewmodel.UserViewModel


class LoginActivity : AppCompatActivity() {

    var binding: ActivityLoginBinding? = null
    var viewmodel: LoginViewModel? = null
    var customeProgressDialog: CustomeProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewmodel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding?.viewmodel = viewmodel
        binding?.lifecycleOwner = this
        customeProgressDialog = CustomeProgressDialog(this)
        initObservables()

        val text: String = binding?.txtRegister?.getText().toString()
        val ss = SpannableString(text)
        val clickableSpan: ClickableSpan = object : ClickableSpan() {

            @RequiresApi(Build.VERSION_CODES.M)
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = getColor(R.color.clr_btn)
//                ds.isUnderlineText = true
            }

            override fun onClick(p0: View) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            }
        }


        ss.setSpan(
            clickableSpan, 23, 36,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding?.txtRegister?.setText(ss)
        binding?.txtRegister?.setMovementMethod(LinkMovementMethod.getInstance())
        binding?.txtRegister?.setHighlightColor(Color.TRANSPARENT)
    }

    private fun initObservables() {
        viewmodel?.progressDialog?.observe(this, Observer {
//            Toast.makeText(this, "welcome,", Toast.LENGTH_LONG).show()
        })

        viewmodel?.userLogin?.observe(this, Observer { user ->
            Toast.makeText(this, "welcome, ${user?.last_name}", Toast.LENGTH_LONG).show()
        })
    }


}