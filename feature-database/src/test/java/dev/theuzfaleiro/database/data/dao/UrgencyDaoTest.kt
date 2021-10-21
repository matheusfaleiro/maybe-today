package dev.theuzfaleiro.database.data.dao

import android.content.Context
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import dev.theuzfaleiro.database.MaybeTodayDatabase
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
internal class UrgencyDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var urgencyDao: UrgencyDao

    private lateinit var maybeTodayDatabase: MaybeTodayDatabase

    @Before
    fun setUp() {

        val context = ApplicationProvider.getApplicationContext<Context>()

        maybeTodayDatabase = Room
            .inMemoryDatabaseBuilder(context, MaybeTodayDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        urgencyDao = maybeTodayDatabase.urgencyDao()
    }

    @Test
    fun shouldSelectUrgencyWhenGetAllUrgenciesFromDatabase() = runBlockingTest {
        urgencyDao.insert(Urgency(1, 5))

        urgencyDao.getAllCategories() shouldBe listOf(Urgency(1, 5))
    }

    @After
    fun tearDown(){
        maybeTodayDatabase.close()
    }
}