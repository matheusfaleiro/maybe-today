package dev.theuzfaleiro.database.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import dev.theuzfaleiro.database.data.relations.TasksWithCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Transaction
    @Query("SELECT * FROM Task")
    fun getTaskWithCategories(): Flow<List<TasksWithCategory>>
}