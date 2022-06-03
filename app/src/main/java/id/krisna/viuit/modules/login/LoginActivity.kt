package id.krisna.viuit.modules.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import id.krisna.viuit.R
import id.krisna.viuit.base.BaseActivity
import id.krisna.viuit.databinding.ActivityLoginBinding
import id.krisna.viuit.extension.isEmailValid
import id.krisna.viuit.extension.makeGone
import id.krisna.viuit.extension.makeVisible
import id.krisna.viuit.modules.main.MainActivity

@AndroidEntryPoint
class LoginActivity : BaseActivity() {

    private lateinit var binding : ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initView()
        bindViewModel()
    }

    private fun bindViewModel() {
        viewModel.loginResponse.observe(this, {
            it?.let { response ->
                if (response.rc == "00") {
                    doSignIn()
                } else {
                    Snackbar.make(binding.btnLogin, response.rd!!, Snackbar.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun initView() {

        binding.btnLogin.setOnClickListener {
            viewModel.login(binding.etLoginEmail.text.toString(), binding.etLoginPassword.text.toString())
            showLoading()
            doSignIn()
        }

    }

    private fun isLoginValid(): Boolean {
        val email = binding.etLoginEmail.text.toString()
        val password = binding.etLoginPassword.text.toString()
        var isValid = true

        if (email.isEmpty()) {
            binding.tvLoginEmailError.text = getString(R.string.lbl_email_empty)
            binding.tvLoginEmailError.makeVisible()
            isValid = false
        }
        if (!email.isEmailValid()) {
            binding.tvLoginEmailError.text = getString(R.string.lbl_email_not_valid)
            binding.tvLoginEmailError.makeVisible()
            isValid = false
        }
        if (!email.isEmailValid() && email.length in 1..3) {
            binding.tvLoginEmailError.text = getString(R.string.lbl_email_not_valid)
            binding.tvLoginEmailError.makeVisible()
            isValid = false
        }
        if (email.isNotEmpty() && email.isEmailValid()) {
            binding.tvLoginEmailError.makeGone()
        }
        if (password.isEmpty()) {
            binding.tvLoginPasswordError.text = getString(R.string.lbl_password_empty)
            binding.tvLoginPasswordError.makeVisible()
            isValid = false
        }
        if (password.length in 1..3) {
            binding.tvLoginPasswordError.text = getString(R.string.lbl_password_not_valid)
            binding.tvLoginPasswordError.makeVisible()
            isValid = false
        }
        if (password.isNotEmpty() && password.length > 4) {
            binding.tvLoginPasswordError.makeGone()
        }
        return isValid
    }

    private fun doSignIn() {
        hideLoading()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}