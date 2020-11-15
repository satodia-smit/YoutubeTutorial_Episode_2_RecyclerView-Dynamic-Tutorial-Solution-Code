package com.hyperelement.mvvmdemo.ui.fragment.fragmentone

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.hyperelement.mvvmdemo.R
import com.hyperelement.mvvmdemo.arch.BaseFragment
import com.hyperelement.mvvmdemo.data.datasources.local.EmployeeEntity
import com.hyperelement.mvvmdemo.databinding.FragmentOneBinding
import kotlinx.android.synthetic.main.fragment_one.*
import smartadapter.SmartRecyclerAdapter

class FragmentOne :
    BaseFragment<FragmentOneViewModel>(R.layout.fragment_one, FragmentOneViewModel::class) {

    private lateinit var adapter: SmartRecyclerAdapter

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getSpecificBinding<FragmentOneBinding>()?.viewModel = viewModel

        adapter = SmartRecyclerAdapter.empty()
            .map(EmployeeEntity::class, GenericVH::class)
            .into(rvEmployee)

//        adapter.addItem(EmployeeEntity(id = 1, name = "smit"))
//        adapter.addItem(EmployeeEntity(id = 1, name = "ABC"))

        viewModel.loadEmployeeFromStorage()
c
        viewModel.mEmployeeList.observe(viewLifecycleOwner, Observer {
            adapter.addItems(it)
        })
    }
}