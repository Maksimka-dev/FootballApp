package com.example.footballapp.presentation.season

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.model.SeasonItem
import com.example.footballapp.data.model.SeasonRepository
import com.example.footballapp.di.AppComponent
import com.example.footballapp.di.ComponentHolder
import javax.inject.Inject
import kotlinx.coroutines.launch

class SeasonViewModel : ViewModel() {
    private val _items = MutableLiveData<List<SeasonItem>?>()
    val items: LiveData<List<SeasonItem>?> get() = _items

    @Inject
    lateinit var seasonRepository: SeasonRepository
    var seasonStartYear: Int? = null
        set(value) {
            field = value
            if (value != null) {
                viewModelScope.launch {
                    _items.value = seasonRepository.getSeason(value)
                }
            }
        }

    init {
        getComponent()
            .inject(this)
    }

    companion object {
        fun getComponent(): AppComponent {
            return ComponentHolder.appComponent
        }
    }
}
