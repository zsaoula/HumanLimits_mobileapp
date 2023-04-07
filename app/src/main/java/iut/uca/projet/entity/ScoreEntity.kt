package iut.uca.projet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "score")
class ScoreEntity {
    @ColumnInfo(name = "joueurId")
    val joueurId: Int = 0

    @ColumnInfo(name = "miniJeuId")
    val miniJeuId: Int = 0

    @ColumnInfo(name = "score")
    val score: Int = 0
}