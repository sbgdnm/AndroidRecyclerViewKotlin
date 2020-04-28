package com.example.vkontakte_recyclerview

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class FeedDetailActivity : AppCompatActivity() {
    private var context: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        context = this
        val userPic = findViewById<ImageView>(R.id.detail_user_pic)
        val postPic = findViewById<ImageView>(R.id.detail_uploader_pic)
        val userName = findViewById<TextView>(R.id.detail_user_name)
        val time = findViewById<TextView>(R.id.detail_time)
        val postText = findViewById<TextView>(R.id.detail_text)
        val likeCount = findViewById<TextView>(R.id.detail_like_cnt)
        val shareCount = findViewById<TextView>(R.id.detail_share_cnt)
        val viewCount = findViewById<TextView>(R.id.detail_view_cnt)
        val feedModel: FeedModel = intent.getParcelableExtra(EXTRA_DETAIL)
        Glide.with(this).load(feedModel.uploaderpic).into(userPic)
        Glide.with(this).load(feedModel.postpic).into(postPic)
        userName.text = feedModel.name
        time.text = feedModel.time
        postText.text = feedModel.postText
        likeCount.text = feedModel.likes
        shareCount.text = feedModel.shares
        viewCount.text = feedModel.views
        //        String detailName = intent.getStringExtra("name");
//        userName.setText(detailName);
//
//        String detailTime = intent.getStringExtra("time");
//        time.setText(detailTime);
//
//        String detailLikeCount = intent.getStringExtra("likecount");
//        likeCount.setText(detailLikeCount);
//
//
//        String detailShareCount = intent.getStringExtra("sharecount");
//        shareCount.setText(detailShareCount);
//
//        String detailPostText = intent.getStringExtra("posttext");
//        postText.setText(detailPostText);
//
//        String detailViewCount = intent.getStringExtra("viewcount");
//        viewCount.setText(detailViewCount);
//
//        Integer firstKey = intent.getIntExtra("userPic",0);
//        Glide.with(this).load(firstKey).into(userPic);
//
//        Integer secondKey = intent.getIntExtra("postPic",0);
//        Glide.with(this).load(secondKey).into(postPic);
//        userName.setText(feedModel.getName());
//        time.setText(feedModel.getTime());
//        postText.setText(feedModel.getPostText());
//        likeCount.setText(feedModel.getLikes());
//        commentCount.setText(feedModel.getComments());
//        shareCount.setText(feedModel.getShares());
//        viewCount.setText(feedModel.getViews());
    }

    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }
}