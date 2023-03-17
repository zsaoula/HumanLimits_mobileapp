package iut.uca.projet.model

import android.os.CountDownTimer
import android.util.Log
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt
import kotlin.system.measureTimeMillis


class ReactionGame : MiniJeu{

    var chrono: Long = Random.nextLong(1,10)
    var currentValue : Long = chrono
    var reactionTime: Long = 0L
    var counter = object : CountDownTimer(2000,10)
    {
        override fun onTick(millisUntilFinished: Long) {
            reactionTime = 2000L - millisUntilFinished
        }

        override fun onFinish() {
            // Soit c'est trop long (2 secondes pour réagir)
            // Soit retourne le temps de réaction
        }

    }
    override fun start() {
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
                    Log.d("chonor", currentValue.toString())
                    counter.start()
                }
                else{
                    // Si il arrive la ça veut dire qu'il a cliquer trop tot
                }
                Log.d("chrono","JE SUIS FINITO")
            }

        }
        timer.start()
    }

    override fun stop() {
        TODO("Not yet implemented")
    }



}