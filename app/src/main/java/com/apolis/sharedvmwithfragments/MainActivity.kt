package com.apolis.sharedvmwithfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)
        btn_get_random.setOnClickListener {
            viewModel.generateNext()
        }

        viewModel.msg.observe(this) { msg ->
            Log.d("FragmentMsg", "onCreate: message is : $msg")
            val snackbar = Snackbar.make(
                layout,
                msg,
                Snackbar.LENGTH_LONG
            ).setAction("Ok") {

            }
            snackbar.show()
        }
        val f1 = Fragment1()
        val f2 = Fragment2()
        val f3 = Fragment3()

        supportFragmentManager.beginTransaction().add(R.id.fm_container, f1).addToBackStack("one")
            .commit()
        supportFragmentManager.beginTransaction().add(R.id.fm_container, f2).addToBackStack("two")
            .commit()
        supportFragmentManager.beginTransaction().add(R.id.fm_container, f3).addToBackStack("three")
            .commit()
    }
}