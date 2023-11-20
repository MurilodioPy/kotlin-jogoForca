package br.com.ads.jogoforca.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.ads.jogoforca.R

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.tertiary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Você pode substituir a imagem abaixo pelo seu próprio recurso
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .background(color = MaterialTheme.colorScheme.secondary, shape = MaterialTheme.shapes.medium)
                .padding(16.dp)
                .scale(1.5f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Adicione qualquer texto ou elemento adicional que você deseja exibir
        Text(text = "Bem-vindo ao Jogo da Forca", style = MaterialTheme.typography.bodyLarge)
    }
}