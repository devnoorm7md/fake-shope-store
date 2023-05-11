package com.noor.fakeshopestore.data.repositery

import com.google.gson.Gson
import com.noor.fakeshopestore.data.remote.RetrofitClient
import com.noor.fakeshopestore.data.remote.ShopApiService
import com.noor.fakeshopestore.domain.entities.main.Product
import com.noor.fakeshopestore.domain.entities.wrappers.Response
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

object ShopRepository {

    private val shopApiServices: ShopApiService by lazy {
        RetrofitClient.shopApiServices
    }

    fun fetchProducts(limit: Int? = null) =
        shopApiServices.getProducts(limit).map { it.data.results }

    fun fetchSingleProduct(id: Int) =
        shopApiServices.getSingleProduct(id).map { it.data.results }

    fun fetchCategories() =
        shopApiServices.getCategories().map { it.data.results }

    fun fetchProductByCategory(category: String) =
        shopApiServices.getProductsByCategory(category).map { it.data.results }

    fun fetchUserCartProducts(id: Int) =
        shopApiServices.getUserCartProducts(id).map { it.data.results }

    fun createProduct(product: Product, imageFile: File): Single<Response<Product>> {
        val productRequestBody =
            Gson().toJson(product).toRequestBody("application/json".toMediaTypeOrNull())
        val imageRequestBody = imageFile.asRequestBody("image/*".toMediaTypeOrNull())
        val imagePart = MultipartBody.Part.createFormData("image", imageFile.name, imageRequestBody)
        return shopApiServices.createProduct(productRequestBody, imagePart)
            .map { it }
    }

    fun deleteItem(id: Int) = shopApiServices.deleteProduct(id)
        .onErrorResumeNext { throwable: Throwable ->
        Completable.error(throwable)
    }


}