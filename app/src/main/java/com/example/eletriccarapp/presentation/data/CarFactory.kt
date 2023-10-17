package com.example.eletriccarapp.presentation.data

object CarFactory {

    val list = listOf(
        Carro(
            id = 1,
            preco = "R$ 300.00,00",
            bateria = "300 kWh",
            potencia = "200 cv",
            recarga = "30 min",
            urlPhoto = "www.google.com.br",
            isFavorite = false
        ),
        Carro(
            id = 2,
            preco = "R$ 150.00,00",
            bateria = "200 kWh",
            potencia = "100 cv",
            recarga = "35 min",
            urlPhoto = "www.google.com",
            isFavorite = false
        )
    )
        // VERBOS HTTP
        // GET -> Para recuperar infirmações
        // POST -> Para enviar informações para um servidor
        // DELETE -> Para deletar algum recurso
        // PUT -> Alterar uma entidade com um todo (ex.: alterar a entidade Carro TODA)
        // PATCH -> Alterar um atriburo da entidade (ex.: alterar o atriburo PREÇO somente)
}