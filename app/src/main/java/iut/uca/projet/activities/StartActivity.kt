package iut.uca.projet.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import iut.uca.projet.R

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)
        findViewById<Button>(R.id.button3)
            .setOnClickListener {
                this.launchReflexGame()
            }
    }

    fun launchReflexGame(){
        val i = Intent(this@StartActivity, ReflexActivity::class.java)
        startActivity(i)
    }
}