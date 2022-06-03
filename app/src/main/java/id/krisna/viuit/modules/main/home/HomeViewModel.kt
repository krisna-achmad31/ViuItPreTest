package id.krisna.viuit.modules.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.krisna.viuit.base.BaseViewModel
import id.krisna.viuit.models.menu.MenuResponse
import id.krisna.viuit.network.Resource
import id.krisna.viuit.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val userRepository: UserRepository) : BaseViewModel() {

    val menu: LiveData<Resource<List<MenuResponse>>> get() = _menu

    private val _menu = MutableLiveData<Resource<List<MenuResponse>>>()

    fun getMenu() {
        viewModelScope.launch {
            _menu.value = Resource.loading(null)

            try {
                val response = userRepository.getMenu()
                _menu.value = Resource.success(response)
            } catch (e: HttpException) {
                e.printStackTrace()
                _menu.value = Resource.error(e)
            }
        }
    }
}