package com.example.osipteltest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.osipteltest.core.Resource
import com.example.osipteltest.repository.CounterRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class CounterViewModel (private val repository: CounterRepository): ViewModel() {

    fun fetchMainCounters() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.getCounters()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun newCounterAdd(title: String) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.postCounter(title)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}

class CounterViewModelFactory(private val repository: CounterRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CounterRepository::class.java).newInstance(repository)
    }

}