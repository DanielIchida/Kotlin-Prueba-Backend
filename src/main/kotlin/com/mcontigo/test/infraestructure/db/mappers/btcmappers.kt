package com.mcontigo.test.infraestructure.db.mappers

import com.mcontigo.test.domain.models.BTCPrice
import com.mcontigo.test.infraestructure.db.BTCPriceEntity

fun BTCPrice.toEntity() : BTCPriceEntity =
    BTCPriceEntity(
        id = id,
        price = price,
        lastUpdate = lastUpdate,
        fiatType = fiatType
    )

fun BTCPriceEntity.toDomain() : BTCPrice =
    BTCPrice(
        id = id,
        price = price,
        lastUpdate = lastUpdate,
        fiatType = fiatType
    )