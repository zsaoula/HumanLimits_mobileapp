package iut.uca.projet.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import iut.uca.projet.fragment.FragmentMiniJeu
import iut.uca.projet.model.Menu
import iut.uca.projet.model.MiniJeu

class FactoryFragment(var model : List<MiniJeu>) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            FragmentMiniJeu::class.java.name -> FragmentMiniJeu(model)
            else -> super.instantiate(classLoader, className)
        }
    }
}