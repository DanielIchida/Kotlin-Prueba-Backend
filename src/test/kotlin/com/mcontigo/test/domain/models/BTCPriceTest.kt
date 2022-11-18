package com.mcontigo.test.domain.models

import com.mcontigo.test.domain.enumerations.FiatType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDateTime


internal class BTCPriceTest{

    private lateinit var btcPrice: BTCPrice

    @BeforeEach
    fun init(){
        btcPrice = BTCPrice.create(BigDecimal(10.0), LocalDateTime.now(),FiatType.USD)
    }

    @Test
    fun validateDataModel(){
        assertEquals(btcPrice.fiatType,FiatType.USD)
    }

}