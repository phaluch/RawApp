package com.rawenterprises.rawapp.di

import com.rawenterprises.rawapp.domain.Avaliation
import com.rawenterprises.rawapp.domain.Produto
import com.rawenterprises.rawapp.domain.RawUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


@Module
@InstallIn(SingletonComponent::class)
class RawAppModule {

    @Provides
    fun provideRetrofit() : Retrofit {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl("https://raw-api.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideRawAppService(retrofit: Retrofit) : RawAppService {
        return retrofit.create(RawAppService::class.java)
    }

    interface RawAppService{

        /** @GET("produtos")
        @Headers("Content-Type: application/json")
        suspend fun getProducts(): dataGetProdutos */


        /************
         * PRODUTOS *
         ***********/

        @GET("produtos")
        @Headers("Content-Type: application/json")
        suspend fun getProducts(): List<Produto>

        @GET("produtosBySubstring")
        @Headers("Content-Type: application/json")
        /** ------------ > Data */
        suspend fun getProductsBySubstring(): List<Produto>

        /************
         * USERS *
         ***********/

        @GET("user")
        @Headers("Content-Type: application/json")
        /** ------------ > Data */
        suspend fun getUserByEmail(@Query("email") email : String): RawUser

        @POST("user")
        @Headers("Content-Type: application/json")
        /** ------------ > Data */
        suspend fun postCreateUser(@Body userData: RawUser): RawUser

        /************
         * REVIEWS *
         ***********/

        @GET("user/avaliations")
        @Headers("Content-Type: application/json")
        /** ------------ > Data */
        suspend fun getReviewsByUserEmail(@Query("email") email : String): List<Avaliation>

        @GET("avaliations")
        @Headers("Content-Type: application/json")
        /** ------------ > Data */
        suspend fun getReviewsByProductId(): List<Avaliation>

        @POST("avaliations")
        @Headers("Content-Type: application/json")
        /** ------------ > Data */
        suspend fun writeReviewsByProductId(): List<Avaliation>

        @PUT("user")
        @Headers("Content-Type: application/json")
        suspend fun putUser(@Body userData: RawUser)









    }
}
