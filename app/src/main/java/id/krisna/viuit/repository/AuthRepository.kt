package id.krisna.viuit.repository

import androidx.lifecycle.MutableLiveData
import id.krisna.viuit.application.AppPreference
import id.krisna.viuit.models.login.LoginRequest
import id.krisna.viuit.models.login.LoginResponse
import id.krisna.viuit.network.IRetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository (private val retrofitService: IRetrofitService, private val appPreference: AppPreference) {

    fun login(loginRequest: LoginRequest, loginResponse: MutableLiveData<LoginResponse?>) {
        retrofitService.login(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    loginResponse.value = response.body()

                } else {

                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

            }
        })


    }

}