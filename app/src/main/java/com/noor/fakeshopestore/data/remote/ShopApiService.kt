package com.noor.fakeshopestore.data.remote

import com.noor.fakeshopestore.domain.entities.Cart
import com.noor.fakeshopestore.domain.entities.Product
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ShopApiService {

    @GET("products")
    fun getProducts(@Query("limit") limit: Int): Single<Response<List<Product>>>

    @GET("products/{id}")
    fun getSingleProduct(@Path("id") id: Int): Single<Response<Product>>

    @GET("products/categories")
    fun getCategories(): Single<Response<List<String>>>

    @GET("/products")
    fun getProductsByCategory(@Query("category") category: String): Single<Response<List<Product>>>

    @GET("/carts")
    fun getUserCartProducts(@Query("userId") userId: Int): Single<Response<List<Cart>>>

    @POST("/products")
    fun createProduct(@Body product: Product): Single<Response<Product>>

    @PUT("/products/{id}")
    fun updateProduct(@Path("id") id: Int,@Body product: Product ): Single<Response<Product>>

    @PATCH("/products/{id}")
    fun updateCertainProductField(@Path("id") id: Int,@Body product: Product ): Single<Response<Product>>

    @DELETE("/products/{id}")
    fun deleteProduct(@Path("id") id: Int): Completable




}