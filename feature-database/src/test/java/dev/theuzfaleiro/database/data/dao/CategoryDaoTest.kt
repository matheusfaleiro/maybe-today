package dev.theuzfaleiro.database.data.dao

import android.content.Context
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import dev.theuzfaleiro.database.MaybeTodayDatabase
import dev.theuzfaleiro.database.domain.model.Category
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
internal class CategoryDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var categoryDao: CategoryDao

    private lateinit var maybeTodayDatabase: MaybeTodayDatabase

    @Before
    fun setUp() {

        val context = ApplicationProvider.getApplicationContext<Context>()

        maybeTodayDatabase = Room
            .inMemoryDatabaseBuilder(context, MaybeTodayDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        categoryDao = maybeTodayDatabase.categoryDao()
    }

    @Test
    fun shouldSelectAllCategoriesWhenUsingGetAllCategoriesFromDatabase() = runBlockingTest {
        categoryDao.insert(Category(1, "Personal"))

        categoryDao.getAllCategories() shouldBe listOf(Category(1, "Personal"))
    }

    @After
    fun tearDown(){
        maybeTodayDatabase.close()
    }
}