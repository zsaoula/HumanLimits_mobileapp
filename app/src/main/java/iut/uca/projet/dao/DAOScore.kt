package iut.uca.projet.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.google.android.material.color.utilities.Score
import iut.uca.projet.entity.ScoreEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DAOScore {
    @Update
    suspend fun updateScore(e: ScoreEntity)

    @Query("SELECT * FROM score")
    fun getScores() : Flow<List<ScoreEntity>>
}