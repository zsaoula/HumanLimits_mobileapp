package iut.uca.projet.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import iut.uca.projet.R
import iut.uca.projet.adapter.MiniJeuAdpater
import iut.uca.projet.model.Menu
import iut.uca.projet.model.MiniJeu

class FragmentMiniJeu(val model : List<MiniJeu>) : Fragment(R.layout.fragment_container_minijeu){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.minijeux_recyclerView).layoutManager = GridLayoutManager(this.context,2,GridLayoutManager.VERTICAL,false)
        view.findViewById<RecyclerView>(R.id.minijeux_recyclerView).adapter = MiniJeuAdpater(model)

    }
}