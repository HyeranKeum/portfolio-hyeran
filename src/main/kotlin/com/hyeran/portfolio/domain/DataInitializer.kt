package com.hyeran.portfolio.domain

import com.hyeran.portfolio.domain.constant.SkillType
import com.hyeran.portfolio.domain.entity.*
import com.hyeran.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
// component annotation -> 스프링에 빈으로 등록(개발자가 생성자로 인스턴스 만들 필요x)
@Profile(value = ["default"]) // default 일 때만 빈으로 등록
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository,
    private val accountRepository: AccountRepository
) {
    @PostConstruct
    // 스프링 DI 실행 시 component scan 해서 빈 등록 -> postconstruct 찾기
    fun initalizer() {

        println("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "프로젝트 장려상",
                description = "AI, 빅데이터",
                host = "포스코인재창조원",
                achievedDate = LocalDate.of(2024, 4, 26),
                isActive = true
            ),
        )
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction>(
            Introduction(content = "끊임없이 성장하고 도전을 즐기는 개발자", isActive = true),
            Introduction(content = "문제를 창의적으로 해결하는 것을 즐깁니다.", isActive = true),
            Introduction(content = "팀워크와 협업을 통해 더 나은 결과를 만들어내는 것을 중요시합니다.", isActive = true)
        )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/HyeranKeum", isActive = true)
        )
        linkRepository.saveAll(links)

        val experience1 = Experience(
            title = "성균관대학교",
            description = "전기전자공학부",
            startYear = 2019,
            startMonth = 2,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "GPA 3.8/4.5", isActive = true),
                ExperienceDetail(content = "소프트웨어 연구 학회 활동", isActive = true)

            )
        )
        // experienceRepo-에서 cascade = type.all -> 영속성 컨텍스트
        experienceRepository.saveAll(mutableListOf(experience1, ))

        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val python = Skill(name = "Python", type = SkillType.LANGUAGE.name, isActive = true)
        val csharp = Skill(name = "C#", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val django = Skill(name = "Django", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "Mysql", type = SkillType.DATABASE.name, isActive = true)
        val redis = Skill(name = "Redis", type = SkillType.DATABASE.name, isActive = true)
        val kafka = Skill(name = "Kafka", type = SkillType.TOOL.name, isActive = true)
        val matlab = Skill(name = "Matlab", type = SkillType.TOOL.name, isActive = true)
        val unity = Skill(name = "Unity", type = SkillType.TOOL.name, isActive = true)
        val mlAgents = Skill(name = "ML-agents", type = SkillType.FRAMEWORK.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, kotlin, python, spring, django, mysql, redis, kafka, csharp, unity, mlAgents))


        val project1 = Project(
            name = "스마트 그리드 안정성 강화를 위한 가전제품 최적 스케줄링",
            description = "강화학습을 활용한 가전제품 최적 스케줄링",
            startYear = 2024,
            startMonth = 6,
            endYear = 2024,
            endMonth = 7,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "균일한 전력 소비 패턴을 Load shifting으로 구현", url = null, isActive = true),
                ProjectDetail(content = "시간 별 전력 소비량 분산 약 2.5배 감소", url = null, isActive = true)
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = matlab)
            )
        )

        val project2 = Project(
            name = "강화학습을 이용한 자율주행 물류 로봇",
            description = "스마트 팩토리를 위한 자율주행 물류 로봇",
            startYear = 2024,
            startMonth = 3,
            endYear = 2024,
            endMonth = 4,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "sim-to-real 기술을 적용해 가상환경에서 훈련한 에이전트를 real world에서 젯슨나노로 구현", url = null, isActive = true),
                ProjectDetail(content = "lidar센서를 활용해 장애물 피하기", url = null, isActive = true),
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = csharp),
                ProjectSkill(project = project2, skill = unity),
                ProjectSkill(project = project2, skill = mlAgents)
            )
        )

        val project3 = Project(
            name = "Built-in 점자블록",
            description = "시각장애인 보행 보조를 위한 신발",
            startYear = 2023,
            startMonth = 9,
            endYear = 2023,
            endMonth = 12,
            isActive = true
        )
        project3.addDetails(
            mutableListOf(
                ProjectDetail(content = "장애물을 인식하고, 딥러닝으로 보행자 경로 안내", url = null, isActive = true),
                ProjectDetail(content = "초음파센서, 카메라, 진동 모터 활용", url = null, isActive = true),
            )
        )
        project3.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = python),
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2, project3))



        val account = Account(
            loginId = "admin1",
            pw = "\$2a\$10\$4.wGiRco61BVZW2ro5t5S.kKJXG.tYhYs/0Ej8bqABQgewLasq.dW"

        )
        accountRepository.save(account)
    }

}