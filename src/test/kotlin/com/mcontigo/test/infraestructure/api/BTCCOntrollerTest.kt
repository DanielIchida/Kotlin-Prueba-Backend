package com.mcontigo.test.infraestructure.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.mcontigo.test.application.UseCases
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@WebMvcTest(BTCController::class)
internal class BTCCOntrollerTest {

   @MockBean
   private lateinit var usesCases: UseCases

   private val mapper = ObjectMapper();

   @Autowired
   private lateinit var mockMvc: MockMvc

   @Test
   fun testList(){
      Mockito.`when`(usesCases.fetchAll()).thenReturn(ArrayList())
      mockMvc.perform(get("/btc")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(MockMvcResultMatchers.status().isOk)
   }

}