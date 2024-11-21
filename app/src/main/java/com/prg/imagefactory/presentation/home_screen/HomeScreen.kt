package com.prg.imagefactory.presentation.home_screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import com.prg.imagefactory.domain.model.UnsplashImage
import com.prg.imagefactory.presentation.component.ImageCard


@Composable
fun HomeScreen(
    images: List<UnsplashImage>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        images.forEach { image ->
            ImageCard(image = image)
        }
    }
}