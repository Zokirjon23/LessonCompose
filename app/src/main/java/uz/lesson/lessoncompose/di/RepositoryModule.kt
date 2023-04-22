package uz.lesson.lessoncompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.lesson.lessoncompose.SecondRepository
import uz.lesson.lessoncompose.SecondRepositoryImpl


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindSecond(impl: SecondRepositoryImpl): SecondRepository
}