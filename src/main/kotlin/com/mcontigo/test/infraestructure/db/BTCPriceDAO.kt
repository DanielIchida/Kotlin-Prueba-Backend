package com.mcontigo.test.infraestructure.db

import com.mcontigo.test.domain.enumerations.FiatType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BTCPriceDAO : JpaRepository<BTCPriceEntity,Int>{
    @Query("SELECT b FROM BTCPriceEntity b WHERE b.fiatType = ?1 ORDER BY b.last_update DESC LIMIT 1")
    fun findByFiatType(fiatType: FiatType): Optional<BTCPriceEntity>

    @Query("SELECT b FROM BTCPriceEntity b ORDER BY b.last_update DESC")
    fun findAllOrderLastUpdate(): List<BTCPriceEntity>
}