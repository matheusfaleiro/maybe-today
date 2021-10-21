package dev.theuzfaleiro.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.theuzfaleiro.database.data.dao.CategoryDao
import dev.theuzfaleiro.database.data.dao.ImportanceDao
import dev.theuzfaleiro.database.data.dao.TaskDao
import dev.theuzfaleiro.database.data.dao.UrgencyDao
import dev.theuzfaleiro.database.domain.model.Category
import dev.theuzfaleiro.database.domain.model.Importance
import dev.theuzfaleiro.database.domain.model.Task
import dev.theuzfaleiro.database.domain.model.Urgency

@Database(
    entities = [Category::class, Importance::class, Task::class, Urgency::class],
    version = 1,
    exportSchema = false
)
abstract class MaybeTodayDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    abstract fun importanceDao(): ImportanceDao

    abstract fun taskDao(): TaskDao

    abstract fun urgencyDao(): UrgencyDao
}
