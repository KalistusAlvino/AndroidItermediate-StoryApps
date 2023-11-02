package com.dicoding.picodiploma.loginwithanimation.maps

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.loginwithanimation.data.UserRepository

class MapViewModel(private val repository: UserRepository): ViewModel() {

    fun getStoryWithMaps() = repository.getListMap()

}