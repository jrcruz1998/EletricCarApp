package com.example.eletriccarapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.eletriccarapp.R
import com.example.eletriccarapp.presentation.adapter.CarAdapter
import com.example.eletriccarapp.presentation.data.Carro
import com.example.eletriccarapp.presentation.data.local.CarRepository

class FavoriteFragment : Fragment() {

    lateinit var listaCarrosFavoritos: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorite_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView(view)
        val carList = getCarsOnLocalDb()
        setupList()
    }

    private fun getCarsOnLocalDb(): List<Carro> {
        val repository = CarRepository(requireContext())
        val carList = repository.getAll()
        return carList
    }

    fun setupView(view: View) {
        view.apply {
            listaCarrosFavoritos = findViewById(R.id.rv_lista_carros_favoritos)
        }
    }

    fun setupList() {
        val cars = getCarsOnLocalDb()
        val adapter = CarAdapter(cars, isFavoriteScreen = true)

        // Lista aparece após o icone de carregando
        listaCarrosFavoritos.visibility = View.VISIBLE
        listaCarrosFavoritos.adapter = adapter

        adapter.carItemListener = { carro ->
            val isDelete = CarRepository(requireContext()).saveIfNotExist(carro)
        }
    }
}