package com.noor.fakeshopestore.data.repositery

import com.noor.fakeshopestore.data.remote.RetrofitClient
import com.noor.fakeshopestore.data.remote.ShopApiService

object ShopRepository {

    val shopApiServices: ShopApiService by lazy {
        RetrofitClient.shopApiServices
    }


}