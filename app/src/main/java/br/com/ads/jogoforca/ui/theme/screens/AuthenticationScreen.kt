package br.com.ads.jogoforca.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ads.jogoforca.R
import br.com.ads.jogoforca.ui.theme.screens.ui.theme.JogoForcaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthenticationScreen(
    onEnterClick: (String) -> Unit = {}
) {
    Column(
        Modifier
            .fillMaxSize()
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
            Text(
                text = "Jogo da Forca",
                Modifier
                    .padding(8.dp)
                    .align(Alignment.Center),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
        }
        var user by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        val fieldsModifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp,
            )
            .fillMaxWidth()
        var isUserEmpty by rememberSaveable { mutableStateOf(false) }
        TextField(
            value = user,
            onValueChange = {
                user = it
                isUserEmpty = false
            },
            fieldsModifier,
            placeholder = {
                Text(text = stringResource(id = R.string.userPlaceHolder))
            },
            trailingIcon = {
                if(isUserEmpty){
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Error",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            },
            isError = isUserEmpty
        )
        if(isUserEmpty){
            Text(
                text = "Dado obrigatório",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
                )
        }
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            fieldsModifier,
            placeholder = {
                Text(text = stringResource(id = R.string.passwordPlaceHolder))
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

        )
        Button(
            onClick = {
                if(user.isNotEmpty()){
                    onEnterClick(user)

                }else{
                    isUserEmpty = true
                }
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
        TextButton(
            onClick = { onEnterClick(user) },
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            Text(text = "Register")
        }
    }
}

@Preview
@Composable
fun AuthenticationScreenPreview() {
    JogoForcaTheme {
        Surface {
            AuthenticationScreen()
        }
    }
}