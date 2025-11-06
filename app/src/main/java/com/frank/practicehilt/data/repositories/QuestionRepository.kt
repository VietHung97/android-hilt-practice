package com.frank.practicehilt.data.repositories

import com.frank.practicehilt.data.entities.Question
import com.frank.practicehilt.data.entities.QuestionList
import com.frank.practicehilt.data.services.QuestionLocalService
import com.frank.practicehilt.data.services.QuestionRemoteService
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class QuestionRepository @Inject constructor(private val questionRemoteService: QuestionRemoteService,
                                             private val questionLocalService: QuestionLocalService,
                                             private val dispatcher: CoroutineDispatcher
) {

    suspend fun getListQuestion(): List<Question> = withContext(dispatcher){
        emptyList()
    }

}