package com.app.asurascans.ui.screen.read

import com.app.asurascans.core.BaseModelResponse
import com.google.gson.annotations.SerializedName

data class ReadModelResponse(
    override var retcode: Long,
    override var message: String,
    override var meta: BaseModelResponse.Meta?,

    @SerializedName("data"    ) var data    : Data?   = Data()
):BaseModelResponse {

    data class Data (

        @SerializedName("chapter_id"          ) var chapterId         : String?           = null,
        @SerializedName("series_id"           ) var seriesId          : String?           = null,
        @SerializedName("chapter_number"      ) var chapterNumber     : Int?              = null,
        @SerializedName("base_domain"         ) var baseDomain        : String?           = null,
        @SerializedName("chapter_title"       ) var chapterTitle      : String?           = null,
        @SerializedName("chapter_images"      ) var chapterImages     : ArrayList<String> = arrayListOf(),
        @SerializedName("thumbnail_image_url" ) var thumbnailImageUrl : String?           = null,
        @SerializedName("path_images"         ) var pathImages        : String?           = null,
        @SerializedName("view_count"          ) var viewCount         : Int?              = null,
        @SerializedName("prev_chapter_id"     ) var prevChapterId     : String?           = null,
        @SerializedName("prev_chapter_number" ) var prevChapterNumber : String?           = null,
        @SerializedName("next_chapter_id"     ) var nextChapterId     : String?           = null,
        @SerializedName("next_chapter_number" ) var nextChapterNumber : Int?              = null,
        @SerializedName("created_at"          ) var createdAt         : String?           = null,
        @SerializedName("updated_at"          ) var updatedAt         : String?           = null

    )
}
