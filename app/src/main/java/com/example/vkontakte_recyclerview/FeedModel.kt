package com.example.vkontakte_recyclerview

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

class FeedModel : Parcelable {
    var name: String?
    var time: String?
    var postText: String?
    var likes: String?
    var uploaderpic: Int
    var postpic: Int
    var comments: String?
    var shares: String?
    var views: String?

    constructor(name: String?, time: String?, postText: String?, likes: String?, uploaderpic: Int, postpic: Int, comments: String?, shares: String?, views: String?) {
        this.name = name
        this.time = time
        this.postText = postText
        this.likes = likes
        this.uploaderpic = uploaderpic
        this.postpic = postpic
        this.comments = comments
        this.shares = shares
        this.views = views
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    protected constructor(`in`: Parcel) {
        name = `in`.readString()
        time = `in`.readString()
        postText = `in`.readString()
        likes = `in`.readString()
        uploaderpic = `in`.readInt()
        postpic = `in`.readInt()
        comments = `in`.readString()
        shares = `in`.readString()
        views = `in`.readString()
    }

    override fun toString(): String {
        val sb = StringBuilder("News{")
        sb.append("author='").append(name).append('\'')
        sb.append(", time='").append(time).append('\'')
        sb.append(", posttext='").append(postText).append('\'')
        sb.append(", likes='").append(likes).append("\'")
        sb.append(", uploaderpic='").append(uploaderpic).append("\'")
        sb.append(", postpoc='").append(postpic).append("\'")
        sb.append(", comments='").append(comments).append("\'")
        sb.append(", shares='").append(shares).append("\'")
        sb.append(", views='").append(views).append("\'")
        sb.append('}')
        return sb.toString()
    }

    override fun describeContents(): Int {
        return 0
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(time)
        dest.writeString(postText)
        dest.writeString(likes)
        dest.writeInt(uploaderpic)
        dest.writeInt(postpic)
        dest.writeString(comments)
        dest.writeString(shares)
        dest.writeString(views)
    }

    companion object {
        val CREATOR: Parcelable.Creator<FeedModel> = object : Parcelable.Creator<FeedModel?> {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            override fun createFromParcel(`in`: Parcel): FeedModel? {
                return FeedModel(`in`)
            }

            override fun newArray(size: Int): Array<FeedModel?> {
                return arrayOfNulls(size)
            }
        }
    }
}