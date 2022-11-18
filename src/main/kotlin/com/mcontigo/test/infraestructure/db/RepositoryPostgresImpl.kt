package com.mcontigo.test.infraestructure.db


import com.mcontigo.test.domain.enumerations.FiatType
import com.mcontigo.test.domain.models.BTCPrice
import com.mcontigo.test.domain.repository.RepositoryDB
import com.mcontigo.test.infraestructure.db.mappers.toDomain
import com.mcontigo.test.infraestructure.db.mappers.toEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.stream.Collectors

@Repository
class RepositoryPostgresImpl @Autowired constructor(private val dao: BTCPriceDAO) : RepositoryDB {

    override fun fetchAll(): List<BTCPrice> {
       return dao.findAllOrderLastUpdate().stream()
           .map { m -> m.toDomain() }
           .collect(Collectors.toList())
    }

    override fun fetchByFiat(fiatType: FiatType): BTCPrice {
       return dao.findByFiatType(fiatType).map { m -> m.toDomain() }.get()
    }

    override fun registerBTCPrice(fiatType: FiatType?, price: BigDecimal?, registerAt: LocalDateTime?) {
        val newBTCPrice = BTCPrice.create(price,registerAt,fiatType)
        dao.save(newBTCPrice.toEntity())
    }
}