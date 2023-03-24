package iut.uca.projet.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import iut.uca.projet.R
import iut.uca.projet.model.ReactionGame

class ReflexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reflex)
        var jeu = ReactionGame()
        jeu.start()
    }
}