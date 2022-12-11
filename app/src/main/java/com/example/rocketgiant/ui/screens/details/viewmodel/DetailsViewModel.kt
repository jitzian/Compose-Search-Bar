package com.example.rocketgiant.ui.screens.details.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rocketgiant.R
import com.example.rocketgiant.constants.GlobalConstants
import com.example.rocketgiant.domain.repository.games.GamesRepository
import com.example.rocketgiant.utils.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val gamesRepository: GamesRepository,
    private val application: Application
) : ViewModel() {

    private val _state = MutableStateFlow<UIState>(UIState.Loading)
    val state: StateFlow<UIState>
        get() = _state.asStateFlow()

    fun fetchGameDetailsById(id: Int) = viewModelScope.launch {
        try {
            withTimeout(GlobalConstants.MAX_TIMEOUT) {
                withContext(Dispatchers.IO) {
                    if (state.value == UIState.Loading) {
                        val data = gamesRepository.fetchGameDetailsById(id)
                        if (data.results != null) {
                            with(data.results) {
                                _state.value = UIState.Success(
                                    name = this.aliases
                                        ?: application.resources.getString(R.string.n_a_TEXT),
                                    deck = this.deck
                                        ?: application.resources.getString(R.string.n_a_TEXT),
                                    imageUrl = this.image?.originalUrl
                                        ?: application.resources.getString(R.string.n_a_TEXT)
                                )
                            }
                        } else {
                            _state.value = UIState.Error(
                                message = application.resources.getString(R.string.there_is_no_data_available_TEXT)
                            )
                        }
                    }
                }
            }
        } catch (cancellationException: TimeoutCancellationException) {
            Log.e(
                this@DetailsViewModel.TAG(),
                "fetchGameDetailsById::cancellationException::${cancellationException.message}"
            )
            _state.value = UIState.Error(
                message = application.resources.getString(R.string.time_out_error_TEXT)
            )
        } catch (e: Exception) {
            Log.e(this@DetailsViewModel.TAG(), "fetchGameDetailsById::e::${e.message}")
            _state.value = UIState.Error(
                message = application.resources.getString(R.string.generic_error_TEXT)
            )
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