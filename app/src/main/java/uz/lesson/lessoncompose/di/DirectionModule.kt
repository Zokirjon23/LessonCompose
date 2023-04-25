package uz.lesson.lessoncompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.lesson.lessoncompose.SplashDirection
import uz.lesson.lessoncompose.SplashDirectionImpl

@Module
@InstallIn(ViewModelComponent::class)
interface DirectionModule {

    @Binds
    fun bindSplash(impl : SplashDirectionImpl) : SplashDirection
}