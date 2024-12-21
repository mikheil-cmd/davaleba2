package com.example.mobileapplication32.profile

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
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
    private lateinit var rvAdapter: RvStoryAdapter
    private lateinit var vpAdapter: VpAdapter

    private val fList = listOf(
        PostsFragment.newInstance(),
        TaggedFragment.newInstance()
    )

    private val tList = listOf(
        "POSTS", "TAGGED"
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
        initVP()
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

    private fun initVP() = with(binding){
        vpAdapter = VpAdapter(activity as FragmentActivity, fList)
        //        vpAdapter = VpAdapter(requireActivity(),fList) ესეც მისაღებია
        vp.adapter = vpAdapter
        TabLayoutMediator(tabLayout, vp) { tab, position ->
//            tab.text = "tab ${position + 1}"
            tab.text = tList[position]
        }.attach()
    }



    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}