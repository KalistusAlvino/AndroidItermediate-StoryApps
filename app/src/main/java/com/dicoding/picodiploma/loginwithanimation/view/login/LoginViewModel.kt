package com.dicoding.picodiploma.loginwithanimation.view.login


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.dicoding.picodiploma.loginwithanimation.data.UserRepository
import com.dicoding.picodiploma.loginwithanimation.data.pref.UserModel
import com.dicoding.picodiploma.loginwithanimation.data.remote.response.LoginResponse
import com.dicoding.picodiploma.loginwithanimation.di.ResultState
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginViewModel(private val repository: UserRepository) : ViewModel() {
//    val _loginResponse = MutableLiveData<LoginResponse>()
//
//    private val _messageResponse = MutableLiveData<String?>()
//    val messageResponse: MutableLiveData<String?> = _messageResponse
//
//    private val _errorMessageResponse = MutableLiveData<String?>()
//    val errorMessage: MutableLiveData<String?> = _errorMessageResponse

    fun saveSession(user: UserModel) {
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }

    fun login(email: String, password: String) = liveData {
        emit(ResultState.Loading)
        try {
            val message = repository.login(email, password)
            emit(ResultState.Success(message))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, LoginResponse::class.java)
            emit(ResultState.Error(errorResponse.message))
        }
    }
}