package com.health.openin.data.models

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("favourite_links"   ) val favourite_links    : List<Any>,
    @SerializedName("overall_url_chart" ) val overall_url_chart  : Map<String, Int>?,
    @SerializedName("recent_links"      ) val recent_links       : List<RecentLink>,
    @SerializedName("top_links"         ) val top_links          : List<TopLink>
)