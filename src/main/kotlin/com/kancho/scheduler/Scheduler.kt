package com.kancho.scheduler

import com.kancho.scheduler.dailyquestion.controller.DailyQuestionController
import com.kancho.scheduler.horoscope.controller.HoroscopeController
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Scheduler(private val horoscopeController: HoroscopeController,
                private val dailyQuestionController: DailyQuestionController) {

    @Scheduled(cron = "0 0 14 * * *")
    fun startJob() {
        horoscopeController.horoscopeCrawling()
        dailyQuestionController.designateDailyQuestion()
    }
}