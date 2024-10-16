package com.hyeran.portfolio.admin.context.link.service

import com.hyeran.portfolio.admin.context.link.form.LinkForm
import com.hyeran.portfolio.admin.data.TableDTO
import com.hyeran.portfolio.domain.entity.Link
import com.hyeran.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {

    fun getLinkTable(): TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    // 삽입
    @Transactional
    fun save(form: LinkForm) {
        val link = form.toEntity()
        linkRepository.save(link)
    }

    // 수정
    @Transactional
    fun update(id: Long, form: LinkForm) {
        val link = form.toEntity(id)
        linkRepository.save(link)
    }
}
