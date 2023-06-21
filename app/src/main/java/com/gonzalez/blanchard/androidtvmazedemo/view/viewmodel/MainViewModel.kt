package com.gonzalez.blanchard.androidtvmazedemo.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.gonzalez.blanchard.androidtvmazedemo.data.repository.TvShowRepository
import com.gonzalez.blanchard.androidtvmazedemo.domain.models.TvShowItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: TvShowRepository) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    fun onUiReady() {
        viewModelScope.launch {
            _state.value = UiState(isLoading = true)
            _state.value = UiState(isLoading = false, categories = repository.getHomeTvShows())
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val categories: Map<String, List<TvShowItem>> = emptyMap()
    )
}

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val repository: TvShowRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}