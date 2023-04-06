package iut.uca.projet.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import iut.uca.projet.R
import iut.uca.projet.adapter.MiniJeuAdpater
import iut.uca.projet.model.ReactionGame

class FragmentReflexGame : Fragment(R.layout.activity_reflex) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var jeu = ReactionGame(view)
        jeu.start()
    }
}