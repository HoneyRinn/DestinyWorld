package com.example.destinyworld.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.destinyworld.ListOfPlanets
import com.example.destinyworld.R
import com.example.destinyworld.databinding.FragmentHomeBinding
import com.example.destinyworld.planetsAdapter

class HomeFragment : Fragment() {
    //lateinit var  sharedPreferences: SharedPreferences
    lateinit var recyclerView: RecyclerView
    private var _binding: FragmentHomeBinding? = null
    lateinit var LM: LinearLayoutManager
    //lateinit var email_text:TextView
    //lateinit var name_text:TextView
    //lateinit var ImageView: ImageView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //sharedPreferences = activity?.getSharedPreferences("main", Context.MODE_PRIVATE)!!
        //val email = sharedPreferences.getString("email", null)
        //val avatar = sharedPreferences.getString("avatar",null)
        //val name = sharedPreferences.getString("name",null)
        //email_text = root.findViewById(R.id.email_text)
        //ImageView = root.findViewById(R.id.avatar_img)
        //name_text = root.findViewById(R.id.name_text)
        //email_text.text = email
        //name_text.text = name
//
        //Glide.with(requireActivity()).load(avatar).circleCrop().into(ImageView)
//
        //Toast.makeText(requireContext(), avatar , Toast.LENGTH_SHORT).show()

        recyclerView = root.findViewById(R.id.recycler_planet)
        recyclerView.adapter = ListOfPlanets.ListOfPlanets?.let { planetsAdapter(requireContext()!!, it) }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}