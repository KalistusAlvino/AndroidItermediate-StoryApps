package com.dicoding.picodiploma.loginwithanimation.view.camera

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.loginwithanimation.data.UserRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody

class UploadViewModel(private val repository: UserRepository) : ViewModel() {

    fun uploadStory(file: MultipartBody.Part, desc : RequestBody) = repository.postStory(file, desc)
}