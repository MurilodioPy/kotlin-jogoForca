package br.com.ads.jogoforca.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.ads.jogoforca.R
import br.com.ads.jogoforca.sampledata.DataProvider
import br.com.ads.jogoforca.ui.theme.screens.ui.theme.JogoForcaTheme
import java.text.Normalizer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    id : String,
    navController: NavHostController
) {
    var count by remember { mutableIntStateOf(6)}
    val temas = DataProvider.temas
    val vidas = remember { DataProvider.vidas }
    val tema = temas[id.toInt() - 1]
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
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
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
                        vertical = 16.dp,
                        horizontal = 16.dp
                    )
                    .size(200.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        ),
                        shape = RoundedCornerShape(32.dp),
                    )
            ) {
                Image(
                    painter = painterResource(vidas[count]),
                    contentDescription = "Imagem do tema",
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            BorderStroke(4.dp, MaterialTheme.colorScheme.secondary),
                            RoundedCornerShape(32.dp)
                        )
                )
            }
            val chosenWord = remember { tema.listaPalavras?.random().toString() }
            val cleanChosenWord = removeAccents(chosenWord)
            var displayViewWord by remember { mutableStateOf("") }
            val display = remember { ArrayList<String>() }
            val displayWrongLetters = remember { ArrayList<String>() }
            var displayViewWrongLetters by remember { mutableStateOf("") }
            var isFirstTime by remember { mutableStateOf(true) }
            var isLetterCorrect by rememberSaveable { mutableStateOf(false) }
            var isFinish by rememberSaveable { mutableStateOf(false) }
            var isFinishWin by rememberSaveable { mutableStateOf(false) }
            if (isFirstTime) {
                cleanChosenWord.forEachIndexed { index, c ->
                    if (c.isLetter()) {
                        display.add(index, "-")
                    } else {
                        display.add(index, " ")
                    }
                }
                displayViewWord = display.joinToString(" ")
                isFirstTime = false
            }

            val fieldsModifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp,
                )
                .fillMaxWidth()

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                text = displayViewWord,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onTertiary
            )
            var isLetterEmpty by rememberSaveable { mutableStateOf(false) }
            var letraDigitada by remember { mutableStateOf("") }
            val maxLength = 1
            if (!isFinish) {
                val regex = "[a-zA-Z]*".toRegex()
                TextField(
                    value = letraDigitada,
                    onValueChange = {
                        if (it.length <= maxLength && it.matches(regex)) {
                            letraDigitada = it
                        }
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                    modifier = fieldsModifier,
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.placeHolderLetter)
                        )
                    },
                    trailingIcon = {
                        if (isLetterEmpty) {
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = "Error",
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                    },
                    isError = isLetterEmpty
                )
                if (isLetterEmpty) {
                    Text(
                        text = "Digite uma letra",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                if (displayWrongLetters.isNotEmpty()) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        textAlign = TextAlign.Center,
                        text = displayViewWrongLetters,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
                Button(
                    onClick = {
                        if (letraDigitada.isNotEmpty()) {
                            cleanChosenWord.forEachIndexed { index, c ->
                                if (c.isLetter()) {
                                    if (letraDigitada.equals(c.toString(), ignoreCase = true)) {
                                        display.removeAt(index)
                                        display.add(index, c.toString())
                                        isLetterCorrect = true
                                    }
                                }
                            }
                            displayViewWord = display.joinToString(" ")
                            if (!isLetterCorrect) {
                                count--
                                if(!displayWrongLetters.contains(letraDigitada)){
                                    displayWrongLetters.add(letraDigitada)
                                }
                                displayViewWrongLetters = displayWrongLetters.joinToString(" ")
                                if (count == 0) {
                                    isFinish = true
                                }
                            }
                            if (!display.contains("-")) {
                                displayViewWord = chosenWord
                                isFinish = true
                                isFinishWin = true
                            }
                        } else {
                            isLetterEmpty = true
                        }
                        isLetterCorrect = false
                        letraDigitada = ""
                    },
                    Modifier
                        .padding(
                            top = 8.dp,
                            start = 16.dp,
                            end = 16.dp,
                        )
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Enter",
                        color = MaterialTheme.colorScheme.onPrimary)
                }
            } else{
                Icon(
                    imageVector = if(isFinishWin){Icons.Filled.Check }else{Icons.Filled.Clear},
                    tint = if(isFinishWin){Color.Green}else{Color.Red},
                    contentDescription = "Resultado",
                    modifier = Modifier
                        .scale(10.5f)
                        .padding(top = 15.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )
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
fun GamePreview() {
    JogoForcaTheme {
        val navController = rememberNavController()
        val tema = DataProvider.tema5
        GameScreen(tema.id.toString(), navController)
    }
}