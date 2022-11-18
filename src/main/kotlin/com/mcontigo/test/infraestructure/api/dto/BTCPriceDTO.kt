package com.mcontigo.test.infraestructure.api.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class BTCPriceDTO(
    val price: BigDecimal?,
    val lastUpdate: LocalDateTime?,
    val fiatType: String?
)

