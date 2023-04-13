package uz.lesson.lessoncompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.lesson.lessoncompose.ui.theme.navigator.NavigationDispatcher
import uz.lesson.lessoncompose.ui.theme.navigator.Navigator
import uz.lesson.lessoncompose.ui.theme.navigator.NavigatorImpl


@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun provideNavigator(impl : NavigatorImpl) : Navigator

    @Binds
    fun provideNavigationDispatcher(impl : NavigatorImpl) : NavigationDispatcher

}