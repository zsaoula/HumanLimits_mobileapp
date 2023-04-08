package iut.uca.projet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "joueur")
class JoueurEntity {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

    @ColumnInfo(name="pseudo")
    var pseudo : String = ""
}