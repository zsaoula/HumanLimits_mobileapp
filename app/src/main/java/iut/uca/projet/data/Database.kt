package iut.uca.projet.data

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import iut.uca.projet.dao.DAOJoueur
import iut.uca.projet.dao.DAOMiniJeu
import iut.uca.projet.dao.DAOScore
import iut.uca.projet.entity.JoueurEntity
import iut.uca.projet.entity.MiniJeuEntity
import iut.uca.projet.entity.ScoreEntity

@androidx.room.Database(arrayOf(JoueurEntity::class,MiniJeuEntity::class,ScoreEntity::class), version = 4)
abstract class Database : RoomDatabase() {
    abstract fun MiniJeuDAO(): DAOMiniJeu
    abstract fun JoueurDAO(): DAOJoueur
    abstract fun ScoreDAO(): DAOScore

    companion object {
        private var INSTANCE: Database? = null

        fun getInstance(context: Context): Database? {
            if(INSTANCE == null){
                synchronized(Database::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        Database::class.java, "database-name"
                    ).addCallback(DatabaseCallback(context)).fallbackToDestructiveMigration().build()
                }
            }
            return INSTANCE!!
        }
    }
    private class DatabaseCallback(private val context: Context) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            // Ajoutez vos requêtes SQL pour remplir votre base de données ici
            db.execSQL("INSERT INTO minijeu (id, nom) VALUES (1, 'MemoryGame')")
            db.execSQL("INSERT INTO minijeu (id, nom) VALUES (2, 'TypingGame')")
            db.execSQL("INSERT INTO minijeu (id, nom) VALUES (3, 'BallGame')")
            db.execSQL("INSERT INTO minijeu (id, nom) VALUES (4, 'ReactionGame')")
            db.execSQL("INSERT INTO joueur (id, nom) VALUES (1, '')")
            db.execSQL("INSERT INTO score (joueurId, miniJeuId, score) VALUES (1, 1, 0)")
            db.execSQL("INSERT INTO score (joueurId, miniJeuId, score) VALUES (1, 2, 0)")
            db.execSQL("INSERT INTO score (joueurId, miniJeuId, score) VALUES (1, 3, 0)")
            db.execSQL("INSERT INTO score (joueurId, miniJeuId, score) VALUES (1, 4, 0)")
        }
    }
}