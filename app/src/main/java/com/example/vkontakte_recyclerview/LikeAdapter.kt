package com.example.vkontakte_recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import de.hdodenhof.circleimageview.CircleImageView

class LikeAdapter(var context: Context,
                  private val mData: List<FeedModel>,
                  private val listener: ItemClickListener?,
                  private val fragmentLikeListener: FragmentLikeListener?) : RecyclerView.Adapter<LikeAdapter.MyViewHolder>() {
    var likee = true
    var glide: RequestManager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vk_feed, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val feedModel = mData[getItemViewType(position)]
        glide.load(mData[position].uploaderpic).into(holder.uploader)
        glide.load(mData[position].postpic).into(holder.post)
        holder.uploadername.text = feedModel.name
        holder.posttime.text = feedModel.time
        holder.likes.text = feedModel.likes
        holder.comments.text = feedModel.comments
        holder.shares.text = feedModel.shares
        holder.views.text = feedModel.views
        holder.postText.text = feedModel.postText
        holder.like.setImageResource(R.drawable.passion)
        holder.like.setOnClickListener { fragmentLikeListener?.removeItemLike(feedModel) }
        holder.itemView.setOnClickListener { listener?.ItemClick(position, feedModel) }
        if (likee == true) {
            holder.like.setImageResource(R.drawable.passion)
            likee = false
        } else holder.like.setImageResource(R.drawable.heart)
        likee = true
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    interface ItemClickListener {
        fun ItemClick(position: Int, item: FeedModel?)
        fun likeClick(position: Int, item: FeedModel?)
    }

    interface FragmentLikeListener {
        fun removeItemLike(feedModel: FeedModel?)
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
        var like: ImageView
        fun getItemViewType(position: Int): Int {
            return position
        }

        init {
            uploadername = itemView.findViewById(R.id.user_name)
            posttime = itemView.findViewById(R.id.post_time)
            likes = itemView.findViewById(R.id.cnt_like)
            postText = itemView.findViewById(R.id.post_text)
            comments = itemView.findViewById(R.id.cnt_comment)
            shares = itemView.findViewById(R.id.cnt_shares)
            views = itemView.findViewById(R.id.cnt_view)
            like = itemView.findViewById(R.id.like)
            uploader = itemView.findViewById<View>(R.id.user_avatar) as CircleImageView
            post = itemView.findViewById(R.id.post_pic)
        }
    }

    init {
        glide = Glide.with(context)
    }
}