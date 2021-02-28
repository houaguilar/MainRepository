package com.example.osipteltest.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.osipteltest.R
import com.example.osipteltest.databinding.DetailCounterFragmentBinding
import java.util.*

class DetailCounterFragment : Fragment(R.layout.detail_counter_fragment) {

    private lateinit var binding: DetailCounterFragmentBinding
    private val args by navArgs<DetailCounterFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DetailCounterFragmentBinding.bind(view)

        binding.txtNameCounter.text = args.title
        binding.txtCounter.text = args.count.toString()
    }

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