package com.noor.fakeshopestore.domain.entities.main


import com.google.gson.annotations.SerializedName

data class ProductInCart(
    @SerializedName("productId")
    val productId: Int? = null,
    @SerializedName("quantity")
    val quantity: Int? = null
)