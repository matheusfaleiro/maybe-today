package dev.theuzfaleiro.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.theuzfaleiro.database.domain.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM TASK")
    fun getAllTasks(): Flow<List<Task>>

    @Insert
    suspend fun insert(task: Task): Long
}
