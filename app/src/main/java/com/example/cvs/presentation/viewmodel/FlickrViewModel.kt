package com.example.cvs.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cvs.data.local.database.FlickrSearch
import com.example.cvs.data.remote.dto.FlickrImage
import com.example.cvs.data.repository.FlickrRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FlickrViewModel @Inject constructor(
    private val flickrRepository: FlickrRepository
) : ViewModel() {

    private val _flickrUiState: MutableStateFlow<FlickrUiState> = MutableStateFlow(FlickrUiState())
    val flickrUiState: StateFlow<FlickrUiState> = _flickrUiState.asStateFlow()

    fun onAction() {

    }

    data class FlickrUiState(
        val isLoading: Boolean = false,
        val error: String = "",
        val queries: List<FlickrSearch> = emptyList(),
        val flickrImages: List<FlickrImage> = emptyList(),
        val selectedFlickrImage: FlickrImage? = null
    )
}