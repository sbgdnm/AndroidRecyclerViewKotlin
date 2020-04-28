package com.example.vkontakte_recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.vkontakte_recyclerview.FeedDetailActivity
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerViewAdapterFeed<ItemClickListener>(var context: Context, private val mData: List<FeedModel>) : RecyclerView.Adapter<RecyclerViewAdapterFeed.MyViewHolder>() {
    var glide: RequestManager
    private val listener: ItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.vk_feed, null, false)
        val params = RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.layoutParams = params
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val feedModel = mData[getItemViewType(position)]
        holder.uploadername.text = mData[position].name
        holder.posttime.text = mData[position].time
        holder.likes.text = mData[position].likes
        holder.comments.text = mData[position].comments
        holder.shares.text = mData[position].shares
        holder.views.text = mData[position].views
        holder.postText.text = mData[position].postText
        holder.itemView.setOnClickListener {
            val detailActivity = Intent(context, FeedDetailActivity::class.java)
            detailActivity.putExtra(FeedDetailActivity.EXTRA_DETAIL, mData[position])
            context.startActivity(detailActivity)
        }
        glide.load(mData[position].uploaderpic).into(holder.uploader)
        glide.load(mData[position].postpic).into(holder.post)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var uploadername: TextView
        var posttime: TextView
        var postText: TextView
        var likes: TextView
        var comments: TextView
        var shares: TextView
        var views: TextView
        var uploader: CircleImageView
        var post: ImageView

        init {
            uploadername = itemView.findViewById(R.id.user_name)
            posttime = itemView.findViewById(R.id.post_time)
            likes = itemView.findViewById(R.id.cnt_like)
            postText = itemView.findViewById(R.id.post_text)
            comments = itemView.findViewById(R.id.cnt_comment)
            shares = itemView.findViewById(R.id.cnt_shares)
            views = itemView.findViewById(R.id.cnt_view)
            uploader = itemView.findViewById(R.id.user_avatar)
            post = itemView.findViewById(R.id.post_pic)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    internal interface ItemClickListener {
        fun ItemClick(position: Int, item: FeedModel?)
    }

    init {
        glide = Glide.with(context)
    }
}