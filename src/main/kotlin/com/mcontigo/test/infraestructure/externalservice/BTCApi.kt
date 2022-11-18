package com.mcontigo.test.infraestructure.externalservice

import com.mcontigo.test.domain.enumerations.FiatType
import com.mcontigo.test.domain.models.BTCPrice
import com.mcontigo.test.domain.repository.RepositoryExternal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.time.LocalDateTime

@Component
class BTCApi @Autowired constructor(private val restTemplate: RestTemplate) : RepositoryExternal {

    override fun fetchCurrentPrice(): List<BTCPrice?> {
      val service = restTemplate.getForEntity(
          "https://api.coindesk.com/v1/bpi/currentprice.json",BTCApiResponse::class.java)
      val response: BTCApiResponse? = service.body
      val currency: Bpi? = response?.bpi
      val lastTime = LocalDateTime.parse(response?.time?.updated)
      val listPrice = mutableListOf<BTCPrice>()
      listPrice.add(BTCPrice.create(currency?.eur?.rateFloat, lastTime , FiatType.EUR))
      listPrice.add(BTCPrice.create(currency?.usd?.rateFloat, lastTime,FiatType.USD))
      listPrice.add(BTCPrice.create(currency?.gbp?.rateFloat, lastTime,FiatType.GBP))
      return listPrice
    }
}