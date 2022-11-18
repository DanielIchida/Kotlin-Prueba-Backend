package com.mcontigo.test.application

import com.mcontigo.test.domain.repository.RepositoryDB
import com.mcontigo.test.domain.repository.RepositoryExternal
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class UsesCasesImplTest {

    @InjectMocks
    private lateinit var usesCasesImpl: UsesCasesImpl

    private val repositoryDB: RepositoryDB = Mockito.mock(RepositoryDB::class.java)

    private val repositoryExternal: RepositoryExternal = Mockito.mock(RepositoryExternal::class.java)


    @Test
    fun fetchAllTest(){
        Mockito.`when`(repositoryDB.fetchAll()).thenReturn(ArrayList())
        Mockito.`when`(repositoryExternal.fetchCurrentPrice()).thenReturn(ArrayList())
        Assertions.assertEquals(usesCasesImpl.fetchAll(),null)
    }

}