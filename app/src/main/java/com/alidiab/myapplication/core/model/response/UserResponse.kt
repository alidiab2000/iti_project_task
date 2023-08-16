package com.alidiab.myapplication.core.model.response

import com.google.gson.annotations.SerializedName

data class UserResponse (

    @SerializedName("id"        ) var id        : Int?    = null,
    @SerializedName("username"  ) var username  : String? = null,
    @SerializedName("email"     ) var email     : String? = null,
    @SerializedName("firstName" ) var firstName : String? = null,
    @SerializedName("lastName"  ) var lastName  : String? = null,
    @SerializedName("gender"    ) var gender    : String? = null,
    @SerializedName("image"     ) var image     : String? = null,
    @SerializedName("token"     ) var token     : String? = null

)