package dev.theuzfaleiro.database.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CATEGORY")
data class Category(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID_CATEGORY")
    val categoryId: Long = 0,
    @ColumnInfo(name = "NAME")
    val name: String
)
