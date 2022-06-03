package id.krisna.viuit.modules.splashScreen

import dagger.hilt.android.lifecycle.HiltViewModel
import id.krisna.viuit.application.AppPreference
import id.krisna.viuit.base.BaseViewModel
import id.krisna.viuit.repository.AppRepository
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(private val appRepository: AppRepository): BaseViewModel() {

    fun getIsOnBoardingHidden(): Boolean {
        return appRepository.getOnBoardingStatus()
    }


}