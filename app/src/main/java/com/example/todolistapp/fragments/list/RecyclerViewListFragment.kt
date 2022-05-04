package com.example.todolistapp.fragments.list

import android.os.Bundle
import android.text.Layout
import android.view.*
import androidx.fragment.app.Fragment
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.R
import com.example.todolistapp.data.viewmodel.ToDoViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerViewListFragment : Fragment() {

    private val adapter: ListAdapter by lazy { ListAdapter() }
    private val toDoViewModel: ToDoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycler_view_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        toDoViewModel.getAllData.observe(viewLifecycleOwner, Observer {
            data -> adapter.setData(data)
        })

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