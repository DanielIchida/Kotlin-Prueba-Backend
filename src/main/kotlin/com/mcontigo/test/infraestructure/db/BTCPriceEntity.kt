package com.mcontigo.test.infraestructure.db

import com.mcontigo.test.domain.enumerations.FiatType
import org.hibernate.annotations.Type
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "btc_price")
data class BTCPriceEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @Column(name = "price")
    val price: BigDecimal?,

    @Column(name = "last_update")
    val lastUpdate: LocalDateTime?,

    @Enumerated(EnumType.STRING)
    @Type(type = "fiat_enum_type")
    @Column(columnDefinition = "fiat_type")
    val fiatType: FiatType?

)