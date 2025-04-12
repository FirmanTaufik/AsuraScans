package com.app.asurascans.ui.screen.detail

import com.app.asurascans.core.BaseModelResponse
import com.google.gson.annotations.SerializedName

data class CommentModelResponse(
    override var retcode: Long,
    override var message: String,
    override var meta: BaseModelResponse.Meta?,
    @SerializedName("data"    ) var data    : ArrayList<Data> = arrayListOf()
):BaseModelResponse {
    data class Data (

        @SerializedName("comment_id"   ) var commentId   : String?      = null,
        @SerializedName("comment_user" ) var commentUser : CommentUser? = CommentUser(),
        @SerializedName("content"      ) var content     : String?      = null,
        @SerializedName("like"         ) var like        : Int?         = null,
        @SerializedName("replies"      ) var replies     : Int?         = null,
        @SerializedName("created_at"   ) var createdAt   : String?      = null

    )



    data class CommentUser (

        @SerializedName("user_id"      ) var userId      : String?  = null,
        @SerializedName("user_name"    ) var userName    : String?  = null,
        @SerializedName("user_image"   ) var userImage   : String?  = null,
        @SerializedName("user_badge"   ) var userBadge   : String?  = null,
        @SerializedName("user_lv"      ) var userLv      : Int?     = null,
        @SerializedName("user_premium" ) var userPremium : Boolean? = null

    )
}
