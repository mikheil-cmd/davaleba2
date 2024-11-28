package com.example.mobileapplication32.profile

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileapplication32.R
import com.example.mobileapplication32.adapters.RvStoryAdapter
import com.example.mobileapplication32.adapters.VpAdapter
import com.example.mobileapplication32.databinding.FragmentHomeBinding
import com.example.mobileapplication32.databinding.FragmentProfileBinding
import com.example.mobileapplication32.models.Story
import com.example.mobileapplication32.profile.postsFragments.PostsFragment
import com.example.mobileapplication32.profile.postsFragments.TaggedFragment
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var vpAdapter: VpAdapter
    private lateinit var rvAdapter: RvStoryAdapter

    private val tList = listOf("Posts","Tagged")
    private val fList = listOf(
        PostsFragment.newInstance(),
        TaggedFragment.newInstance()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vpInit()
        rvInit()
    }

    private fun rvInit() = with(binding) {
        rvAdapter = RvStoryAdapter()
        rvHighlights.adapter = rvAdapter
        rvHighlights.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        val list = listOf(Story("","highlight1"),
            Story("","highlight2"), Story("","highlight3"),
            Story("","highlight4"), Story("","highlight5"),
            Story("","highlight6")
        )

        rvAdapter.submitList(list)

    }

    private fun vpInit() = with(binding){
        vpAdapter = VpAdapter(requireActivity(),fList)
        vpProfile.adapter = vpAdapter
        TabLayoutMediator(tabLayout, vpProfile) { tab, position ->
            tab.text = tList[position]
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}