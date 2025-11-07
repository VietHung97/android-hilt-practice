package com.frank.practicehilt.ui.jsonplaceholder

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frank.practicehilt.base.BaseViewModel
import com.frank.practicehilt.data.entities.Post
import com.frank.practicehilt.data.repositories.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
 class JsonPlaceHolderViewModel @Inject constructor(private val postRepository: PostRepository): BaseViewModel() {



    var latestPost = MutableLiveData<Post>()
    private set

    fun getAllPosts(){
        parentJob = viewModelScope.launch {
           val posts = postRepository.getPost()
            Log.e("Hung","getAllPosts: ${posts?.size}")
            posts?.firstOrNull()?.let {
                latestPost.postValue(it)
            }
        }
            registerEventParentJobFinish()
    }


}