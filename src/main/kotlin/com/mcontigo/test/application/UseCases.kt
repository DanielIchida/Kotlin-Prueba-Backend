package com.mcontigo.test.application

import com.mcontigo.test.domain.enumerations.FiatType
import com.mcontigo.test.domain.models.BTCPrice

interface UseCases {
    fun fetchAll(): List<BTCPrice>?
    fun fetchBtcPriceByFiat(type: FiatType): BTCPrice?
    fun syncBtcPrice()
}