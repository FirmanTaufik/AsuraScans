package com.app.asurascans.ui.screen.home

import com.google.gson.annotations.SerializedName

data class UpdateModelResponse(

    @SerializedName("retcode" ) var retcode : Int?    = null,
    @SerializedName("message" ) var message : String? = null,
    @SerializedName("meta"    ) var meta    : Meta?   = Meta(),
    @SerializedName("data"    ) var data    : Data?   = Data()
){


    data class Data (

        @SerializedName("all"    ) var all    : ArrayList<List>    = arrayListOf(),
        @SerializedName("manga"  ) var manga  : ArrayList<List>  = arrayListOf(),
        @SerializedName("manhwa" ) var manhwa : ArrayList<List> = arrayListOf(),
        @SerializedName("manhua" ) var manhua : ArrayList<List> = arrayListOf()

    )

    data class Meta (

        @SerializedName("request_id"   ) var requestId   : String? = null,
        @SerializedName("timestamp"    ) var timestamp   : Int?    = null,
        @SerializedName("process_time" ) var processTime : String? = null

    )


    data class List (

        @SerializedName("series_id"             ) var seriesId            : String?           = null,
        @SerializedName("title"                 ) var title               : String?           = null,
        @SerializedName("alternative_title"     ) var alternativeTitle    : String?           = null,
        @SerializedName("release_year"          ) var releaseYear         : String?           = null,
        @SerializedName("status"                ) var status              : Int?              = null,
        @SerializedName("cover_image_url"       ) var coverImageUrl       : String?           = null,
        @SerializedName("portrait_image_url"    ) var portraitImageUrl    : String?           = null,
        @SerializedName("view_count"            ) var viewCount           : Int?              = null,
        @SerializedName("user_rating"           ) var userRating          : Int?              = null,
        @SerializedName("latest_chapter_id"     ) var latestChapterId     : String?           = null,
        @SerializedName("latest_chapter_number" ) var latestChapterNumber : Int?              = null,
        @SerializedName("latest_chapter_time"   ) var latestChapterTime   : String?           = null,
        @SerializedName("chapters"              ) var chapters            : ArrayList<String> = arrayListOf(),
        @SerializedName("type"                  ) var type                : String?           = null,
        @SerializedName("bookmark_count"        ) var bookmarkCount       : Int?              = null,
        @SerializedName("created_at"            ) var createdAt           : String?           = null,
        @SerializedName("updated_at"            ) var updatedAt           : String?           = null,
        @SerializedName("deleted_at"            ) var deletedAt           : String?           = null

    )
}
