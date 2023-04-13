package uz.lesson.lessoncompose.ui.theme.navigator

import cafe.adriel.voyager.androidx.AndroidScreen
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorImpl @Inject constructor() : Navigator,NavigationDispatcher {
    override val dispatcher = MutableSharedFlow<NavigationArgs>()

    private suspend fun navigate(screen: NavigationArgs){
        dispatcher.emit(screen)
    }

    override suspend fun navigateTo(screen: AndroidScreen) = navigate {
        push(screen)
    }

    override suspend fun back() = navigate {
        pop()
    }


}