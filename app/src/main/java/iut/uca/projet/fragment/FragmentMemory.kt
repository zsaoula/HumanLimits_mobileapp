package iut.uca.projet.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import iut.uca.projet.R
import iut.uca.projet.model.MemoryGame
import iut.uca.projet.model.ReactionGame

class FragmentMemory : Fragment(R.layout.fragment_memory_game) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MemoryGame","test1")
        var jeu = MemoryGame(view)
        jeu.start()
    }
}