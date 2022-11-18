package com.mcontigo.test.application

import com.mcontigo.test.domain.enumerations.FiatType
import com.mcontigo.test.domain.models.BTCPrice
import com.mcontigo.test.domain.repository.RepositoryDB
import com.mcontigo.test.domain.repository.RepositoryExternal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsesCasesImpl @Autowired constructor(
    private val repositoryDB: RepositoryDB?,
    private val repositoryExternal: RepositoryExternal

) : UseCases {
    override fun fetchAll(): List<BTCPrice>? {
        return repositoryDB?.fetchAll()
    }

    override fun fetchBtcPriceByFiat(type: FiatType): BTCPrice? {
        return repositoryDB?.fetchByFiat(type)
    }

    override fun syncBtcPrice() {
        repositoryExternal.fetchCurrentPrice().forEach { b ->
            repositoryDB?.registerBTCPrice(b?.fiatType,b?.price,b?.lastUpdate)
        }
    }
}