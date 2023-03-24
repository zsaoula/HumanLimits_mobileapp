package iut.uca.projet.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import iut.uca.projet.R
import iut.uca.projet.fragment.FragmentMiniJeu
import iut.uca.projet.model.*
import iut.uca.projet.viewholder.MiniJeuViewHolder

class MiniJeuAdpater(val jeux: List<MiniJeu>) : RecyclerView.Adapter<MiniJeuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiniJeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mini_jeu_item,parent,false)
        return MiniJeuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MiniJeuViewHolder, position: Int) {
        val miniJeu = jeux[position]
        when (jeux[position]) {
            is BallGame -> holder.buttonMiniJeu.text = "Ball Game"
            //is BallGame -> holder.imageMiniJeu.setImageResource(R.drawable.target)
            //holder.imageMiniJeu
            is MemoryGame -> holder.buttonMiniJeu.text = "Memory Game"
            //holder.buttonMiniJeu
            //holder.imageMiniJeu
            is ReactionGame -> holder.buttonMiniJeu.text = "Reaction Game"
            //holder.buttonMiniJeu
            //holder.imageMiniJeu
            is TypingGame -> holder.buttonMiniJeu.text = "Typing Game"
            //holder.buttonMiniJeu
            //holder.imageMiniJeu
            else -> holder.buttonMiniJeu.text = "Nothing"
        }
    }

    override fun getItemCount(): Int {
        return jeux.count()
    }
}