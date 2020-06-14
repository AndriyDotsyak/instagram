package com.instagram.screen.home

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.instagram.R
import com.instagram.data.News
import com.instagram.screen.base.BaseActivity
import com.instagram.screen.base.adapter.OnItemClickListener
import com.instagram.screen.home.adapter.NewsRecyclerAdapter
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject lateinit var homeViewModel: HomeViewModel
    lateinit var newsAdapter: NewsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupRecyclerView()
        addItemsRecyclerView()
    }

    private fun setupRecyclerView() {
        recycler_AH.layoutManager = LinearLayoutManager(this.applicationContext)
        newsAdapter = NewsRecyclerAdapter(onItemClickListener, onItemClickListenerNews)
        recycler_AH.adapter = newsAdapter

        val decoration = DividerItemDecoration(recycler_AH.context, LinearLayoutManager.VERTICAL)
        recycler_AH.addItemDecoration(decoration)
    }

    private fun addItemsRecyclerView() {
        newsAdapter.addItems(homeViewModel
            .jsonToObject(getNewsJSON(), Array<News>::class.java).toList())
    }

    private val onItemClickListener = object : OnItemClickListener<News> {
        override fun onItemClick(item: News, position: Int) {
            showToast("On click item: $position")
        }
    }

    private val onItemClickListenerNews = object : NewsRecyclerAdapter.OnItemClickListenerNews {
        override fun onClickLocation(item: News, position: Int) {
            showToast("On click location: ${item.location}")
        }

        override fun onClickOptions(item: News, position: Int) {
            showToast("On click options item: $position")
        }

        override fun onClickLiked(item: News, position: Int) {
            showToast("On click liked item: $position")
        }

        override fun onClickComment(item: News, position: Int) {
            showToast("On click comment item: $position")
        }

        override fun onClickSend(item: News, position: Int) {
            showToast("On click send item: $position")
        }

        override fun onClickBookmark(item: News, position: Int) {
            showToast("On click bookmark item: $position")
        }

    }

    private fun getNewsJSON() = resources.openRawResource(R.raw.news).bufferedReader().use { it.readText() }
}