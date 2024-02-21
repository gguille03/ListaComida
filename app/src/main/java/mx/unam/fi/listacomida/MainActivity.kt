package mx.unam.fi.listacomida


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import mx.unam.fi.listacomida.data.DataSource
import mx.unam.fi.listacomida.model.Platillo
import mx.unam.fi.listacomida.ui.theme.ListaComidaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaComidaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Content
                    val platillos = DataSource().LoadPlatillos()
                    PlatilloList(platillos)
                    //DataSource().LoadPlatillos()
                }
            }
        }
    }
}

@Composable
fun PlatilloList(platillos: List<Platillo>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(platillos) { platillo ->
            MenuCard(platillo = platillo, modifier = Modifier.fillParentMaxWidth())
        }
    }
}

@Composable
fun MenuCard(platillo: Platillo, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(vertical = 15.dp)) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = platillo.drawableResourceId),
                contentDescription = stringResource(id = platillo.stringResourceId),
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = stringResource(id = platillo.stringResourceId),
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "$ ${platillo.precio}",
                    style = MaterialTheme.typography.bodyLarge
                )
                if (platillo.b) {
                    Text(
                        text = "Oferta %${platillo.d}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Red
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPlatilloPreview() {
    ListaComidaTheme {
        PlatilloList(
            listOf(
                Platillo(R.string.postre, R.drawable.postre, 5.0, true, 60.99),
                Platillo(R.string.tacos, R.drawable.tacos, 10.0, false,50.99),
                Platillo(R.string.hamburger, R.drawable.hamburger, 8.0, true,100.99),
                Platillo(R.string.pizza, R.drawable.pizza, 8.0, true,199.99),
                Platillo(R.string.pozole, R.drawable.pozole, 8.0, false,150.01),
                Platillo(R.string.desayuno, R.drawable.desayuno, 8.0, false,70.50)
            )
        )

    }
}
