package dev.theuzfaleiro.database.data.dao

import android.content.Context
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import dev.theuzfaleiro.database.MaybeTodayDatabase
import dev.theuzfaleiro.database.domain.model.Category
import dev.theuzfaleiro.database.domain.model.Importance
import dev.theuzfaleiro.database.domain.model.Task
import dev.theuzfaleiro.database.domain.model.Urgency
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@ExperimentalCoroutinesApi
@Config(sdk = [Build.VERSION_CODES.R])
@RunWith(RobolectricTestRunner::class)
internal class TaskDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var categoryDao: CategoryDao
    private lateinit var importanceDao: ImportanceDao
    private lateinit var taskDao: TaskDao
    private lateinit var urgencyDao: UrgencyDao

    private lateinit var maybeTodayDatabase: MaybeTodayDatabase

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        maybeTodayDatabase = Room
            .inMemoryDatabaseBuilder(context, MaybeTodayDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        categoryDao = maybeTodayDatabase.categoryDao()
        importanceDao = maybeTodayDatabase.importanceDao()
        taskDao = maybeTodayDatabase.taskDao()
        urgencyDao = maybeTodayDatabase.urgencyDao()
    }

    @Test
    fun shouldSelectTaskWhenGetTasksFromDatabase() = runBlockingTest {
        categoryDao.insert(Category(1, "Personal"))

        importanceDao.insert(Importance(1, 5))

        urgencyDao.insert(Urgency(1, 5))

        taskDao.insert(
            Task(
                taskId = 1,
                categoryId = 1,
                importanceId = 1,
                urgencyId = 1,
                taskTitle = "Finish Maybe Today App",
                description = "Publish App on Play Store"
            )
        )

        taskDao.getAllCategories() shouldBe listOf(
            Task(
                taskId = 1,
                categoryId = 1,
                importanceId = 1,
                urgencyId = 1,
                taskTitle = "Finish Maybe Today App",
                description = "Publish App on Play Store"
            )
        )
    }

    @After
    fun tearDown() {
        maybeTodayDatabase.close()
    }
}
