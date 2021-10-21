package dev.theuzfaleiro.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.theuzfaleiro.database.domain.model.Urgency

@Dao
interface UrgencyDao {

    @Query("SELECT * FROM URGENCY")
    suspend fun getAllCategories(): List<Urgency>

    @Insert
    suspend fun insert(urgency: Urgency): Long
}