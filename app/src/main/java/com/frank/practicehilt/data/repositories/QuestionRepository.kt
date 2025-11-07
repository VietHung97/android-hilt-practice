package com.frank.practicehilt.data.repositories

import com.frank.practicehilt.data.entities.Question
import com.frank.practicehilt.data.entities.QuestionList
import com.frank.practicehilt.data.entities.toListQuestionEntities
import com.frank.practicehilt.data.entities.toQuestionList
import com.frank.practicehilt.data.services.QuestionLocalService
import com.frank.practicehilt.data.services.QuestionRemoteService
import com.frank.practicehilt.di.IODispatcher
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class QuestionRepository @Inject constructor(
    private val questionRemoteService: QuestionRemoteService,
    private val questionLocalService: QuestionLocalService,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) {

    suspend fun getListQuestion(): List<Question> = withContext(dispatcher) {
        val saveQuestion = questionLocalService.getAllQuestion()
        if (saveQuestion.isEmpty()) {
            // Nếu DB rỗng thì gọi API để lấy data
            getNewAndSave()
        } else {
            // Nếu có data trong DB thì return data từ DB
            saveQuestion.toQuestionList()
        }
    }

     suspend fun getNewAndSave() : List<Question> {
        val questList = questionRemoteService.getListQuestion(1,1)
        val newListQuestion = questList?.items ?: emptyList()
        if (newListQuestion.isNotEmpty()) {
            questionLocalService.deleteAllQuestion()
            questionLocalService.saveListQuestion(newListQuestion.toListQuestionEntities())
        }
        return newListQuestion
    }
}