package iut.uca.projet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE

@Entity(tableName = "score", foreignKeys = [
    ForeignKey(
        entity = MiniJeuEntity::class,
        parentColumns = ["id"],
        childColumns = ["miniJeuId"],
        onDelete = CASCADE
    ),
    ForeignKey(
        entity = JoueurEntity::class,
        parentColumns = ["id"],
        childColumns = ["joueurId"],
        onDelete = CASCADE
    )
])
class ScoreEntity {
    @ColumnInfo(name = "joueurId")
    val joueurId: Int = 0

    @ColumnInfo(name = "miniJeuId")
    val miniJeuId: Int = 0

    @ColumnInfo(name = "score")
    val score: Int = 0
}