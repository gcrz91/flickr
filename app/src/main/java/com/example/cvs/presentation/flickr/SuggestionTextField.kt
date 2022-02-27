package com.example.cvs.presentation.flickr

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.zIndex
import com.example.cvs.presentation.viewmodel.FlickrViewModel

@Composable
fun SuggestionTextField(
    modifier: Modifier,
    viewModel: FlickrViewModel
) {
    val suggestions = viewModel.getUserSearch().collectAsState(initial = emptyList())

    val suggestionVisible = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.zIndex(2f)
    ) {
        TextField(
            value = viewModel.searchInputState,
            onValueChange = { viewModel.updateInput(it) },
            placeholder = { Text("Search") },
            singleLine = true,
            modifier = Modifier.onFocusChanged {
                if (it.isFocused)
                    suggestionVisible.value = true
            }
        )
        if (suggestionVisible.value) {
            if (suggestions.value.isEmpty()) {
                Text(text = "You have no recent searches.")
            }
            LazyColumn {
                items(suggestions.value) { text ->
                    Text(
                        modifier = Modifier.clickable {
                            viewModel.updateInput(text.search)
                            suggestionVisible.value = false
                        },
                        text = text.search
                    )
                }
            }
        }
    }
}