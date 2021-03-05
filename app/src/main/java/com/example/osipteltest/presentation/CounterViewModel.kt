package com.example.osipteltest.presentation

import androidx.lifecycle.*
import com.example.osipteltest.core.Resource
import com.example.osipteltest.data.model.Counter
import com.example.osipteltest.repository.CounterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    fun incCounter(id: String) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.postIncCounter(id)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun decCounter(id: String) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.postDecCounter(id)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun deleteCounter(id: String) {
        viewModelScope.launch {
            repository.deleteCounter(id)
        }
    }
}

class CounterViewModelFactory(private val repository: CounterRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CounterRepository::class.java).newInstance(repository)
    }

}