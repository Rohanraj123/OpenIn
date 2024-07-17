package com.health.openin.di

import android.app.Application
import android.content.Context
import com.health.openin.data.api.RetrofitApi
import com.health.openin.data.repo.GetDataRepository
import com.health.openin.data.repo.GetDataRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.math.log

private const val BASE_URL="https://api.inopenapp.com/api/v1/"

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    @Singleton
    fun providesContext(app: Application) : Context = app.applicationContext

    @Provides
    @Singleton
    fun providesAuthTokenProvider(context: Context): AuthTokenProvider {
        return AuthTokenProvider(context)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        authInterceptor: AuthInterceptor
    ) : OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return try {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        } catch (e : IllegalArgumentException) {
            throw e
        }
    }

    @Provides
    @Singleton
    fun providesRetrofitApi(retrofit: Retrofit): RetrofitApi {
        return try {
            retrofit.create(RetrofitApi::class.java)
        } catch (e : IllegalArgumentException) {
            throw e
        }
    }

    @Provides
    @Singleton
    fun providesGetDataRepository(retrofitApi: RetrofitApi): GetDataRepository {
        return GetDataRepositoryImpl(retrofitApi)
    }
}