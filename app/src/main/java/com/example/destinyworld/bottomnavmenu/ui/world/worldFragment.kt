package com.example.destinyworld.bottomnavmenu.ui.world

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.destinyworld.R

class worldFragment : Fragment() {

    companion object {
        fun newInstance() = worldFragment()
    }

    private lateinit var viewModel: WorldViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.world_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WorldViewModel::class.java)
        // TODO: Use the ViewModel
    }

}