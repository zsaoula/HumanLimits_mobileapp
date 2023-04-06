package iut.uca.projet.model

import android.graphics.Color.GREEN
import android.graphics.Color.RED
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.hardware.camera2.params.MeteringRectangle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import iut.uca.projet.R
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt
import kotlin.system.measureTimeMillis


class ReactionGame(var view: View) : MiniJeu{

    var chrono: Long = Random.nextLong(1,10)
    var currentValue : Long = chrono
    var reactionTime: Long = 0L
    var rectangle: Button = view.findViewById(R.id.press)

    var counter = object : CountDownTimer(2000,10)
    {
        override fun onTick(millisUntilFinished: Long) {
            reactionTime = 2000L - millisUntilFinished
        }

        override fun onFinish() {
            reactionTime = 0L
        }
    }

    override fun start(): Int {
        // Premier chrono pour définir quand le rectangle vas changer de couleur
        var timer = object : CountDownTimer(chrono * 1000, 100)
        {
            override fun onTick(millisUntilFinished: Long) {
                currentValue = millisUntilFinished/1000
                Log.d("chrono", "Je suis le timer ! : $millisUntilFinished")
            }

            override fun onFinish() {
                if (currentValue == 0L)
                {
                    // il faut changer la couleur du retangle la tous de suite
                    // C'est le chrono pour le temps de réaction
                    rectangle.setBackgroundColor(GREEN)
                    Log.d("chonor", currentValue.toString())
                    counter.start()
                    rectangle.setOnClickListener {
                        view.findViewById<TextView>(R.id.counter).setText(reactionTime.toString()+ " ms")
                    }
                }
                else{
                    // Si il arrive la ça veut dire qu'il a cliquer trop tot
                }
                Log.d("chrono","JE SUIS FINITO")
            }

        }
        timer.start()
        return 0
    }

    override fun stop() {
        TODO("Not implemented yet")
    }



}