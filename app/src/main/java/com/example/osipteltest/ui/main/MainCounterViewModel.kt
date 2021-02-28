package com.example.osipteltest.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel


class MainCounterViewModel : ViewModel() {

//    companion object {
//        private val TAG = MainCounterViewModel::class.qualifiedName
//    }
//
//    var counters: ArrayList<Counter> = ArrayList()
//    private lateinit var disposable: Disposable
//    private val disposableC = CompositeDisposable()
//    private val service: ApiService = RequestCreateNewCounter.rxr
//
////    fun loadData(view: MainCounterFragment){
////        if (counters.size == 0){
////            disposable = RequestListCounter.getListCounters()
////                .subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribe { listCounters ->
////                    this.counters = listCounters
////                    view.fillCounterRecyclerView(this.counters)
////                }
////        }else{
////            view.fillCounterRecyclerView(this.counters)
////        }
////    }
////    fun clearMemory(){
////        disposable.dispose()
////    }
//
//    fun loadData(view: MainCounterFragment) {
//
//        if (counters.size == 0) {
//            disposableC += service.getCounter()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                    { counter -> updateUi(counter) },
//                    { error -> updateUi(error) }
//                )
//        } else {
//            view.fillCounterRecyclerView(this.counters)
//        }
//
//    }
//
////    fun clearMemory() {
////        disposable.dispose()
////    }
//
//    fun newCounterAdd(title: String) {
//        disposableC += service.createNewCounter(createNewCounter = CreateNewCounter(title))
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { counter -> updateUi(counter) },
//                { error -> updateUi(error) }
//            )
//    }
//
//    private fun updateUi(s: Any) {
//        Log.v(TAG, s.toString())
//    }
//
//    override fun onCleared() {
//        disposableC.clear()
//    }
}