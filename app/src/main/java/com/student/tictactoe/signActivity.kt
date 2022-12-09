package com.student.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.sign_up_actvity.*

class SignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_actvity)
        val player1 = findViewById<EditText>(R.id.player1_name)
        val player2 = findViewById<EditText>(R.id.player2_name)
        start.setOnClickListener {
            if (player1.toString().isNotEmpty() && player2.toString().isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                val player1 = player1.text.toString()
                val player2 = player2.text.toString()
                intent.putExtra("name1", player1)
                intent.putExtra("name2", player2)
                startActivity(intent)
                overridePendingTransition(0, R.anim.exit_animation)
            }
        }
    }
}