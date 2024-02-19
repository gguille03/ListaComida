package mx.unam.fi.listacomida.data

import mx.unam.fi.listacomida.R
import mx.unam.fi.listacomida.model.Platillo

class DataSource {
    fun LoadPlatillos(): List<Platillo> {
        return listOf<Platillo>(
        Platillo(R.string.desayuno, R.drawable.desayuno, 5.0, true,50.6),
        Platillo(R.string.hamburger, R.drawable.hamburger, 5.0, true,150.99),
        Platillo(R.string.pizza, R.drawable.pizza, 5.0, true,199.99),
        Platillo(R.string.postre, R.drawable.postre, 5.0, true,50.99),
        Platillo(R.string.pozole, R.drawable.pozole, 5.0, true,150.99),
        Platillo(R.string.tacos, R.drawable.tacos, 5.0, true,30.99),
        )
    }
}