package uz.lesson.lessoncompose

import uz.lesson.lessoncompose.ui.theme.SecondScreen
import uz.lesson.lessoncompose.ui.theme.navigator.Navigator
import javax.inject.Inject

class SplashDirectionImpl @Inject constructor(private val navigator: Navigator) : SplashDirection {

   override suspend fun openSecond(){
        navigator.navigateTo(SecondScreen())
    }


}