package br.com.ads.jogoforca.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ads.jogoforca.R
import br.com.ads.jogoforca.model.Tema

@Composable
fun Texto(text : String){
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .width(34.dp),
        textAlign = TextAlign.Center,
        text = text
    )
}

@Composable
fun TemaCard(nome: String, id: Int, onItemSelected: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable(onClick = {
                onItemSelected()
            }) //Ir para a tela de jogo com o tema escolhido!
        ,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ImagemDoTema()
            Column {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                    ,
                    color = MaterialTheme.colorScheme.onPrimary,
                    text = nome,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(text = id.toString())
        }
    }
}

@Composable
private fun ImagemDoTema() { //id da imagem do tema como argumento!
    Image(
        painter = painterResource(R.drawable.image),
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
fun TemasScreen(user : String) {

    val tema1 = Tema(1,"Esportes",listOf("futebol", "basquete", "tênis", "natação", "ciclismo", "handebol", "vôlei", "rugby", "beisebol", "hóquei no gelo", "atletismo", "ginástica", "boxe", "luta livre", "golfe", "surfe", "mergulho", "vela", "remo", "canoagem", "esqui", "snowboard", "patinação no gelo", "curling", "bobsleigh", "caratê", "judô", "taekwondo", "aikido", "kung fu", "escalada", "montanhismo", "rapel", "paraquedismo", "balonismo", "League of Legends", "Counter-Strike: Global Offensive", "Dota 2", "Fortnite", "FIFA", "atletismo paralímpico", "natação paralímpica", "basquete em cadeira de rodas", "tênis em cadeira de rodas", "bocha"), 1)
    val tema2 = Tema(2,"Cidades",listOf("Nova York", "Paris", "Tóquio", "Londres", "Rio de Janeiro", "Washington D.C.", "Berlim", "Roma", "Madrid", "Moscou", "Atenas", "Jerusalém", "Cairo", "Machu Picchu", "Barcelona", "Veneza", "Amsterdã", "Istambul", "Cidade do México", "Queenstown", "Kyoto", "Vancouver", "Reykjavik", "Ushuaia", "Cusco", "Chichén Itzá", "Tikal", "Angkor Wat", "Lyon", "São Paulo", "Tóquio", "Nova Orleans", "Taipé", "Berlim", "Barcelona", "Londres"), 2)
    val tema3 = Tema(3,"Países",listOf("Brasil", "Estados Unidos", "China", "Índia", "Rússia", "Argentina", "México", "Chile", "Colômbia", "Peru", "Alemanha", "França", "Reino Unido", "Itália", "Espanha", "Nigéria", "Egito", "África do Sul", "Argélia", "Marrocos", "Japão", "Coréia do Sul", "Indonésia", "Turquia", "Paquistão", "Austrália", "Nova Zelândia", "Papua Nova Guiné", "Fiji", "Israel", "Vaticano", "Japão", "Arábia Saudita", "China"), 3)
    val tema4 = Tema(4,"Animais",listOf("leão", "elefante", "girafa", "panda", "tigre", "gorila", "chimpanzé", "rinoceronte", "hipopótamo", "lobo", "águia", "falcão", "papagaio", "tucano", "beija-flor", "cobra", "lagartixa", "tartaruga", "jacaré", "crocodilo", "sapo", "rã", "salamandra", "tubarão", "baleia", "golfinho", "salmão", "atum", "panda gigante", "tigre siberiano", "orangotango", "gorila das montanhas", "rinoceronte branco", "canguru", "camelo", "panda vermelho", "elefante africano", "pinguim imperador", "coruja", "morcego", "gambá", "raposa"), 4)
    val tema5 = Tema(5,"Frutas",listOf("maçã", "banana", "uva", "morango", "abacaxi", "laranja", "limão", "tangerina", "abacaxi", "kiwi", "morango", "framboesa", "cereja", "amora", "goiaba", "manga", "abacaxi", "maracujá", "coco", "cupuaçu", "graviola", "jabuticaba", "cajá", "caju", "uva-passa", "ameixa", "damasco", "figo", "tâmara"), 5)
    val tema6 = Tema(6,"Objetos",listOf("computador", "livro", "chave", "copo", "cadeira", "cama", "mesa", "sofá", "fogão", "impressora", "caneta", "papel", "telefone", "prato", "copo", "talheres", "panela", "frigideira", "escova de dentes", "pasta de dente", "sabonete", "shampoo", "condicionador", "calça", "camisa", "sapato", "meia", "chapéu", "relógio", "óculos", "chave", "carteira", "celular", "televisão", "smartphone", "tablet", "videogame", "drone", "pintura", "escultura", "música", "dança", "teatro", "bola", "chuteira", "raquete", "bicicleta", "skate", "martelo", "prego", "furadeira", "serra", "chave de fenda"), 6)

    val temas = arrayListOf(
        tema1,
        tema2,
        tema3,
        tema4,
        tema5,
        tema6
    )


    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onSecondary,
                ),
                title = {
                    Texto("Jogo da Forca")
                },
                navigationIcon = {
                    IconButton(onClick = {
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu"
                        )
                    }
                },
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            ) {
                Texto(user.uppercase().split(" ").first() + " - ADS - IFTM - 2023")
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
            // Save the selected item using rememberSavedInstanceState
            var selectedItem = remember { mutableStateOf(0) }

            LazyColumn {
                items(temas) { tema ->
                    TemaCard(
                        tema.nome,
                        tema.id,
                        onItemSelected  = {
                            selectedItem.value = tema.id
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() { //tela de preview do código
    br.com.ads.jogoforca.ui.theme.JogoForcaTheme {
        TemasScreen("Murilo Dii")
    }
}