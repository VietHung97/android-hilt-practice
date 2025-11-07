package com.frank.practicehilt.data.repositories

import com.frank.practicehilt.data.entities.Post
import com.frank.practicehilt.data.services.PostRemoteService
import com.frank.practicehilt.di.IODispatcher
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostRepository @Inject constructor(
    private val postRemoteService: PostRemoteService,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) {

    suspend fun getPost(): List<Post>? = withContext(dispatcher) {
        postRemoteService.getPosts()

    }

}