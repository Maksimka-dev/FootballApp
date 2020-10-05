package com.example.footballapp
//
// import android.content.Context
// import androidx.arch.core.executor.testing.InstantTaskExecutorRule
// import androidx.room.RoomDatabase
// import com.example.footballapp.data.database.AppDatabase
// import com.example.footballapp.data.model.WinnersItem
// import com.example.footballapp.data.model.WinnersRepository
// import com.example.footballapp.di.AppComponent
// import com.example.footballapp.di.ComponentHolder
// import com.example.footballapp.di.DaggerAppComponent
// import com.example.footballapp.presentation.winners.WinnersFragment
// import com.example.footballapp.presentation.winners.WinnersViewModel
// import io.mockk.MockKAnnotations
// import io.mockk.coEvery
// import io.mockk.impl.annotations.RelaxedMockK
// import io.mockk.mockkClass
// import kotlinx.coroutines.Dispatchers
// import kotlinx.coroutines.ExperimentalCoroutinesApi
// import kotlinx.coroutines.test.TestCoroutineDispatcher
// import kotlinx.coroutines.test.resetMain
// import kotlinx.coroutines.test.setMain
// import org.junit.After
// import org.junit.Before
// import org.junit.Rule
// import org.junit.Test
// import javax.inject.Inject
//
// @ExperimentalCoroutinesApi
// class WinnersViewModelTest {
//
//    @get:Rule
//    val rule = InstantTaskExecutorRule()
//
//    @RelaxedMockK
//    lateinit var view: WinnersFragment
//
//    @RelaxedMockK
//    lateinit var winnersRepository: WinnersRepository
//
//    @RelaxedMockK
//    lateinit var database: AppDatabase
//
//    @RelaxedMockK
//    lateinit var testContext: Context
//
//    lateinit var winnersViewModel: WinnersViewModel
//
//
//    @Before
//    fun setUp() {
//        MockKAnnotations.init(this)
//        database = mockkClass(AppDatabase::class)
//        testContext = mockkClass(Context::class)
//        ComponentHolder.appComponent = DaggerAppComponent.factory().create(testContext, database)
//        winnersRepository = mockkClass(WinnersRepository::class)
//        winnersViewModel = WinnersViewModel()
//    }
//
//    @Test
//    fun `check WinnersViewModel`() {
//        coEvery { winnersRepository.getListOfWinners() } returns listOf(
//            WinnersItem(2020, "Liverpool FC", "url", 2019),
//            WinnersItem(2021, "Leeds United FC", "url", 2020),
//            WinnersItem(2022, "Watford FC", "url", 2021)
//        )
//
//        winnersViewModel.items.observeForever {}
//
//        assert(winnersViewModel.items.value != null)
//    }
// }
