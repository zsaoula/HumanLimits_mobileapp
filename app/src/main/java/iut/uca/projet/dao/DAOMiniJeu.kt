package iut.uca.projet.dao

import androidx.room.Dao
import androidx.room.Query
import iut.uca.projet.entity.MiniJeuEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DAOMiniJeu {
    @Query("SELECT * FROM minijeu")
    fun getMiniJeux() : List<MiniJeuEntity>
}