package id.krisna.viuit.network

import id.krisna.viuit.models.login.LoginRequest
import id.krisna.viuit.models.login.LoginResponse
import id.krisna.viuit.models.menu.MenuResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IRetrofitService {

    @POST("web/test_programmer.php")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("web/test_programmer.php")
    suspend fun getMenu(): List<MenuResponse>
}