package com.mcontigo.test.domain.models

import com.mcontigo.test.domain.enumerations.FiatType
import java.math.BigDecimal
import java.time.LocalDateTime

data class BTCPrice(
    val id: Int?,
    val price: BigDecimal?,
    val lastUpdate: LocalDateTime?,
    val fiatType: FiatType?
){
    companion object{
        fun create(price: BigDecimal?, lastUpdate: LocalDateTime?, fiatType: FiatType?) : BTCPrice{
            return BTCPrice(0,price,lastUpdate,fiatType)
        }
    }
}