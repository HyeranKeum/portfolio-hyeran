package com.hyeran.portfolio.presentation.service

import com.hyeran.portfolio.domain.entity.Introduction
import com.hyeran.portfolio.domain.entity.Link
import com.hyeran.portfolio.presentation.repository.PresentationRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
class PresentationServiceTest {

    @InjectMocks
    lateinit var presentationService: PresentationService

    @Mock
    lateinit var presentationRepository: PresentationRepository

    val DATA_SIZE = 9

    @Test
    fun testGetIntroductions() { // introduction 가져오는 테스트
        //given
        val introductions = mutableListOf<Introduction>()
        for (i in 1..DATA_SIZE) {
            // entity로 시험용 데이터 만들기
            val introduction = Introduction(content = "${i}", isActive = i % 2 == 0)
            introductions.add(introduction)
        }

        val activeIntroductions = introductions.filter { it.isActive }

        Mockito.`when`(presentationRepository.getActiveIntroductions())
            .thenReturn(activeIntroductions)

        // when
        val introductionDTOS = presentationService.getIntroductions()

        //then
        assertThat(introductionDTOS).hasSize(DATA_SIZE / 2)
        for (introductionDTO in introductionDTOS) {
            assertThat(introductionDTO.content.toInt()).isEven()
        }
    }

    @Test
    fun testGetLinks() {

        //given
        val links = mutableListOf<Link>()
        for (i in 1..DATA_SIZE) {
            // entity로 시험용 데이터 만들기
            val link = Link(name = "${i}", content = "${i}", isActive = i % 2 != 0)
            links.add(link)
        }

        val activeLinks = links.filter { it.isActive }

        Mockito.`when`(presentationRepository.getActiveLinks())
            .thenReturn(activeLinks)

        // when
        val linkDTOS = presentationService.getLinks()

        //then
        var expectedSize = DATA_SIZE / 2
        if (DATA_SIZE % 2 != 0) {
            expectedSize += 1
        }
        assertThat(linkDTOS).hasSize(expectedSize)
        for (linkDTO in linkDTOS) {
            assertThat(linkDTO.content.toInt()).isOdd()
        }
    }

}
