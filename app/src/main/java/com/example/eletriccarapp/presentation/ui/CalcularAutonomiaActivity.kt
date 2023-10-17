package com.example.eletriccarapp.presentation.ui

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.eletriccarapp.R
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class CalcularAutonomiaActivity : AppCompatActivity() {

    lateinit var preco: EditText
    lateinit var kmPercorrido: EditText
    lateinit var resultado: TextView
    lateinit var btnCalcular: Button
    lateinit var btnClose: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_autonomia)

        setupView()
        setupListeners()
        setupCachedResult()
    }

    private fun setupCachedResult() {
        val valorCalulado = getSharedPref()
        resultado.text = valorCalulado.toString()
    }

    fun setupView() {
        preco = findViewById(R.id.et_price_kwh)
        btnCalcular = findViewById(R.id.button_calculate)
        kmPercorrido = findViewById(R.id.et_traveled_kwh)
        resultado = findViewById(R.id.tv_result)
        btnClose = findViewById(R.id.iv_close)
    }

    fun setupListeners() {
        btnCalcular.setOnClickListener {
            calcular()
        }
        btnClose.setOnClickListener {
            finish()
        }
    }

    fun calcular() {
        val preco = preco.text.toString().toFloat()
        val km = kmPercorrido.text.toString().toFloat()
        val result = preco / km

        resultado.text = result.toString()
        saveSharedPref(result)
    }

    // salvando valor no SharedPreferences
    fun saveSharedPref(resultado : Float) {
        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putFloat(getString(R.string.saved_calc), resultado)
            apply()
        }
    }

    fun getSharedPref() : Float {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val calculo = sharedPref.getFloat(getString(R.string.saved_calc), 0.0f)
        return calculo
    }

}