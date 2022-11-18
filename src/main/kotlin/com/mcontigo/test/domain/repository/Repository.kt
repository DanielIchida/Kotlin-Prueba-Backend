package com.mcontigo.test.domain.repository

import com.mcontigo.test.domain.enumerations.FiatType
import com.mcontigo.test.domain.models.BTCPrice
import java.math.BigDecimal
import java.time.LocalDateTime

/*
You should implement this interface to interact with persistence
If you prefer, can use any ORM library
*/
interface RepositoryDB {
    fun fetchAll(): List<BTCPrice>
    fun fetchByFiat(fiatType: FiatType): BTCPrice
    fun registerBTCPrice(fiatType: FiatType?, price: BigDecimal?, registerAt: LocalDateTime?)
}

/*
 You should implement this based on coindesk request from https://api.coindesk.com/v1/bpi/currentprice.json
 */
interface RepositoryExternal {
    fun fetchCurrentPrice(): List<BTCPrice?>
}