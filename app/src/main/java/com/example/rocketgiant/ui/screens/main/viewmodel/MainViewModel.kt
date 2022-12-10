package com.example.rocketgiant.ui.screens.main.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rocketgiant.R
import com.example.rocketgiant.constants.GlobalConstants.Companion.MAX_TIMEOUT
import com.example.rocketgiant.data.remote.model.Result
import com.example.rocketgiant.domain.repository.games.GamesRepository
import com.example.rocketgiant.utils.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val gamesRepository: GamesRepository,
    private val application: Application
) : ViewModel() {

    private val _state = MutableStateFlow<UIState>(UIState.Loading)
    val state: StateFlow<UIState>
        get() = _state.asStateFlow()

    fun fetchGames() = viewModelScope.launch {
        try {
            withTimeout(MAX_TIMEOUT) {
                withContext(Dispatchers.IO) {
                    if (state.value == UIState.Loading) {
                        val data = gamesRepository.fetchGames("game boy")
                        if (data.results.isNotEmpty()) {
                            _state.value = UIState.Success(
                                data = data.results
                            )
                        } else {
                            _state.value = UIState.Error(
                                code = ErrorStates.NO_DATA_AVAILABLE.type,
                                message = application.resources.getString(R.string.there_is_no_data_available_TEXT)
                            )
                        }
                    }
                }
            }
        } catch (cancellationException: TimeoutCancellationException) {
            Log.e(
                this@MainViewModel.TAG(),
                "fetchGames::cancellationException::${cancellationException.message}"
            )
            _state.value = UIState.Error(
                code = ErrorStates.TIME_OUT.type,
                message = cancellationException.message
                    ?: application.resources.getString(R.string.time_out_error_TEXT)
            )
        } catch (e: Exception) {
            Log.e(this@MainViewModel.TAG(), "fetchGames::exception:: ${e.message}")
            _state.value = UIState.Error(
                code = ErrorStates.GENERIC_ERROR.type,
                message = e.message ?: application.resources.getString(R.string.generic_error_TEXT)
            )
        }
    }

    enum class ErrorStates(val type: String) {
        GENERIC_ERROR("There was an error"),
        TIME_OUT(" Time Out Error"),
        NO_DATA_AVAILABLE("No data is available")
    }

    sealed class UIState {
        object Loading : UIState()
        class Success(val data: List<Result>) : UIState()
        class Error(val code: String? = null, val message: String) : UIState()
    }

}