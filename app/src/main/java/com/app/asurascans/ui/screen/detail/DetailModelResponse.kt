package com.app.asurascans.ui.screen.detail

import com.app.asurascans.core.BaseModelResponse
import com.google.gson.annotations.SerializedName

data class DetailModelResponse(
    override var retcode: Long,
    override var message: String,
    override var meta: BaseModelResponse.Meta?,
    @SerializedName("data"             ) var data            : Data?             = null
):BaseModelResponse {

    data class Data (

        @SerializedName("series_id"             ) var seriesId            : String?             = null,
        @SerializedName("title"                 ) var title               : String?             = null,
        @SerializedName("description"           ) var description         : String?             = null,
        @SerializedName("alternative_title"     ) var alternativeTitle    : String?             = null,
        @SerializedName("release_year"          ) var releaseYear         : String?             = null,
        @SerializedName("status"                ) var status              : Int?                = null,
        @SerializedName("cover_image_url"       ) var coverImageUrl       : String?             = null,
        @SerializedName("portrait_image_url"    ) var portraitImageUrl    : String?             = null,
        @SerializedName("view_count"            ) var viewCount           : Int?                = null,
        @SerializedName("user_rating"           ) var userRating          : Int?                = null,
        @SerializedName("latest_chapter_id"     ) var latestChapterId     : String?             = null,
        @SerializedName("latest_chapter_number" ) var latestChapterNumber : Int?                = null,
        @SerializedName("latest_chapter_time"   ) var latestChapterTime   : String?             = null,
        @SerializedName("type"                  ) var type                : String?             = null,
        @SerializedName("bookmark_count"        ) var bookmarkCount       : Int?                = null,
        @SerializedName("rank"                  ) var rank                : Int?                = null,
        @SerializedName("taxonomy"              ) var taxonomy            : Taxonomy?           = Taxonomy(),
        @SerializedName("created_at"            ) var createdAt           : String?             = null,
        @SerializedName("updated_at"            ) var updatedAt           : String?             = null,
        @SerializedName("deleted_at"            ) var deletedAt           : String?             = null,
        @SerializedName("chapters"              ) var chapters            : ArrayList<Chapters> = arrayListOf()

    )
    data class Artist (

        @SerializedName("taxonomy_key" ) var taxonomyKey : String? = null,
        @SerializedName("name"         ) var name        : String? = null

    )
    data class Author (

        @SerializedName("taxonomy_key" ) var taxonomyKey : String? = null,
        @SerializedName("name"         ) var name        : String? = null

    )
    data class Genre (

        @SerializedName("taxonomy_key" ) var taxonomyKey : String? = null,
        @SerializedName("name"         ) var name        : String? = null

    )
    data class Taxonomy (

        @SerializedName("Artist" ) var Artist : ArrayList<Artist> = arrayListOf(),
        @SerializedName("Author" ) var Author : ArrayList<Author> = arrayListOf(),
        @SerializedName("Genre"  ) var Genre  : ArrayList<Genre>  = arrayListOf()

    )
    data class Chapters (

        @SerializedName("chapter_id"          ) var chapterId         : String? = null,
        @SerializedName("chapter_title"       ) var chapterTitle      : String? = null,
        @SerializedName("chapter_number"      ) var chapterNumber     : Int?    = null,
        @SerializedName("thumbnail_image_url" ) var thumbnailImageUrl : String? = null,
        @SerializedName("view_count"          ) var viewCount         : Int?    = null,
        @SerializedName("updated_at"          ) var updatedAt         : String? = null

    )
}
