package id.krisna.viuit.modules.onBoarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.viewpager.widget.ViewPager
import dagger.hilt.android.AndroidEntryPoint
import id.krisna.viuit.R
import id.krisna.viuit.application.AppPreference
import id.krisna.viuit.base.BaseActivity
import id.krisna.viuit.databinding.ActivityOnBoardingBinding
import id.krisna.viuit.extension.makeInVisible
import id.krisna.viuit.extension.makeVisible
import id.krisna.viuit.models.OnBoardingList
import id.krisna.viuit.modules.login.LoginActivity

@AndroidEntryPoint
class OnBoardingActivity : BaseActivity() {

    private lateinit var binding: ActivityOnBoardingBinding

    private val viewModel: OnBoardingViewModel by viewModels()

    private val dots = arrayOfNulls<TextView>(3)
    var currentpage: Int = 0

    lateinit var appPreference: AppPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        bindViewModel()

    }

    private fun initView() {
        picture()
        layoutSetup()
    }

    private fun bindViewModel() {

    }

    private fun layoutSetup() {
        binding.btnOnBoarding.setOnClickListener {
            if (binding.btnOnBoarding.text == "Get Started") {
                toLogin()
                binding.btnOnBoarding.rippleColor to R.color.colorHoverButton
            } else {
                if (binding.vpOnboard.currentItem + 1 <= dots.size) {
                    binding.vpOnboard.currentItem += 1
                }
            }
        }


    }

    private fun picture() {
        val listImage = ArrayList<OnBoardingList>()
        listImage.add(OnBoardingList(getString(R.string.lbl_title_on_boarding_1), getString(R.string.lbl_subtitle_on_boarding_1), R.drawable.img_onboarding1))
        listImage.add(OnBoardingList(getString(R.string.lbl_title_on_boarding_2), getString(R.string.lbl_subtitle_on_boarding_2), R.drawable.img_onboarding2))
        listImage.add(OnBoardingList(getString(R.string.lbl_title_on_boarding_3), getString(R.string.lbl_subtitle_on_boarding_3), R.drawable.img_onboarding3))
        binding.vpOnboard.adapter = ImageSliderAdapter(this, listImage) { position ->
            if (position == 0) {
                binding.llLabel.makeVisible()
            } else {
                binding.llLabel.makeInVisible()
            }
            if (position == 2) {
                toLogin()
            }

        }


        binding.ciOnboard.setViewPager(binding.vpOnboard)
        val density = resources.displayMetrics.density
//        val frameOnBoarding = layoutInflater.inflate(R.layout.layout_on_board, binding.root, false)

        binding.ciOnboard.radius = 5 * density

        binding.vpOnboard.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }


            override fun onPageSelected(position: Int) {
                currentpage = position
                if (position == 2) {
//                    binding.btnOnboard.makeVisible()
                    binding.btnOnBoarding.text = getString(R.string.lbl_get_started)
                    binding.btnOnBoarding.setRippleColorResource(R.color.colorHoverButton)
                } else {
                    binding.btnOnBoarding.text = getString(R.string.lbl_next)
                    binding.btnOnBoarding.setRippleColorResource(R.color.colorAccent)

                }
                if (position == 0) {
                    binding.tvPrevious.makeInVisible()
                    binding.llLabel.makeVisible()
                } else {
                    binding.tvPrevious.makeVisible()
                    binding.llLabel.makeInVisible()
                }

            }

        })

        binding.tvPrevious.setOnClickListener {
            if (binding.vpOnboard.currentItem + 1 <= dots.size) {
                binding.vpOnboard.currentItem -= 1
            }
        }
    }

    private fun toLogin() {
        viewModel.hide()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}