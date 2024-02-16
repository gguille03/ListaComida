package mx.unam.fi.listacomida.data

import mx.unam.fi.listacomida.R
import mx.unam.fi.listacomida.model.Platillo

class DataSource {
    fun LoadPlatillos(): List<Platillo> {
        return listOf<Platillo>(
        Platillo(R.string.desayuno, R.drawable.desayuno),
        Platillo(R.string.hamburger, R.drawable.hamburger),
        Platillo(R.string.pizza, R.drawable.pizza),
        Platillo(R.string.postre, R.drawable.postre),
        Platillo(R.string.pozole, R.drawable.pozole),
        Platillo(R.string.tacos, R.drawable.tacos),
        )
    }
}