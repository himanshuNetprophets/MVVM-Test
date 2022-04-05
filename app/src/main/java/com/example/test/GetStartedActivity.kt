package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.google.android.material.bottomsheet.BottomSheetDialog

class GetStartedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        var CustomSelectProfilePicBottomSheetDialog  =   BottomSheetDialog(this)
        val layoutButtomSheetView  = this.layoutInflater.inflate(R.layout.bottom_dialog_layout, null)
        CustomSelectProfilePicBottomSheetDialog.setContentView(layoutButtomSheetView)
        CustomSelectProfilePicBottomSheetDialog.show()
        CustomSelectProfilePicBottomSheetDialog.setCancelable(false)

        var cv_getStarted : CardView
        cv_getStarted = layoutButtomSheetView.findViewById(R.id.cv_getStarted)

        cv_getStarted.setOnClickListener { startActivity(Intent(this, LoginActivity::class.java)) }
    }
}