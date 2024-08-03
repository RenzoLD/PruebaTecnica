package com.example.pruebatcnica_lvlconsulting.di

import com.example.pruebatcnica_lvlconsulting.BuildConfig
import com.example.pruebatcnica_lvlconsulting.data.ApiService
import com.example.pruebatcnica_lvlconsulting.data.datasource.PlaceRepositoryImpl
import com.example.pruebatcnica_lvlconsulting.domain.repository.PlaceRepository
import com.example.pruebatcnica_lvlconsulting.domain.usecase.GetPlacesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        apikey: String,
        apiService: ApiService
    ): PlaceRepository {
        return PlaceRepositoryImpl(apiService, apikey)
    }

    @Provides
    @Singleton
    fun provideApiKey(): String {
        return BuildConfig.API_KEY
    }

    @Provides
    @Singleton
    fun provideGetPlacesUseCase(
        placeRepository: PlaceRepository
    ): GetPlacesUseCase {
        return GetPlacesUseCase(placeRepository)
    }
}
