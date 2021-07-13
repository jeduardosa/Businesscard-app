package learn.dio.project.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import learn.dio.project.businesscard.data.BusinessCard
import learn.dio.project.businesscard.data.BusinessCardRepository

class MainViewModel(private val businessCardRepository: BusinessCardRepository) : ViewModel() {

    fun insert(businesCard: BusinessCard){
        businessCardRepository.insert(businesCard)
    }
    fun getAll() : LiveData<List<BusinessCard>> {
        return businessCardRepository.getAll()
    }

}

class MainViewModelFactory(private val repository: BusinessCardRepository) :
        ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
        @Suppress("UNCHEKED_CAST")
        return MainViewModel(repository) as T
        }
    throw IllegalArgumentException("Unknown ViewModel class")
    }

}