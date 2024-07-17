package com.health.openin.data.repo

import android.util.Log
import com.health.openin.data.api.RetrofitApi
import com.health.openin.data.models.Response
import retrofit2.awaitResponse
import javax.inject.Inject

class GetDataRepositoryImpl(
    private val retrofitApi: RetrofitApi
): GetDataRepository {
    override suspend fun getData(): Result<Response> {
        return try {
            val response = retrofitApi.getData().awaitResponse()
            Log.d("RepoImpl", "Response : ${response.body()?.today_clicks}")
            if (response.isSuccessful) {
                val data = response.body()
                if (data != null) {
                    Result.success(data)
                } else {
                    Result.failure(Exception("Response body is null"))
                }
            } else {
                Result.failure(
                    Exception(
                        "Failed to fetch the network data with status code: ${response.code()}"
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}