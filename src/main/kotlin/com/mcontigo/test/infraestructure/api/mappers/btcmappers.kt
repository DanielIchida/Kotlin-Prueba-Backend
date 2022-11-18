package com.mcontigo.test.infraestructure.api.mappers

import com.mcontigo.test.domain.models.BTCPrice
import com.mcontigo.test.infraestructure.api.dto.BTCPriceDTO

fun BTCPrice.toDto() : BTCPriceDTO =
    BTCPriceDTO(
        price = price,
        lastUpdate = lastUpdate,
        fiatType = fiatType?.name
)