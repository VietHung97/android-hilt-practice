package com.frank.practicehilt.ui.jsonplaceholder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.frank.practicehilt.base.BaseViewModel
import com.frank.practicehilt.data.entities.Post
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
 class JsonPlaceHolderViewModel constructor(): BaseViewModel() {



    var latestPost = MutableLiveData<Post>()
    private set

    fun getAllPosts(){

    }


}