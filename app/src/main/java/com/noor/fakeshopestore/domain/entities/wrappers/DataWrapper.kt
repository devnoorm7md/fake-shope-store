package com.noor.fakeshopestore.domain.entities.wrappers

import java.io.Serializable

data class DataWrapper<T>(
    val results: List<T>,
    val status: Int,
    val message: String?,
):Serializable
