package com.example.ashutosh_assignment2.viewmodel


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.ashutosh_assignment2.R
import com.example.ashutosh_assignment2.models.Article


class NewsAdapter(val context: Context,val articles:List<Article>):Adapter<NewsAdapter.ArticleViewHolder>() {
    class ArticleViewHolder(itemView: View):ViewHolder(itemView) {
        var newsImage=itemView.findViewById<ImageView>(R.id.NewsImage)
        var newstitle=itemView.findViewById<TextView>(R.id.Newstitle)
        var newsdesc=itemView.findViewById<TextView>(R.id.Newsdescription)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.rowlayout,parent,false);
        return ArticleViewHolder(view);

    }

    override fun getItemCount(): Int {
        return articles.size;
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article=articles[position];
        holder.newstitle.text=article.title;
        holder.newsdesc.text=article.description;
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)

    }
}