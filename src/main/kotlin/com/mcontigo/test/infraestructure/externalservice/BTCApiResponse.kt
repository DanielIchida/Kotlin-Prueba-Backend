package com.mcontigo.test.infraestructure.externalservice

import java.math.BigDecimal

data class BTCApiResponse (
    val time: Time,
    val disclaimer: String,
    val chartName: String,
    val bpi: Bpi
)

data class Bpi (
    val usd: Currency,
    val gbp: Currency,
    val eur: Currency
)

data class Currency (
    val code: String,
    val symbol: String,
    val rate: String,
    val description: String,
    val rateFloat: BigDecimal
)

data class Time (
    val updated: String,
    val updatedISO: String,
    val updateduk: String
)