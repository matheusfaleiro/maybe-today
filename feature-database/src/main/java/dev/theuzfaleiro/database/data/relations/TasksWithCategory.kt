package dev.theuzfaleiro.database.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import dev.theuzfaleiro.database.domain.model.Category
import dev.theuzfaleiro.database.domain.model.Task

data class TasksWithCategory(
    @Embedded val task: Task,
    @Relation(parentColumn = "ID_CATEGORY", entityColumn = "ID_CATEGORY")
    val category: Category
)
