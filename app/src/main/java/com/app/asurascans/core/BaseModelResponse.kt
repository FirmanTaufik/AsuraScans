package com.app.asurascans.core

import com.google.gson.annotations.SerializedName

interface BaseModelResponse {

    var retcode: Long
    var message: String
    var meta: Meta?

    data class Meta(

        @SerializedName("request_id") var requestId: String? = null,
        @SerializedName("timestamp") var timestamp: Long? = null,
        @SerializedName("process_time") var processTime: String? = null,
        @SerializedName("page") var page: Int? = null,
        @SerializedName("page_size") var pageSize: Int? = null,
        @SerializedName("total_page") var totalPage: Int? = null,
        @SerializedName("total_record") var totalRecord: Int? = null

    )

}