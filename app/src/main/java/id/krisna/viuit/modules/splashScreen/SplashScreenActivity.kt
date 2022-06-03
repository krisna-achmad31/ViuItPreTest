package id.krisna.viuit.modules.splashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.krisna.viuit.base.BaseActivity
import id.krisna.viuit.databinding.ActivitySplashScreenBinding
import id.krisna.viuit.modules.login.LoginActivity
import id.krisna.viuit.modules.main.MainActivity
import id.krisna.viuit.modules.onBoarding.OnBoardingActivity

@AndroidEntryPoint
class SplashScreenActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    private val viewModel: SplashScreenViewModel by viewModels()

    private lateinit var mRunnable: Runnable
    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        mDelayHandler = Handler()
        mRunnable = Runnable {}

        Handler().postDelayed({
            checkApplicationBundle()
        }, SPLASH_DELAY)
    }

    private fun checkApplicationBundle() {
        initView()
    }

    private fun initView() {
        val isHidden = viewModel.getIsOnBoardingHidden()
        val intent: Intent = if (isHidden) {
            Intent(applicationContext, LoginActivity::class.java)
        } else {
            Intent(applicationContext, OnBoardingActivity::class.java)
        }
        startActivity(intent)
        finish()
    }

    public override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }
}