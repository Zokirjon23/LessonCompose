package uz.lesson.lessoncompose

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.lesson.lessoncompose.model.Dog
import javax.inject.Inject

class SecondRepositoryImpl @Inject constructor (private val api: Api) : SecondRepository {
    override fun getCatByCode() : Flow<Dog> {
        return flow {
            val result = api.getCatByCode()
            Log.d("GGGG", "getCatByCode: ${result.isSuccessful}")
           emit(result.body()!!)
        }.catch {
            Log.d("GGGG", "getCatByCodeError: ${it.message}")
        }.flowOn(Dispatchers.IO)
    }


}