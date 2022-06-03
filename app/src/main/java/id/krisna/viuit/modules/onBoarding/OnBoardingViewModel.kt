package id.krisna.viuit.modules.onBoarding

import dagger.hilt.android.lifecycle.HiltViewModel
import id.krisna.viuit.base.BaseViewModel
import id.krisna.viuit.repository.AppRepository
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val appRepository: AppRepository): BaseViewModel() {

    fun hide() {
        appRepository.hideOnBoarding()
    }
}