package com.student.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    var backPressedTime: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val animation = AnimationUtils.loadAnimation(this, R.anim.movment)
        text_tictactoe.startAnimation(animation)
        button_1.setOnClickListener {
            val intent = Intent(this, SignActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, R.anim.exit_animation)
        }

        button_4.setOnClickListener {
            //  onBackPressed()
            finishAffinity()
        }
        button_3.setOnClickListener {
            val intent = Intent(this, ActivityAbout::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finish()
        } else {
            Toast.makeText(this, "Press back again to leave the app.", Toast.LENGTH_LONG).show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}
