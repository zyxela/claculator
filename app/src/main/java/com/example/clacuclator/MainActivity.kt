package com.example.clacuclator

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.clacuclator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), LifecycleOwner {
    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation =
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT //BAD EXPERIENCE. Instead of create a new layout file
        // and make markup for landscape orientation

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.currentExpression.value = ""
        viewModel.currentExpression.observe(this) {
            binding.editTextText.setText(viewModel.currentExpression.value)
        }

        with(binding) {
            zero.setOnClickListener {
                viewModel.addElem('0')
            }

            one.setOnClickListener {
                viewModel.addElem('1')
            }

            two.setOnClickListener {
                viewModel.addElem('2')
            }

            three.setOnClickListener {
                viewModel.addElem('3')
            }

            four.setOnClickListener {
                viewModel.addElem('4')
            }

            five.setOnClickListener {
                viewModel.addElem('5')
            }

            six.setOnClickListener {
                viewModel.addElem('6')
            }

            seven.setOnClickListener {
                viewModel.addElem('7')
            }
            eight.setOnClickListener {
                viewModel.addElem('8')
            }

            nine.setOnClickListener {
                viewModel.addElem('9')
            }

            ac.setOnClickListener {
                viewModel.clear()
            }

            per.setOnClickListener {
                viewModel.addElem('%')
            }

            div.setOnClickListener {
                viewModel.addElem('/')
            }

            multiple.setOnClickListener {
                viewModel.addElem('*')
            }
            plus.setOnClickListener {
                viewModel.addElem('+')
            }
            minus.setOnClickListener {
                viewModel.addElem('-')
            }
            equal.setOnClickListener {
                viewModel.equal(editTextText.text.toString())
            }
            clr.setOnClickListener {
                viewModel.delLast()
            }
            brackets.setOnClickListener {
                viewModel.brackets()
            }
        }

    }
}