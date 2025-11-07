package com.frank.practicehilt.data.services

import android.util.Log
import com.frank.practicehilt.data.apis.QuestionAPI
import com.frank.practicehilt.data.entities.QuestionList
import javax.inject.Inject

class QuestionRemoteService @Inject constructor(private val questionAPI: QuestionAPI) {

    suspend fun getListQuestion(currentPage: Int, pageSize: Int): QuestionList?{
        Log.e("Hung","run api getListQuestion")
        val parameters = mutableMapOf<String,String>()
        parameters["site"] = "stackoverflow"
        parameters["pagesize"] = "$pageSize"
        parameters["page"] = "$currentPage"
        val response =  questionAPI.getListQuestions(parameters = parameters)
        Log.e("Hung","${response.body()}")
        if(response.isSuccessful){
            return response.body()
        }
        else{

            throw Exception(response.message())
        }

    }

}