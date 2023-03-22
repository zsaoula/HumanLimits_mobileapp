package iut.uca.projet.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import iut.uca.projet.R
import iut.uca.projet.factory.FactoryFragment
import iut.uca.projet.fragment.FragmentMiniJeu
import iut.uca.projet.data.Stub

class StartActivity : AppCompatActivity() {

    val model = Stub().load()

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = FactoryFragment(model)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.fragmentContainerView,FragmentMiniJeu(model))
            .commit()

        //findViewById<Button>(R.id.button3)
         //   .setOnClickListener {
         //       this.launchReflexGame()
          //  }

        //findViewById<Button>(R.id.button3)
        //    .setOnClickListener {
        //        this.launchReflexGame()
        //    }
    }

    override fun onResume() {
        super.onResume()
    }

    fun launchReflexGame(){
        val i = Intent(this@StartActivity, ReflexActivity::class.java)
        startActivity(i)
    }
}