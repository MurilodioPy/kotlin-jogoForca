package br.com.ads.jogoforca.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ads.jogoforca.R
import br.com.ads.jogoforca.ui.theme.screens.ui.theme.JogoForcaTheme

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .padding(
                    vertical = 16.dp,
                    horizontal = 16.dp
                )
                .size(150.dp)
                .background(
                    MaterialTheme.colorScheme.secondary,
                    shape = CircleShape,
                )
        ) {
            val borderWidth = 4.dp
            Image(
                painter = painterResource(R.drawable.carrasco),
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
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Bem-vindo ao Jogo da Forca",
            style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    JogoForcaTheme {
        SplashScreen()
    }
}