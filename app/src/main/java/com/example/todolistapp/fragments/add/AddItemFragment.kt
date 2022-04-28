package com.example.todolistapp.fragments.add

import android.os.Bundle
import android.view.*
import android.view.View.inflate
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todolistapp.R
import com.example.todolistapp.data.models.ToDoData
import com.example.todolistapp.data.viewmodel.ToDoViewModel
import com.example.todolistapp.databinding.ActivityMainBinding
import com.example.todolistapp.databinding.ActivityMainBinding.inflate
import com.example.todolistapp.databinding.FragmentAddItemBinding
import com.example.todolistapp.fragments.SharedViewModel

class AddItemFragment : Fragment() {


    private val toDoViewModel: ToDoViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by viewModels()

    private lateinit var binding: FragmentAddItemBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddItemBinding.inflate(layoutInflater,container, false)
        setHasOptionsMenu(true)

        binding.prioritySpinner.onItemSelectedListener = sharedViewModel.listener

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menuAdd ){
            insertDataToDatabase()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertDataToDatabase() {
        val title = binding.titleEditText.text.toString()
        val priority = binding.prioritySpinner.selectedItem.toString()
        val description = binding.descriptionEditText.text.toString()

        val validation = sharedViewModel.verifyDataFromUser(title,description)

        if (validation){
            val newData = ToDoData(
                0,
                title,
                sharedViewModel.parsePriority(priority),
                description
            )
            toDoViewModel.insertData(newData)
            Toast.makeText(requireContext(),"Successfully added!",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addItemFragment_to_recyclerViewListFragment)
        }
    }



}