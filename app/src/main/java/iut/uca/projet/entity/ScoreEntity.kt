package iut.uca.projet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

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
], primaryKeys = ["joueurId","miniJeuId" ])
class ScoreEntity {
    @ColumnInfo(name = "joueurId")
    var joueurId: Int = 0

    @ColumnInfo(name = "miniJeuId")
    var miniJeuId: Int = 0

    @ColumnInfo(name = "score")
    var score: Int = 0
}