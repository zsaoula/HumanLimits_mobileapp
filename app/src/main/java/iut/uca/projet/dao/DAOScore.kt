package iut.uca.projet.dao

import androidx.room.Dao
import androidx.room.Update
import iut.uca.projet.entity.ScoreEntity

@Dao
interface DAOScore {
    @Update
    suspend fun updateScore(e: ScoreEntity)

}