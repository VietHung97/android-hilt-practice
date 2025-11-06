package com.frank.practicehilt.ui.stackoverflow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.frank.practicehilt.base.BaseViewModel
import com.frank.practicehilt.data.entities.Question
import com.frank.practicehilt.data.repositories.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StackOverFlowViewModel @Inject constructor(private val questionRepository: QuestionRepository) : BaseViewModel() {

    var listQuestions = MutableLiveData<List<Question>>()
        private set

    fun fetchData() {

    }


    fun refresh() {

    }

}