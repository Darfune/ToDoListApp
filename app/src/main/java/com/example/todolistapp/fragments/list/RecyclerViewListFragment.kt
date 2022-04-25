package com.example.todolistapp.fragments.list

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.fragment.findNavController
import com.example.todolistapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerViewListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycler_view_list, container, false)

        val floatingActionButton = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_recyclerViewListFragment_to_addItemFragment2)
        }

        val recyclerViewListLayout: View? =  view.findViewById(R.id.recyclerViewListLayout)
        recyclerViewListLayout?.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerViewListFragment_to_updateFragment2)
        }
        return view
    }

}