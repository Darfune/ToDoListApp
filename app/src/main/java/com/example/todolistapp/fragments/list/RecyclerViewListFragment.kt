package com.example.todolistapp.fragments.list

import android.os.Bundle
import android.text.Layout
import android.view.*
import androidx.fragment.app.Fragment
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
            findNavController().navigate(R.id.action_recyclerViewListFragment_to_addItemFragment)
        }

        val recyclerViewListLayout: View? =  view.findViewById(R.id.recyclerViewListFragment)
        recyclerViewListLayout?.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerViewListFragment_to_updateFragment)
        }

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_fragment_menu, menu)
    }

}