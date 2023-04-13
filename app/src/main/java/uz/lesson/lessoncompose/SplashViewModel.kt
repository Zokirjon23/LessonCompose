package uz.lesson.lessoncompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.lesson.lessoncompose.ui.theme.SecondScreen
import uz.lesson.lessoncompose.ui.theme.navigator.Navigator
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val navigator: Navigator) : ViewModel() {


    init {
        viewModelScope.launch {
            delay(3000)
            navigator.navigateTo(SecondScreen())
        }
    }
}