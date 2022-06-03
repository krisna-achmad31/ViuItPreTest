package id.krisna.viuit.modules.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import id.krisna.viuit.R
import id.krisna.viuit.base.BaseActivity
import id.krisna.viuit.databinding.ActivityMainBinding
import id.krisna.viuit.extension.toast
import id.krisna.viuit.modules.main.eatline.EatlineFragment
import id.krisna.viuit.modules.main.home.HomeFragment
import id.krisna.viuit.modules.main.profile.ProfileFragment
import id.krisna.viuit.modules.main.request.RequestFragment

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    private val home = HomeFragment()
    private val eatline = EatlineFragment()
    private val request = RequestFragment()
    private val profile = ProfileFragment()

    private var doubleBackToExitPressedOnce: Boolean = false

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, home)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val transaction = supportFragmentManager.beginTransaction()

        when (item.itemId) {
            R.id.navigation_home -> {
                transaction.replace(R.id.container, home)
                transaction.addToBackStack(null)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_eatline -> {
                transaction.replace(R.id.container, eatline)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_request -> {
                transaction.replace(R.id.container, request)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                transaction.replace(R.id.container, profile)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onBackPressed() {
        val delay: Long = 1000

        val mRunnable = Runnable {
            if (!isFinishing) {
                doubleBackToExitPressedOnce = false
            }
        }

        val fragments: Int = supportFragmentManager.backStackEntryCount
        if (fragments == 1) {
            if (doubleBackToExitPressedOnce) {
                val startMain = Intent(Intent.ACTION_MAIN)
                startMain.addCategory(Intent.CATEGORY_HOME)
                startMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(startMain)
                finish()
            }

            this.doubleBackToExitPressedOnce = true
            toast(getString(R.string.lbl_press_back_again_to_exit))
            Handler().postDelayed(mRunnable, delay)
        } else {
            if (supportFragmentManager.backStackEntryCount > 1) {
                supportFragmentManager.popBackStack()
            } else super.onBackPressed()
        }
    }
}