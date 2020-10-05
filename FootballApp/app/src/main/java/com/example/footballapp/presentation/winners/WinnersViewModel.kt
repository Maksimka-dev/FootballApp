package com.example.footballapp.presentation.winners

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.model.WinnersItem
import com.example.footballapp.data.model.WinnersRepository
import com.example.footballapp.di.AppComponent
import com.example.footballapp.di.ComponentHolder
import javax.inject.Inject
import kotlinx.coroutines.launch

class WinnersViewModel : ViewModel() {
    private val _items = MutableLiveData<List<WinnersItem>>()
    val items: LiveData<List<WinnersItem>> get() = _items
    @Inject
    lateinit var teamWinnerRepository: WinnersRepository

    init {
        getComponent().inject(this)
        viewModelScope.launch {
            _items.value = teamWinnerRepository.getListOfWinners()
        }
    }

    companion object {
        fun getComponent(): AppComponent {
            return ComponentHolder.appComponent
        }
    }
}
