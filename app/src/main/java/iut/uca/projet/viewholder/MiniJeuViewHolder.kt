package iut.uca.projet.viewholder

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import iut.uca.projet.R

class MiniJeuViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    var nameMiniJeu: TextView = itemView.findViewById<TextView>(R.id.minijeu_text)
    //var buttonMiniJeu : Button = itemView.findViewById<Button>(R.id.minijeu_button)
    //var imageMiniJeu : ImageView = itemView.findViewById<ImageView>(R.id.minijeu_image)
}