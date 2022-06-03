package id.krisna.viuit.modules.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import id.krisna.viuit.base.BaseViewModel
import id.krisna.viuit.models.login.LoginRequest
import id.krisna.viuit.models.login.LoginResponse
import id.krisna.viuit.repository.AuthRepository
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepository: AuthRepository): BaseViewModel() {

    val loginResponse: LiveData<LoginResponse?> get() = _loginResponse

    private var _loginResponse = MutableLiveData<LoginResponse?>()

    fun login(username: String, password: String) {
        val request = LoginRequest(username, password)
        authRepository.login(request, _loginResponse)

    }

}