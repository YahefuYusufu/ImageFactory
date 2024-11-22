package com.prg.imagefactory.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prg.imagefactory.domain.model.UnsplashImage

@Composable
fun ImagesVerticalGrid(
    modifier: Modifier = Modifier,
    images: List<UnsplashImage?>,
    onImageClick: (String) -> Unit
) {
    LazyVerticalStaggeredGrid(
        modifier = modifier,
        columns = StaggeredGridCells.Adaptive(140.dp),
        contentPadding = PaddingValues(10.dp),
        verticalItemSpacing = 10.dp,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(images) { image ->
            ImageCard(
                image = image,
                modifier = Modifier
                    .clickable { image?.id?.let { onImageClick(it) } }
            )
        }
    }
}