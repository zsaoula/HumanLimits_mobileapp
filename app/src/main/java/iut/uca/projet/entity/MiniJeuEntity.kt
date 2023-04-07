package iut.uca.projet.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "minijeu")
class MiniJeuEntity() {
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0

    @ColumnInfo(name = "nom")
    val nom : String = ""


}