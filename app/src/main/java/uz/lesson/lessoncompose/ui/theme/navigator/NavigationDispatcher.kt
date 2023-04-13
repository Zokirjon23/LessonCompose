package uz.lesson.lessoncompose.ui.theme.navigator

import kotlinx.coroutines.flow.SharedFlow

interface NavigationDispatcher {

    val dispatcher : SharedFlow<NavigationArgs>
}
