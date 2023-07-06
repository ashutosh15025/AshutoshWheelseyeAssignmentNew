package com.example.ashutosh_assignment2.service

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ashutosh_assignment2.R
import com.example.ashutosh_assignment2.dataAccess.Invoker
import com.example.ashutosh_assignment2.models.News
import com.example.ashutosh_assignment2.viewmodel.NewsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
const val Baseurl="https://newsapi.org/"

open class NewsService : NewsServiceInterface, AppCompatActivity(){
    lateinit var adapter: NewsAdapter
    lateinit var recylclerview : RecyclerView

    override fun getNews() {
        val news: Call<News> = DataService.newsInstance.getHeadlines("in",1)
        news.enqueue(object: Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {

                val news : News? = response.body()
                if(news!=null){
                    adapter= NewsAdapter(this@NewsService,news.articles)
                    recylclerview=findViewById(R.id.NewsList);
                    recylclerview.adapter=adapter;
                    recylclerview.layoutManager = LinearLayoutManager(this@NewsService)
                    Log.d("Done", "onResponse: No Error ")
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Done", "onResponse:  Error fetching"+t.message.toString())
            }
        })
    }
}

object DataService{
    val newsInstance: Invoker
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(com.example.ashutosh_assignment2.service.Baseurl)
            .addConverterFactory(GsonConverterFactory.create()).build()
        newsInstance = retrofit.create(Invoker::class.java)
    }
}