package com.hyeran.portfolio.domain.entity

import jakarta.persistence.*


@Entity
class Project(
    name: String,
    description: String,
    startYear: Int,
    startMonth: Int,
    endYear: Int?,
    endMonth: Int?,
    isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    var id: Long? = null

    var name: String = name

    var description: String = description

    var startYear: Int = startYear

    var startMonth: Int = startMonth

    var endYear: Int? = endYear

    var endMonth: Int? = endMonth

    var isActive: Boolean = isActive

    @OneToMany(
        targetEntity = ProjectDetail::class, // 아래와 일대다의 관계임을 알려주는 것
        fetch = FetchType.LAZY,
        cascade = [CascadeType.PERSIST]
    ) //
    @JoinColumn(name = "project_id") // 맵핑 기준
    var details: MutableList<ProjectDetail> = mutableListOf()

    @OneToMany(
        mappedBy = "project",
        fetch = FetchType.LAZY,
        cascade = [CascadeType.PERSIST]
    ) // 양방향 연관관계에서 연관관계 주인 지정
    var skills: MutableList<ProjectSkill> = mutableListOf()

    fun getEndYearMonth(): String {
        if (endYear == null || endMonth == null) {
            return "Present"
        }
        return "${endYear}.${endMonth}"
    }

    fun update(
        name: String,
        description: String,
        startYear: Int,
        startMonth: Int,
        endYear: Int?,
        endMonth: Int?,
        isActive: Boolean
    ) {
        this.name = name
        this.description = description
        this.startYear = startYear
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(details: MutableList<ProjectDetail>?) {
        if (details != null) {
            this.details.addAll(details)
        }
    }
}