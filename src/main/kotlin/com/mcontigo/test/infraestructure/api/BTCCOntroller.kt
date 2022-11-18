package com.mcontigo.test.infraestructure.api

import com.mcontigo.test.application.UsesCasesImpl
import com.mcontigo.test.domain.enumerations.FiatType
import com.mcontigo.test.infraestructure.api.dto.BTCPriceDTO
import com.mcontigo.test.infraestructure.api.dto.ResponseDTO
import com.mcontigo.test.infraestructure.api.mappers.toDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.streams.toList

@RestController
@RequestMapping("btc")
class BTCController @Autowired constructor(private val usesCasesImpl: UsesCasesImpl) {

    @GetMapping
    fun getList() : ResponseEntity<ResponseDTO>{
        var responseDTO: ResponseDTO?
        return try {
            val data: List<BTCPriceDTO>? = usesCasesImpl.fetchAll()?.stream()?.map { m -> m.toDto() }?.toList()
            responseDTO = ResponseDTO("OK",null,data)
            ResponseEntity.ok(responseDTO)
        }catch (e: Exception){
            responseDTO = ResponseDTO("ERROR",e.message,null)
            ResponseEntity.internalServerError().body(responseDTO)
        }
    }

    @GetMapping("/pair/{fiatType}")
    fun getPairFiat(@PathVariable(value = "type") fiatType: FiatType) : ResponseEntity<ResponseDTO>{
        var responseDTO: ResponseDTO?
        return try {
            val data: BTCPriceDTO? = usesCasesImpl.fetchBtcPriceByFiat(fiatType)?.toDto()
            responseDTO = ResponseDTO("OK",null,data)
            ResponseEntity.ok(responseDTO)
        }catch (e: Exception){
            responseDTO = ResponseDTO("ERROR",e.message,null)
            ResponseEntity.internalServerError().body(responseDTO)
        }
    }

    @PostMapping
    fun savePrice() : ResponseEntity<ResponseDTO>{
        var responseDTO: ResponseDTO?
        return try {
            usesCasesImpl.syncBtcPrice()
            responseDTO = ResponseDTO("OK",null,null)
            ResponseEntity.ok(responseDTO)
        }catch (e: Exception){
            responseDTO = ResponseDTO("ERROR",e.message,null)
            ResponseEntity.internalServerError().body(responseDTO)
        }
    }
}