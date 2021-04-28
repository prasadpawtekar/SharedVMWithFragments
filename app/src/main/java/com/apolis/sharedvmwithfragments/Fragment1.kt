package com.apolis.sharedvmwithfragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders

class Fragment1 : Fragment() {
    val viewModel: SharedViewModel by activityViewModels()

    lateinit var tvMsg: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //viewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_one, null)
        tvMsg = view.findViewById(R.id.tv_msg)
        initObserver()
        return view
    }

    fun initObserver() {
        viewModel.num.observe(viewLifecycleOwner){
            tvMsg.text = "I am fragment_one and got number = $it"

            viewModel.msg.postValue("Got number : $it")

            Log.d("Fragment", "initObserver: I am fragment_one and got number = $it")
        }
    }
}