package id.krisna.viuit.modules.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.krisna.viuit.R
import id.krisna.viuit.base.BaseFragment
import id.krisna.viuit.databinding.FragmentEatlineBinding
import id.krisna.viuit.databinding.FragmentHomeBinding
import id.krisna.viuit.modules.main.eatline.EatlineViewModel
import id.krisna.viuit.modules.main.home.adapter.HomeAdapter
import id.krisna.viuit.network.Resource

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() =_binding!!
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var adapter : HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        bindViewModel()
    }

    private fun initView() {
        viewModel.getMenu()
        setupAdapter()

        binding.srlHome.setOnRefreshListener {
            viewModel.getMenu()
        }


    }

    private fun bindViewModel() {

        viewModel.menu.observe(viewLifecycleOwner,{
            when(it.status){
                Resource.Status.LOADING -> {
                    binding.srlHome.isRefreshing = true
                }
                Resource.Status.SUCCESS -> {
                    it.data?.let {
                        adapter.updateData(it)
                    }

                    binding.srlHome.isRefreshing = false

                }
                Resource.Status.ERROR -> {
                    binding.srlHome.isRefreshing = false
                }
                Resource.Status.IDLE -> Unit
            }
        })

    }

    private fun setupAdapter() {
        adapter = HomeAdapter(requireContext(), itemClick = {

        })
        binding.rvHome.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvHome.adapter = adapter
    }


}