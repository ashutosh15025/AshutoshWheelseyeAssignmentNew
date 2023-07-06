package com.example.ashutosh_assignment2.dataAccess

import com.example.ashutosh_assignment2.models.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY="da64718875b0432ca41f6ddca120d43c"

interface Invoker {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country")country : String, @Query("page")page : Int): Call<News>
    //https://newsapi.org/v2/top-headlines?apiKey=&API_KEY&country=in&page=1
}

