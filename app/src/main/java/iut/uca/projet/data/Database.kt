package iut.uca.projet.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import iut.uca.projet.dao.DAOJoueur
import iut.uca.projet.dao.DAOMiniJeu
import iut.uca.projet.dao.DAOScore
import iut.uca.projet.entity.JoueurEntity
import iut.uca.projet.entity.MiniJeuEntity
import iut.uca.projet.entity.ScoreEntity

@androidx.room.Database(arrayOf(JoueurEntity::class,MiniJeuEntity::class,ScoreEntity::class), version = 1)
abstract class Database : RoomDatabase() {
    abstract fun daoJoueur() : DAOJoueur
    abstract fun daoMiniJeu() : DAOMiniJeu
    abstract fun daoScore() : DAOScore

    companion object {
        private var INSTANCE: Database? = null


        fun getInstance(context: Context): Database? {
            var instance: Database? = null
            INSTANCE ?: synchronized(this) {
                instance = Room.databaseBuilder(context, Database::class.java, "BDDAppli").build()

            }
            INSTANCE = instance
            return INSTANCE
        }
    }
}