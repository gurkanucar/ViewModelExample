package com.gusoft.viewmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this@MainActivity).get(DataViewModel::class.java)

        viewModel.currentNumber.observe(this, Observer {
            tv_value.text = it.toString()
        })

        viewModel.currentBoolean.observe(this, Observer {
            tv_result.text = it.toString()
        })

        increase_btn.setOnClickListener { increment() }
        decrease_btn.setOnClickListener { decrement() }

    }

    private fun increment() {
        viewModel.currentNumber.value = ++viewModel.number
        viewModel.currentBoolean.value = viewModel.number % 2 == 0
    }

    private fun decrement() {
        if (viewModel.currentNumber.value == 0) {
            Toast.makeText(this, "You can not decrease the value!", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.currentNumber.value = --viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 == 0
        }
    }

}