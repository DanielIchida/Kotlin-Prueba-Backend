package com.mcontigo.test.infraestructure.api.dto

data class ResponseDTO(
    val msg: String,
    val error: String?,
    val data: Any?
)
