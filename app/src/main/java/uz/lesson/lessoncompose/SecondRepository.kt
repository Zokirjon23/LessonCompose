package uz.lesson.lessoncompose

import kotlinx.coroutines.flow.Flow
import uz.lesson.lessoncompose.model.Dog

interface SecondRepository {

    fun getCatByCode(): Flow<Dog>
}