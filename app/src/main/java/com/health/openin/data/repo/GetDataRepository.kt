package com.health.openin.data.repo

import com.health.openin.data.models.Response

interface GetDataRepository {
    suspend fun getData(): Result<Response>
}