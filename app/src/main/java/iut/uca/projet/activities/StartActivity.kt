package iut.uca.projet.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavHost
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import iut.uca.projet.R
import iut.uca.projet.factory.FactoryFragment
import iut.uca.projet.fragment.FragmentMiniJeu
import iut.uca.projet.data.Stub

class StartActivity : AppCompatActivity() {

    val model = Stub().load2()

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = FactoryFragment(model)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)
        //supportFragmentManager.beginTransaction()
        //    .setReorderingAllowed(true)
        //    .add(R.id.fragmentContainerView,FragmentMiniJeu(model))
        //    .commit()
    }
}