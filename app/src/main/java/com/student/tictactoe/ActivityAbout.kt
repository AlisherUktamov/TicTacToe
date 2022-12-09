package com.student.tictactoe

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_about.*

class ActivityAbout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val animation = AnimationUtils.loadAnimation(this, R.anim.movment_text)
        text_tictactoe1.startAnimation(animation)
    }
}