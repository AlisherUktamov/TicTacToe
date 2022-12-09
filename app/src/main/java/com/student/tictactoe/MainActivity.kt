package com.student.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

var alertDialog: AlertDialog? = null

var isGameActive = true


val random = Random()
var counterX: Int = 0
var counterO: Int = 0

var activePlayer = random.nextInt(2)

val gameState = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)

val winningPosition = arrayOf(
    //Horziontal
    arrayOf(0, 1, 2),
    arrayOf(3, 4, 5),
    arrayOf(6, 7, 8),

    //Vertical
    arrayOf(0, 3, 6),
    arrayOf(1, 4, 7),
    arrayOf(2, 5, 8),


    //diagonal
    arrayOf(0, 4, 8),
    arrayOf(2, 4, 6),

    )


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setting_button.setOnClickListener {
            exitMenu(setting_button)

            restart.setOnClickListener {
                playAgain(restart)
            }
            exit.setOnClickListener {
                exitMenu(exit)
            }


        }
        val bundle = intent?.extras
        val player1 = bundle?.getString("player1")
        val player2 = bundle?.getString("player2")
        player_name1.text = player1
        player_name2.text = player2


    }


    fun click(view: View) {
        if (isGameActive) {
            val button = view as ImageView
            val clicked = button.tag.toString().toInt()
            if (gameState[clicked] == 2) {
                gameState[clicked] = activePlayer
                if (activePlayer == 0) {
                    button.setImageResource(R.drawable.ic_icon_x)
                    activePlayer = 1
                } else {
                    button.setImageResource(R.drawable.ic_coin)
                    activePlayer = 0
                }
                for (winnigpositions in winningPosition) {
                    if (gameState[winnigpositions[0]] == gameState[winnigpositions[1]]
                        && gameState[winnigpositions[1]] == gameState[winnigpositions[2]]
                        && gameState[winnigpositions[0]] != 2

                    ) {
                        counterX++
                        isGameActive = false
                        result_game.visibility = View.VISIBLE
                        result_player.text = "X"
                        if (gameState[winnigpositions[0]] == 1) {
                            counterO++
                            result_player.text = "O"
                        }
                        playe1_score.text = counterX.toString()
                        player2_score.text = counterO.toString()
                    } else {
                        var isGameOver = true
                        //Durrang
                        for (state in gameState) {
                            if (state == 2)
                                isGameOver = false
                        }
                        if (isGameOver) {
                            result_player.text = "Draw"
                            result_game.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }

    fun playAgain(view: View) {
        isGameActive = true
        counterO = 0
        counterX = 0
        playe1_score.text = counterX.toString()
        player2_score.text = counterO.toString()
        result_game.visibility = View.INVISIBLE
        var activePlayer = random.nextInt(2)
        for (i in 0..gameState.lastIndex) {
            gameState[i] = 2
        }
        for (i in 0 until grid_layout.childCount)
            (grid_layout.getChildAt(i) as ImageView).setImageResource(0)
    }

    fun exitMenu(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
        overridePendingTransition(0, R.anim.exit_animation)
    }
}
