package iut.uca.projet.model

import kotlin.math.min

class Menu(var jeuxJouables : MutableList<MiniJeu>) {
    fun jouer(miniJeu: MiniJeu, joueur: Joueur){
        val score : Int = miniJeu.start()
        if(score > joueur.scores[miniJeu]!! || joueur.scores.containsKey(miniJeu)){
             joueur.scores[miniJeu] = score
        }
    }
}