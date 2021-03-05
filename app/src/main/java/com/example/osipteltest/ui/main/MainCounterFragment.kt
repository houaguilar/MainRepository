package com.example.osipteltest.ui.main

import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.osipteltest.R
import com.example.osipteltest.core.Resource
import com.example.osipteltest.data.model.Counter
import com.example.osipteltest.data.remote.RemoteCounterDataSource
import com.example.osipteltest.databinding.MainCounterFragmentBinding
import com.example.osipteltest.presentation.CounterViewModel
import com.example.osipteltest.presentation.CounterViewModelFactory
import com.example.osipteltest.repository.CounterRepositoryImpl
import com.example.osipteltest.repository.RetrofitClient
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class MainCounterFragment : Fragment(R.layout.main_counter_fragment),
    MainCounterAdapter.CounterListClickListener {

    private lateinit var binding: MainCounterFragmentBinding
    private val viewModel by viewModels<CounterViewModel> {
        CounterViewModelFactory(CounterRepositoryImpl(RemoteCounterDataSource(RetrofitClient.webservice)))
    }
    private lateinit var adapter: MainCounterAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = MainCounterFragmentBinding.bind(view)

        binding.rvMainCounter.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMainCounter.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )

        viewModel.fetchMainCounters().observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {
                    Log.d("Livedata", "Loading ... ")
                }
                is Resource.Success -> {
                    adapter = MainCounterAdapter(it.data, this)
                    Log.d("Livedata", "${it.data}} ")
                    binding.rvMainCounter.adapter = adapter
                }
                is Resource.Failure -> {
                }
            }
        })
        binding.extendFab.setOnClickListener {
            showCreateCounterListDialog()
        }

//        return ItemTouchHelper(object :
//            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
//            override fun onMove(
//                recyclerView: RecyclerView,
//                viewHolder: RecyclerView.ViewHolder,
//                target: RecyclerView.ViewHolder
//            ): Boolean {
//                return false
//            }
//
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                adapter.deleteCounterSwipe(viewHolder.adapterPosition)
//            }
//
//        }).attachToRecyclerView(binding.rvMainCounter)
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MainCounterViewModel::class.java)
//        rv_main_counter.layoutManager = LinearLayoutManager(context)
//        viewModel.loadData(this)
//        extend_fab.setOnClickListener {
//            showCreateCounterListDialog()
//        }
//
//    }

//    fun fillCounterRecyclerView(list: ArrayList<Counter>){
//        adapter = MainCounterAdapter(context, list, this)
//        rv_main_counter.adapter = adapter
//    }

    //    override fun onDestroy() {
//        super.onDestroy()
//        viewModel.clearMemory()
//    }
    private fun showCreateCounterListDialog() {
        activity?.let {
            val todoTitleEditText = EditText(it)
            todoTitleEditText.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(resources.getString(R.string.title))
                .setView(todoTitleEditText)
//                .setMessage(resources.getString(R.string.supporting_text))
                .setNeutralButton(resources.getString(R.string.cancel)) { dialog, which ->
                    // Respond to neutral button press
                    dialog.dismiss()
                }
//                .setNegativeButton(resources.getString(R.string.decline)) { dialog, which ->
//                    // Respond to negative button press
//                }
                .setPositiveButton(resources.getString(R.string.create_counter)) { dialog, which ->
                    // Respond to positive button press
                    val counter = todoTitleEditText.text.toString().trim()
                    addNewCounter(counter)
                    dialog.dismiss()
                }
                .show()
        }
    }

    private fun addNewCounter(title: String) {
        viewModel.newCounterAdd(title).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    Log.d("Livedata", "Loading ... ")
                }
                is Resource.Success -> {
                    Log.d("Livedata", "${result.data}} ")
                    viewModel.fetchMainCounters().observe(viewLifecycleOwner, Observer {
                        when (it) {
                            is Resource.Loading -> {
                                Log.d("Livedata", "Loading ... ")
                            }
                            is Resource.Success -> {
                                adapter = MainCounterAdapter(it.data, this)
                                Log.d("Livedata", "${it.data}} ")
                                binding.rvMainCounter.adapter = adapter
                            }
                            is Resource.Failure -> {
                            }
                        }
                    })
                }
                is Resource.Failure -> {
                }
            }
        })
    }

    override fun listItemClicked(counter: Counter) {
        showCounterListItems(counter)
    }

    override fun listItemLongClicked(counter: Counter) {
        deleteCounterSwiped(counter.id)
    }

    private fun showCounterListItems(counter: Counter) {
//        view?.let {
//            val action = MainCounterFragmentDirections.actionMainCounterFragmentToDetailCounterFragment(counter)
//            it.findNavController().navigate(action)
//        }
        findNavController().navigate(
            MainCounterFragmentDirections.actionMainCounterFragmentToDetailCounterFragment(
                counter.title,
                counter.id,
                counter.count
            )
        )
    }

//    override fun counterSwipe(counter: Counter) {
//        deleteCounterSwiped(counter.id)
//    }

    private fun deleteCounterSwiped(id: String){
        viewModel.deleteCounter(id)
    }

//    private fun updateLists() {
//        val lists = listDataManager.readLists()
//        rv_main_counter.adapter = MainCounterAdapter(lists, this)
//    }


}