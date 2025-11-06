package com.frank.practicehilt.di

import com.frank.practicehilt.common.Config
import com.frank.practicehilt.data.apis.QuestionAPI
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class) // dung chung cho ca ung dung
@Module
object NetworkModule {
    @Provides
    @Singleton //ca ung dung
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
//        if (BuildConfig.DEBUG) {
//            sandbox
//        }
        builder.interceptors().add(httpLoggingInterceptor)
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(): MoshiConverterFactory {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return MoshiConverterFactory.create(moshi)

    }

    @Provides
    @Singleton
    fun provideRetrofitStackOverFlow(
        okHttpClient: OkHttpClient, moshiConverterFactory: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder().addConverterFactory(moshiConverterFactory)
            .baseUrl(Config.StackOverFlowUrl)
            .client(okHttpClient).build()
    }

    @Provides
    fun provideQuestionAPI(retrofit: Retrofit) : QuestionAPI {
        return retrofit.create(QuestionAPI::class.java)
    }
}