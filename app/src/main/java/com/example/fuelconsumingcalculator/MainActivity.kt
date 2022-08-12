package com.example.fuelconsumingcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fuelconsumingcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateConsumption.setOnClickListener{ calculateCons() }
        
    }

    private fun calculateCons() {

        val stringInTextField = binding.kmTraveled.text.toString()
        val kmTra = stringInTextField.toDoubleOrNull()
        if (kmTra == null) {
            binding.kmPerLt.text = ""
            return
        }

        val stringInTextFieldTwo = binding.fillUp.text.toString()
        val ltToFill = stringInTextFieldTwo.toDoubleOrNull() ?: return

        val cons = kmTra / ltToFill


        val formattedCons = NumberFormat.getInstance().format(cons)
        binding.kmPerLt.text = getString(R.string.car_cons, formattedCons)


    }
}