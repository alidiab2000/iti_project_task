package com.alidiab.myapplication.core.model.response

import com.alidiab.myapplication.core.model.Post
import com.alidiab.myapplication.core.model.Support
import com.google.gson.annotations.SerializedName

data class ResponseUserList(
    @SerializedName("page"        ) var page       : Int,
    @SerializedName("per_page"    ) var perPage    : Int,
    @SerializedName("total"       ) var total      : Int,
    @SerializedName("total_pages" ) var totalPages : Int,
    @SerializedName("data"        ) var data       : List<Post>,
    @SerializedName("support"     ) var support    : Support
    )