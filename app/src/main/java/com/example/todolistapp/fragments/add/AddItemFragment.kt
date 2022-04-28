package com.example.todolistapp.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todolistapp.R
import com.example.todolistapp.data.models.Priority
import com.example.todolistapp.data.models.ToDoData
import com.example.todolistapp.data.viewmodel.ToDoViewModel

class AddItemFragment : Fragment() {


    private val toDoViewModel: ToDoViewModel by viewModels()

    private var titleEditText: EditText? = null
    private var prioritySpinner: Spinner? = null
    private var descriptionEditText: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_item, container, false)

        titleEditText = view.findViewById<EditText>(R.id.titleEditText)
        prioritySpinner = view.findViewById<Spinner>(R.id.prioritySpinner)
        descriptionEditText = view.findViewById<EditText>(R.id.descriptionEditText)

        setHasOptionsMenu(true)

        return view
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
        val title = titleEditText?.text.toString()
        val priority = prioritySpinner?.selectedItem.toString()
        val description = descriptionEditText?.text.toString()

        val validation = verifyDataFromUser(title,description)

        if (validation){
            val newData = ToDoData(
                0,
                title,
                parsePriority(priority),
                description
            )
            toDoViewModel.insertData(newData)
            Toast.makeText(requireContext(),"Successfully added!",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addItemFragment_to_recyclerViewListFragment)
        }
    }

    private fun verifyDataFromUser(title: String, description: String): Boolean{
        return if(TextUtils.isEmpty(title) || TextUtils.isEmpty(description)){
            false
        }
        else !(title.isEmpty() || description.isEmpty())
    }

    private fun parsePriority(priority: String): Priority{
        return when(priority){
            "High Priority" -> {Priority.HIGH}
            "Medium Priority" -> {Priority.MEDIUM}
            "Low Priority" -> {Priority.LOW}
            else -> Priority.LOW
        }
    }

}