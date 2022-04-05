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
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.test.databinding.ActivityLoginBinding
import com.example.test.factory.LoginModelFactory
import com.example.test.viewModel.LoginViewModel


class LoginActivity : AppCompatActivity() {
    lateinit var txt_register : TextView
    lateinit var binding: ActivityLoginBinding
    private var mCtx: Context? = null
    private var viewModel: LoginViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
        val binding: ViewDataBinding? = DataBindingUtil.setContentView(this, R.layout.activity_login)
        txt_register = findViewById(R.id.txt_register)

        mCtx = this;
        viewModel = ViewModelProvider(this, LoginModelFactory()).get(LoginViewModel::class.java)
        mCtx = this
        binding!!.lifecycleOwner = this

        val text: String = txt_register.getText().toString()
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

        txt_register.setText(ss)
        txt_register.setMovementMethod(LinkMovementMethod.getInstance())
        txt_register.setHighlightColor(Color.TRANSPARENT)
    }
}