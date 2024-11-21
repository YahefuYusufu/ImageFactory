package com.prg.imagefactory.presentation.home_screen


import androidx.compose.runtime.Composable
import com.prg.imagefactory.domain.model.UnsplashImage
import com.prg.imagefactory.presentation.component.ImagesVerticalGrid


@Composable
fun HomeScreen(
    images: List<UnsplashImage>,
    onImageClick: (String) -> Unit
) {
    ImagesVerticalGrid(
        images = images,
        onImageClick = onImageClick
    )
}