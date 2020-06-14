package com.instagram.screen.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.instagram.R
import com.instagram.data.News
import com.instagram.screen.base.adapter.BaseRecyclerAdapter
import com.instagram.screen.base.adapter.BaseViewHolder
import com.instagram.screen.base.adapter.OnItemClickListener
import kotlinx.android.synthetic.main.item_news.view.*

class NewsRecyclerAdapter(
    private val onItemClickListener: OnItemClickListener<News>,
    private val onItemClickListenerNews: OnItemClickListenerNews
)
    : BaseRecyclerAdapter<News, CounterpartsViewHolder>() {

    interface OnItemClickListenerNews {
        fun onClickLocation(item: News, position: Int)
        fun onClickOptions(item: News, position: Int)
        fun onClickLiked(item: News, position: Int)
        fun onClickComment(item: News, position: Int)
        fun onClickSend(item: News, position: Int)
        fun onClickBookmark(item: News, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CounterpartsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return CounterpartsViewHolder(view, onItemClickListener, onItemClickListenerNews)
    }
}

class CounterpartsViewHolder(
    itemView: View,
    private val onItemClickListener: OnItemClickListener<News>,
    private val onItemClickListenerNews: NewsRecyclerAdapter.OnItemClickListenerNews
)
    : BaseViewHolder<News>(itemView) {

    private lateinit var item: News

    init {
        itemView.setOnClickListener { onItemClickListener.onItemClick(item, layoutPosition) }
    }

    override fun bindItem(item: News) {
        this.item = item

        itemView.image_photo_IN.setImageResource(item.getPhotoID(itemView.context))
        itemView.image_photos_IN.setImageResource(item.getPhotosID(itemView.context))
        itemView.text_name_IN.text = item.name
        itemView.text_location_IN.text = item.location
        itemView.text_liked_IN.text = item.getLiked(itemView.context)
        itemView.text_view_time_ago_IN.text = item.time

        itemView.container_location_IN.setOnClickListener {
            onItemClickListenerNews.onClickLocation(item, layoutPosition)
        }

        itemView.image_button_options_IN.setOnClickListener {
            onItemClickListenerNews.onClickOptions(item, layoutPosition)
        }

        itemView.image_button_liked_IN.setOnClickListener {
            onItemClickListenerNews.onClickLiked(item, layoutPosition)
        }

        itemView.image_button_comment_IN.setOnClickListener {
            onItemClickListenerNews.onClickComment(item, layoutPosition)
        }

        itemView.image_button_send_IN.setOnClickListener {
            onItemClickListenerNews.onClickSend(item, layoutPosition)
        }

        itemView.image_button_bookmark_IN.setOnClickListener {
            onItemClickListenerNews.onClickBookmark(item, layoutPosition)
        }
    }
}