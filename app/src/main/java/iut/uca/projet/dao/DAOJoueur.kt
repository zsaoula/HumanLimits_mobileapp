package iut.uca.projet.dao

import androidx.room.Dao
import androidx.room.Update
import iut.uca.projet.entity.JoueurEntity

@Dao
interface DAOJoueur {
    @Update
    suspend fun updateJoueur(e:JoueurEntity)
}