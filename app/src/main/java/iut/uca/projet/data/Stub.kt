package iut.uca.projet.data

import iut.uca.projet.model.*

class Stub() {
    val miniJeux : Menu = Menu(mutableListOf<MiniJeu>(
        ReactionGame(),
        TypingGame(),
        MemoryGame(),
        BallGame()
    ))

    fun load() : List<MiniJeu>{
        return this.miniJeux.jeuxJouables
    }
}