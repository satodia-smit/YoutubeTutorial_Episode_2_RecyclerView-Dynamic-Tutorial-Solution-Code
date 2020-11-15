package com.hyperelement.mvvmdemo.ui.fragment.fragmentone

import androidx.lifecycle.MutableLiveData
import com.hyperelement.mvvmdemo.data.datasources.local.EmployeeEntity
import com.hyperelement.mvvmdemo.data.repository.FragmentOneRepository
import com.hyperelement.mvvmdemo.utilities.RootViewModel
import timber.log.Timber

private const val TAG = "FragmentOneViewModel"

class FragmentOneViewModel(
    private val mRepo: FragmentOneRepository
) : RootViewModel() {

    val mEmployeeList = MutableLiveData<List<EmployeeEntity>>()

    fun loadEmployeeFromStorage() {
        val response = mRepo.getEmployee()
        if (response.isEmpty()) {
            Timber.d("No Employee available")
        } else {
            mEmployeeList.postValue(response)
        }
    }
}