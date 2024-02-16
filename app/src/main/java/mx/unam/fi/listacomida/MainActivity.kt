package mx.unam.fi.listacomida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
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


                }
            }
        }
    }
}

@Composable
fun MenuCard(platillo: Platillo, modifier: Modifier = Modifier){
    Card(modifier = Modifier){
        Column {
            Image(
                painter = painterResource(id = platillo.drawableResourceId),
                contentDescription = stringResource(id = platillo.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp),
                contentScale = ContentScale.Crop

            )
            Text(
                text= LocalContext.current.getString(platillo.stringResourceId),
                modifier= Modifier.padding(22.dp),
                style = MaterialTheme.typography.headlineMedium
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun MenuPlatilloPreview(){
    ListaComidaTheme {
        MenuCard( platillo = Platillo(R.string.tacos,R.drawable.tacos))
    }
}
