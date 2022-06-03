package id.krisna.viuit.application

import android.content.Context
import androidx.preference.PreferenceManager

class AppPreference(private val context: Context) {

    companion object {
        private val ANY_KEY = "any_key"
    }


    fun saveBoolean(key: String, value: Boolean) {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)

        val editor = pref.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key: String): Boolean {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        return pref.getBoolean(key, false)
    }
}