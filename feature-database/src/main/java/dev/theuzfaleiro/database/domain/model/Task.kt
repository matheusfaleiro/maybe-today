package dev.theuzfaleiro.database.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "TASK",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            childColumns = ["ID_CATEGORY"],
            parentColumns = ["ID_CATEGORY"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Importance::class,
            childColumns = ["ID_IMPORTANCE"],
            parentColumns = ["ID_IMPORTANCE"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Urgency::class,
            childColumns = ["ID_URGENCY"],
            parentColumns = ["ID_URGENCY"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Task(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    val taskId: Long = 0,
    @ColumnInfo(name = "ID_CATEGORY", index = true)
    val categoryId: Long,
    @ColumnInfo(name = "ID_IMPORTANCE", index = true)
    val importanceId: Long,
    @ColumnInfo(name = "ID_URGENCY", index = true)
    val urgencyId: Long,
    @ColumnInfo(name = "taskTitle")
    val taskTitle: String,
    @ColumnInfo(name = "taskDescription")
    val description: String,
)
