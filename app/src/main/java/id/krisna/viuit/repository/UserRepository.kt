package id.krisna.viuit.repository

import id.krisna.viuit.application.AppPreference
import id.krisna.viuit.models.menu.MenuResponse
import id.krisna.viuit.network.IRetrofitService

class UserRepository(private val retrofitService: IRetrofitService, private val appPreference: AppPreference) {

    suspend fun getMenu(): List<MenuResponse>? {
        return retrofitService.getMenu()
    }

}