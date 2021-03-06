package com.kancho.scheduler.dailyquestion.domain

import com.kancho.scheduler.dailyquestion.domain.dailyquestion.DailyQuestion
import com.kancho.scheduler.dailyquestion.domain.dailyquestion.DailyQuestionRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
@ActiveProfiles("test")
class DailyQuestionRepositoryTests {

    @Autowired
    private lateinit var dailyQuestionRepository: DailyQuestionRepository

    @Test
    fun 개행문자_추가시_조회되는지_확인() {
        var testText: String = "안녕\\r\\n안녕"
        var dailyQuestion: DailyQuestion = DailyQuestion("2222", testText)
        dailyQuestionRepository.save(dailyQuestion)
        dailyQuestion = dailyQuestionRepository.findAll()[0]

        Assertions.assertThat(dailyQuestion.content).isEqualTo(testText)
    }
}