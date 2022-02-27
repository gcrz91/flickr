package com.example.cvs.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cvs.data.remote.dto.FlickrImage
import com.example.cvs.data.repository.FlickrRepository
import com.example.cvs.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlickrViewModel @Inject constructor(
    private val flickrRepository: FlickrRepository
) : ViewModel() {

    private val _flickrUiState: MutableStateFlow<FlickrUiState> = MutableStateFlow(FlickrUiState())
    val flickrUiState: StateFlow<FlickrUiState> = _flickrUiState.asStateFlow()

    var searchInputState: String by mutableStateOf("")
        private set

    fun updateInput(input: String) {
        searchInputState = input
    }

    fun getUserSearch() = flickrRepository.getUserQueries()

    fun onSearchClicked() {
        viewModelScope.launch {
            when (val response = flickrRepository.getFlickrResponse(searchInputState)) {
                is NetworkResult.Success -> {
                    _flickrUiState.value = FlickrUiState(flickrImages = response.data.items)
                }
                is NetworkResult.Failure -> {
                    _flickrUiState.value =
                        flickrUiState.value.copy(isLoading = false, error = response.msg)
                }
            }
        }
    }

    fun onItemClick(image: FlickrImage) {
        _flickrUiState.value = flickrUiState.value.copy(selectedFlickrImage = image)
    }

    data class FlickrUiState(
        val isLoading: Boolean = false,
        val error: String = "",
        val flickrImages: List<FlickrImage> = emptyList(),
        val selectedFlickrImage: FlickrImage? = null
    )
}