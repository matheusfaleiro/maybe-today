package dev.theuzfaleiro.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.theuzfaleiro.database.domain.model.Category

@Dao
interface CategoryDao {

    @Query("SELECT * FROM CATEGORY")
    suspend fun getAllCategories(): List<Category>

    @Insert
    suspend fun insert(category: Category): Long
}
