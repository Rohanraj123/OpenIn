package com.health.openin.data.models

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("applied_campaign"        ) val applied_campaign          : Int,
    @SerializedName("data"                    ) val data                      : Data,
    @SerializedName("extra_income"            ) val extra_income              : Double,
    @SerializedName("links_created_today"     ) val links_created_today       : Int,
    @SerializedName("message"                 ) val message                   : String,
    @SerializedName("startTime"               ) val startTime                 : String,
    @SerializedName("status"                  ) val status                    : Boolean,
    @SerializedName("statusCode"              ) val statusCode                : Int,
    @SerializedName("support_whatsapp_number" ) val support_whatsapp_number   : String,
    @SerializedName("today_clicks"            ) val today_clicks              : Int,
    @SerializedName("top_location"            ) val top_location              : String,
    @SerializedName("top_source"              ) val top_source                : String,
    @SerializedName("total_clicks"            ) val total_clicks              : Int,
    @SerializedName("total_links"             ) val total_links               : Int
)