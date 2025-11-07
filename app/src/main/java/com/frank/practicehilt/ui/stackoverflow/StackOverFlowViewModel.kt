package com.frank.practicehilt.ui.stackoverflow

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frank.practicehilt.base.BaseViewModel
import com.frank.practicehilt.data.entities.Question
import com.frank.practicehilt.data.repositories.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StackOverFlowViewModel @Inject constructor(private val questionRepository: QuestionRepository) : BaseViewModel() {

    var listQuestions = MutableLiveData<List<Question>>()
        private set

    fun fetchData() {
        parentJob = viewModelScope.launch {
            Log.e("Hung","fetch data called")
            isLoading.postValue(true)

                val questions = questionRepository.getListQuestion()
                Log.e("Hung","questions: ${questions.size} ")
                if (questions.isNotEmpty()) {
                    listQuestions.postValue(questions)
                }

        }
     registerEventParentJobFinish()
    }


    fun refresh() {
        parentJob = viewModelScope.launch(exceptionHandler) {
            isLoading.postValue(true)
            try {
                val questions = questionRepository.getNewAndSave()
                if (questions.isNotEmpty()) {
                    listQuestions.postValue(questions)
                }
            } catch (e: Exception) {
                Log.e("Hung","Error refreshing data: ${e.message}", e)
            } finally {
                isLoading.postValue(false)
            }
        }
        registerEventParentJobFinish()
    }

}