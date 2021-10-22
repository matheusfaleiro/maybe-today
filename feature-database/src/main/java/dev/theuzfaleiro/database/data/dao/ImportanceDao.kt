package dev.theuzfaleiro.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.theuzfaleiro.database.domain.model.Importance

@Dao
interface ImportanceDao {

    @Query("SELECT * FROM IMPORTANCE")
    suspend fun getAllCategories(): List<Importance>

    @Insert
    suspend fun insert(importance: Importance): Long
}
