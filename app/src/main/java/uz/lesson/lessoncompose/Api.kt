package uz.lesson.lessoncompose

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import uz.lesson.lessoncompose.model.Dog

interface Api {

   @GET("random")
   suspend fun getCatByCode() : Response<Dog>
}