package com.noor.fakeshopestore.domain.entities.main


import com.google.gson.annotations.SerializedName

data class Cart(
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("products")
    val products: List<ProductInCart>? = listOf(),
    @SerializedName("userId")
    val userId: Int? = 0,
    @SerializedName("__v")
    val v: Int? = 0
)