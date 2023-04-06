package iut.uca.projet.data

import iut.uca.projet.model.*

class Stub() {
    val miniJeux : Menu = Menu(mutableListOf<MiniJeu>(
        // ReactionGame(),
        TypingGame(),
        MemoryGame(),
        BallGame()
    ))

    val JeuxListe = listOf<String>("ReactionGame","TypingGame","MemoryGame","BallGame");

    fun load2() : List<String>{
        return this.JeuxListe
    }

    fun load() : List<MiniJeu>{
        return this.miniJeux.jeuxJouables
    }
}