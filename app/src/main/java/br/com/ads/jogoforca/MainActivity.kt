package br.com.ads.jogoforca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ads.jogoforca.ui.theme.JogoForcaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JogoForcaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScaffoldTela()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JogoForcaTheme {
        ScaffoldTela()
    }
}

@Composable
fun teste() {
    Column(
        Modifier
            .height(350.dp)
            .width(400.dp)
    ) {
        Box(
            Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(Color.DarkGray))
        Image(painter = painterResource(id = R.drawable.teste),
            contentDescription = "Descrição da imagem",
            Modifier
                .size(100.dp)
                .offset(y = (-50).dp)
        )
    }
}

@Composable
fun texto(text : String){
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .width(34.dp),
        textAlign = TextAlign.Center,
        text = text
    )
}

@Composable
fun TemaCard(nome: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable(onClick = {}) //Ir para a tela de jogo com o tema escolhido!

        ,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            ImagemDoTema()
            Column {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        ,
                    color = MaterialTheme.colorScheme.onPrimary,
                    text = nome)
            }
        }
    }
}

@Composable
private fun ImagemDoTema() { //id da imagem do tema como argumento!
    Image(
        painter = painterResource(R.drawable.teste),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldTela() {
    var presses by remember { mutableStateOf(0) }
    var listaDeTemas by remember { mutableStateOf(listOf<String>())}
    listaDeTemas = listaDeTemas + "Esporte"
    listaDeTemas = listaDeTemas + "Cidade"

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onSecondary
                ),
                title = {
                    texto("Jogo Forca")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            ) { texto("ADS - IFTM") }
        }
        ,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                presses++
//                listaDeTemas = listaDeTemas + "Filmes"
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add")

            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.secondary)
                .fillMaxHeight()
                ,

            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
//            teste()
//            Text(
//                modifier =
//                Modifier
//                    .padding(8.dp)
//                    ,
//
//                text =
//                """
//                    You have pressed the floating action button $presses times.
//                """.trimIndent()
//                    ,
//                color = MaterialTheme.colorScheme.onPrimary,
//            )
            LazyColumn {
                items(listaDeTemas) { tema ->
                    TemaCard(tema)
                }
                //Text("ID: ${pessoa.id}, Nome: ${pessoa.nome}")
            }



        }
    }
}