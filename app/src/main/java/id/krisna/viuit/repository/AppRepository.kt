package id.krisna.viuit.repository

import id.krisna.viuit.application.AppPreference
import id.krisna.viuit.network.IRetrofitService

class AppRepository(private val retrofitService: IRetrofitService, private val appPreference: AppPreference) {

    fun hideOnBoarding() {
        appPreference.saveBoolean("HIDE_ON_BOARDING", true)
    }

    fun getOnBoardingStatus(): Boolean {
        return appPreference.getBoolean("HIDE_ON_BOARDING")
    }

    fun hideGuidance() {
        appPreference.saveBoolean("HIDE_GUIDANCE", true)
    }

    fun getGuidanceStatus(): Boolean {
        return appPreference.getBoolean("HIDE_GUIDANCE")
    }

}