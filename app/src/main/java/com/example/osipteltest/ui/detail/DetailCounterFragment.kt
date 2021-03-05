package com.example.osipteltest.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.graphics.component3
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.osipteltest.R
import com.example.osipteltest.core.Resource
import com.example.osipteltest.data.model.Counter
import com.example.osipteltest.data.remote.RemoteCounterDataSource
import com.example.osipteltest.databinding.DetailCounterFragmentBinding
import com.example.osipteltest.presentation.CounterViewModel
import com.example.osipteltest.presentation.CounterViewModelFactory
import com.example.osipteltest.repository.CounterRepositoryImpl
import com.example.osipteltest.repository.RetrofitClient
import com.example.osipteltest.ui.main.MainCounterAdapter

class DetailCounterFragment : Fragment(R.layout.detail_counter_fragment) {

    private lateinit var binding: DetailCounterFragmentBinding
    private val viewModel by viewModels<CounterViewModel> {
        CounterViewModelFactory(CounterRepositoryImpl(RemoteCounterDataSource(RetrofitClient.webservice)))
    }
    private val args by navArgs<DetailCounterFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DetailCounterFragmentBinding.bind(view)

        binding.txtNameCounter.text = args.title
        binding.txtCounter.text = args.count.toString()

        binding.btnAddition.setOnClickListener {
            val idCounterInc = args.id
            incrementCounter(idCounterInc)
        }

        binding.btnDecrement.setOnClickListener {
            val idCounterDec = args.id
            decrementCounter(idCounterDec)
        }

        binding.btnDeleteCounter.setOnClickListener {
            val idDeleteCounter = args.id
//            deleteCounterInDetail(idDeleteCounter)
        }
    }

    private fun incrementCounter(id: String) {
        viewModel.incCounter(id).observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {
                    Log.d("Livedata", "Loading ... ")
                }
                is Resource.Success -> {
                    val count = it.data.map {
                        it.count
                    }
                    binding.txtCounter.text = count.toString()
                    Log.d("Livedata", "${it.data} ")
                }
                is Resource.Failure -> {
                }
            }
        })
    }

    private fun decrementCounter(id: String) {
        viewModel.decCounter(id).observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {
                    Log.d("Livedata", "Loading ... ")
                }
                is Resource.Success -> {
                    val decCount = it.data.map {
                        it.count
                    }
                    binding.txtCounter.text = decCount.toString()
                    Log.d("Livedata", "${it.data}} ")
                }
                is Resource.Failure -> {
                }
            }
        })
    }

//    private fun deleteCounterInDetail(id: String) {
//        viewModel.deleteCounter(id).observe(viewLifecycleOwner, Observer {
//            when (it) {
//                is Resource.Loading -> {
//                    Log.d("Livedata", "Loading ... ")
//                }
//                is Resource.Success -> {
//                    activity?.onBackPressed()
//                    Log.d("Livedata", "${it.data}} ")
//                }
//                is Resource.Failure -> {
//                }
//            }
//        })
//    }

//    companion object {
//        fun newInstance() = DetailCounterFragment()
//    }
//
//    private lateinit var counter: Counter
//    private lateinit var viewModel: DetailCounterViewModel
//    private var total = 0
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        requireArguments().let {
//            DetailCounterFragmentArgs.fromBundle(it).also { args ->
//                counter = args.count
//            }
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.detail_counter_fragment, container, false)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(DetailCounterViewModel::class.java)
//
//        txt_name_counter.text = counter.title
//
//        btn_addition.setOnClickListener {
//            addition()
////            viewModel.incrementCounter(counter.id)
//            txt_counter.text = total.toString()
//
//        }
//
//        btn_decrement.setOnClickListener {
//            decrement()
////            viewModel.decrementCounter(counter.id)
//            txt_counter.text = total.toString()
//        }
//
//    }
//
//    private fun addition(){
//        total++
//    }
//
//    private fun decrement(){
//        total--
//    }

}