package com.example.rocketgiant.ui.screens.details.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.rocketgiant.R
import com.example.rocketgiant.utils.safeLet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val application: Application) : ViewModel() {

    private val _state = MutableStateFlow<UIState>(UIState.Loading)
    val state: StateFlow<UIState>
        get() = _state.asStateFlow()

    fun prepareData(name: String? = null, deck: String? = null, imageUrl: String? = null) {
        if (state.value == UIState.Loading) {
            val data = safeLet(name, deck, imageUrl) { safeName, safeDeck, safeImageUrl ->
                _state.value = UIState.Success(
                    name = safeName,
                    deck = safeDeck,
                    imageUrl = safeImageUrl
                )
            }

            if (data == null) {
                _state.value = UIState.Error(
                    message = application.resources.getString(R.string.n_a_TEXT)
                )
            }
        }
    }

    sealed class UIState {
        object Loading : UIState()
        class Success(
            val name: String,
            val deck: String,
            val imageUrl: String
        ) : UIState()

        class Error(val message: String) : UIState()
    }
}