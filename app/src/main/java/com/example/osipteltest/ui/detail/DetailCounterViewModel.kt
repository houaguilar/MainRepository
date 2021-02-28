package com.example.osipteltest.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel

import com.example.osipteltest.data.model.CreateNewCounter
import com.example.osipteltest.data.model.IdCounter
import com.example.osipteltest.ui.main.MainCounterViewModel

class DetailCounterViewModel : ViewModel() {

//    companion object{
//        private val TAG = MainCounterViewModel::class.qualifiedName
//    }
//
//    private val disposableC = CompositeDisposable()
//    private val service: ApiService = RequestCreateNewCounter.rxr
//
//    fun incrementCounter(id: String){
//        disposableC += service.incrementCounter(idCounter= IdCounter(id))
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { counter -> updateUi(counter) },
//                { error -> updateUi(error) }
//            )
//    }
//
//    fun decrementCounter(id: String){
//        disposableC += service.decrementCounter(idCounter= IdCounter(id))
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