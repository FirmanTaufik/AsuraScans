package com.app.asurascans.di


import android.content.Context
import android.util.Log
import androidx.room.Room
import com.app.asurascans.services.ApiService
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.Interceptor


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    /*@Singleton
    @Provides
    fun providePreferences(@ApplicationContext context: Context): PreferencesClient {
        return PreferencesImp(context)
    }*/

    @Singleton
    @Provides
    fun providesRetrofit(
        @ApplicationContext context: Context
       /* providePreferences: PreferencesClient*/
    ): Retrofit {
        return Retrofit.Builder()
            //.baseUrl(BuildConfig.BASE_URL)
            //.client(okHttp(context, providePreferences))
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


//    private fun okHttp(context: Context, providePreferences: PreferencesClient): OkHttpClient {
//        val logging = HttpLoggingInterceptor()
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//        val okHttp = OkHttpClient.Builder()
//            .connectTimeout(60, TimeUnit.MINUTES)
//            .readTimeout(60, TimeUnit.MINUTES)
//            .writeTimeout(60, TimeUnit.MINUTES)
//            .addInterceptor(logging)
//            .addInterceptor(Interceptor { chain ->
//                val token = providePreferences.getApiKey() ?: BuildConfig.API_KEY
//                val baseUrl = providePreferences.getBaseUrl()
//                Log.d("FirmanTAG ", "hasil  bae url $baseUrl")
//
//                var url = chain.request().url.toString()
//                if (!url.endsWith("json")) {
//                    val ep = url.substringAfter(BuildConfig.BASE_URL)
//                    url = baseUrl+ep
//                }
//
//                val newRequest = chain.request().newBuilder()
//                    .addHeader("X-key", token)
//                    .addHeader("Accept", "application/json")
//                    .url(url)
//                    .build()
//                chain.proceed(newRequest)
//            })
//
//        /* .addInterceptor { chain ->
//             val request = run {
//                 val token = providePreferences.getApiKey() ?: BuildConfig.API_KEY
//                 chain.request().newBuilder()
//                     .addHeader("X-key", token)
//                     .addHeader("Accept", "application/json")
//                     .build()
//             }
//             chain.proceed(request)
//         }*/
//        if (BuildConfig.DEBUG) {
//            context.apply {
//                okHttp.addInterceptor(
//                    ChuckerInterceptor.Builder(this)
//                        .collector(ChuckerCollector(this))
//                        .maxContentLength(250000L)
//                        .redactHeaders(emptySet())
//                        .alwaysReadResponseBody(false)
//                        .build()
//                )
//            }
//
//        }
//        return okHttp.build()
//    }




}