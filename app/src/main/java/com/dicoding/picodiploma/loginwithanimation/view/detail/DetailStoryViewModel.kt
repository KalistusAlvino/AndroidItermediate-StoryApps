package com.dicoding.picodiploma.loginwithanimation.view.detail

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.loginwithanimation.data.UserRepository

class DetailStoryViewModel(private val repository: UserRepository) : ViewModel() {

    fun detailStory(id: String) = repository.getDetailStory(id)
}