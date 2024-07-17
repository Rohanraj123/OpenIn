package com.health.openin.data.models

import com.google.gson.annotations.SerializedName

data class RecentLink(
    @SerializedName("app"            ) val app            : String,
    @SerializedName("created_at"     ) val created_at     : String,
    @SerializedName("domain_id"      ) val domain_id      : String,
    @SerializedName("is_favourite"   ) val is_favourite   : Boolean,
    @SerializedName("original_image" ) val original_image : String,
    @SerializedName("smart_link"     ) val smart_link     : String,
    @SerializedName("thumbnail"      ) val thumbnail      : Any,
    @SerializedName("times_ago"      ) val times_ago      : String,
    @SerializedName("title"          ) val title          : String,
    @SerializedName("total_clicks"   ) val total_clicks   : Int,
    @SerializedName("url_id"         ) val url_id         : Int,
    @SerializedName("url_prefix"     ) val url_prefix     : Any,
    @SerializedName("url_suffix"     ) val url_suffix     : String,
    @SerializedName("web_link"       ) val web_link       : String
)