package br.com.ads.jogoforca.ui.theme.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ads.jogoforca.R
import br.com.ads.jogoforca.model.Tema
import br.com.ads.jogoforca.sampledata.DataProvider
import br.com.ads.jogoforca.ui.theme.screens.ui.theme.JogoForcaTheme
import java.text.Normalizer

class GameScreens : ComponentActivity() {

    private val tema : Tema by lazy {
        intent?.getSerializableExtra(TEMA_ID) as Tema
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JogoForcaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameScreen(tema)
                }
            }
        }
    }

    companion object {
        private const val TEMA_ID = "tema_id"
        fun newIntent(context: Context, tema : Tema) =
            Intent(context, GameScreens::class.java).apply {
                putExtra(TEMA_ID, tema)
            }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(tema: Tema) {
    var count by remember { mutableStateOf(6) }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onSecondary,
                ),
                title = {
                    Texto("Tema ${tema.nome}" )
                },
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        IconButton(onClick = { count++ }) {
                            Icon(Icons.Filled.Favorite,
                                tint = Color.Red,
                                contentDescription = "Vidas",
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }
                        Text(
                            text = count.toString(),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.secondary)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(
                        vertical = 64.dp,
                        horizontal = 16.dp
                    )
                    .size(200.dp)
                    .background(
                        MaterialTheme.colorScheme.primary,
                        shape = CircleShape,
                    )
            ) {
                val borderWidth = 4.dp
                Image(
                    painter = painterResource(tema.imagem),
                    contentDescription = "Imagem do tema",
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            BorderStroke(borderWidth, MaterialTheme.colorScheme.primary),
                            CircleShape
                        )
                        .clip(CircleShape)
                )
            }
            val chosenWord = remember { tema.listaPalavras?.random().toString()}
            val cleanChosenWord = removeAccents(chosenWord)
            var displayViewWord = ""
            var display : ArrayList<String> = ArrayList()

            cleanChosenWord.forEachIndexed { index, c ->
                if (c.isLetter()){
                    display.add(index, "-")
                }else{
                    display.add(index, " ")
                }
            }
            displayViewWord = display.joinToString(" ")

            val fieldsModifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp,
                )
                .fillMaxWidth()

            Log.i("TST1", displayViewWord)
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                textAlign = TextAlign.Center,
                text = "Palavra: $displayViewWord \nResposta: $chosenWord",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
            var isLetterEmpty by rememberSaveable { mutableStateOf(false) }
            var letra by remember { mutableStateOf("") }
            TextField(
                value = letra,
                onValueChange = {
                    letra = it
                },
                fieldsModifier,
                placeholder = {
                    Text(text = stringResource(id = R.string.placeHolderLetter))
                },
                trailingIcon = {
                    if(isLetterEmpty){
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "Error",
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                },
                isError = isLetterEmpty
            )
            if(isLetterEmpty){
                Text(
                    text = "Digite uma letra",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            var isLetterCorrect by rememberSaveable { mutableStateOf(false) }
            Button(
                onClick = {
                    if(letra.isNotEmpty()){
//                        val newDisplay = display.toMutableList()
                        cleanChosenWord.forEachIndexed { index, c ->
                            if (c.isLetter()){
                                if(letra.equals(c.toString(), ignoreCase = true)){
                                    display.removeAt(index)
                                    display.add(index, c.toString())
                                    isLetterCorrect = true
                                }
                            }
                        }
                        displayViewWord = display.joinToString(" ")
                        if (!isLetterCorrect){
                            count -= 1
                        }
                    }else{
                        isLetterEmpty = true
                    }
                    isLetterCorrect = false
                    Log.i("TST2", displayViewWord)
                },
                Modifier
                    .padding(
                        top = 8.dp,
                        start = 16.dp,
                        end = 16.dp,
                    )
                    .fillMaxWidth(),
            ) {
                Text(text = "Enter")
            }
        }
    }
}

fun removeAccents(input: String): String {
    val decomposed = Normalizer.normalize(input, Normalizer.Form.NFD)
    return decomposed.replace("\\p{InCombiningDiacriticalMarks}+".toRegex(), "")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    JogoForcaTheme {
        val tema = DataProvider.tema5
        GameScreen(tema)
    }
}