package uz.lesson.lessoncompose

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.lesson.lessoncompose.model.SecondIntent
import uz.lesson.lessoncompose.model.SecondUiState
import javax.inject.Inject


@HiltViewModel
class SecondViewModel @Inject constructor(private val repository: SecondRepository) : ViewModel() {

    val uiStateFlow = MutableStateFlow(SecondUiState())

    fun onEventDispatch(secondIntent: SecondIntent){
        when(secondIntent){
            SecondIntent.Random -> {
//                uiStateFlow.value = uiStateFlow.value.copy(loading = true)
                reduce { state -> state.copy(loading = true) }

                repository.getCatByCode().onEach {
                    reduce { state -> state.copy(loading = false, image = it.message) }
//                   uiStateFlow.value = uiStateFlow.value.copy(image = it.message, loading = false)
                }.launchIn(viewModelScope)
            }
        }
    }


    private fun reduce(block : (SecondUiState) -> SecondUiState){
        val oldState = uiStateFlow.value
        val newState = block(oldState)
        uiStateFlow.value = newState
    }

}