package id.krisna.viuit.modules.main.eatline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.krisna.viuit.R
import id.krisna.viuit.base.BaseFragment
import id.krisna.viuit.databinding.FragmentEatlineBinding
import id.krisna.viuit.databinding.FragmentHomeBinding

@AndroidEntryPoint
class EatlineFragment : BaseFragment() {

    private var _binding: FragmentEatlineBinding? = null
    private val binding get() =_binding!!
    private val viewModel: EatlineViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEatlineBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {

    }


}