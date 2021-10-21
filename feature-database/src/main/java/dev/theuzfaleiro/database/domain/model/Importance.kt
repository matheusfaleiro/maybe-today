package dev.theuzfaleiro.database.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "IMPORTANCE")
data class Importance(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID_IMPORTANCE")
    val importanceId: Long,
    @ColumnInfo(name = "INT_LEVEL")
    val level: Int
)