package id.krisna.viuit.modules.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.krisna.viuit.application.AppPreference
import id.krisna.viuit.databinding.ActivityMainBinding
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val appPreference: AppPreference): ViewModel() {

    lateinit var binding: ActivityMainBinding
    var discoverTabIdx: Int? = null
        get() {
            val tabIdx = field
            field = null
            return tabIdx
        }
        private set

    var libraryTabIdx: Int? = null
        get() {
            val tabIdx = field
            field = null
            return tabIdx
        }
        private set

    fun init(binding: ActivityMainBinding) {
        this.binding = binding
    }




}