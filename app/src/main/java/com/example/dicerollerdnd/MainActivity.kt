package com.example.dicerollerdnd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * This activity allows the user to roll several dices
 *  and view the result on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //lanzar al principio el dado para que el usuario sepa que hace la app
        lanzarDadoImg(6)

        val rollButton6: Button = findViewById(R.id.button6)
        rollButton6.setOnClickListener {lanzarDadoStr(6)}

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {lanzarDadoImg(6)}

    }

    /**
     * Roll the dice and update the screen with the result.
     * Resultado en un string
     */
    private fun lanzarDadoStr(numCaras: Int) {
        val dado = Dado(numCaras)
        val tirada = dado.lanzar()
        val tiradaTextView: TextView = findViewById(R.id.textView6)
        tiradaTextView.text = tirada.toString()
    }

    /**
     * Roll the dice and update the screen with the result.
     * Resultado en una imagen
     */
    private fun lanzarDadoImg(numCaras: Int) {
        val dado = Dado(numCaras)
        val tirada = dado.lanzar()
        val dadoImg: ImageView = findViewById(R.id.imageView)
        val drawableResource = when(tirada){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        dadoImg.setImageResource(drawableResource)
        dadoImg.contentDescription = tirada.toString()
    }
}



class Dado(private val numCaras: Int) {
    fun lanzar(): Int {
        return (1..numCaras).random()
    }
}