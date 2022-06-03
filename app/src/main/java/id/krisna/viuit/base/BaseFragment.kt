package id.krisna.viuit.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    lateinit var mProgressDialog: ProgressDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeProgressbar()
        /*val window = activity?.window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            window?.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window?.statusBarColor = context?.let { ContextCompat.getColor(it, R.color.colorPrimaryDark) }!!
        }*/
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun initializeProgressbar() {
        mProgressDialog = ProgressDialog(activity)
    }

    fun showLoading(msg: String) {
        initializeProgressbar()
        if (!mProgressDialog.isShowing) {
            mProgressDialog.show()
            mProgressDialog.setMessage(msg)
            mProgressDialog.setCancelable(false)
        }
    }

    fun hideLoading() {
        if (mProgressDialog.isShowing) {
            mProgressDialog.dismiss()
        }
    }
}