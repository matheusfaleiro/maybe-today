package dev.theuzfaleiro.database.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "URGENCY")
data class Urgency(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID_URGENCY")
    val urgencyId: Long,
    @ColumnInfo(name = "INT_LEVEL")
    val level: Int
)
