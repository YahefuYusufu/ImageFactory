package com.prg.imagefactory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prg.imagefactory.ui.theme.ImageFactoryTheme
import com.prg.imagefactory.presentation.home_screen.HomeScreen
import com.prg.imagefactory.presentation.home_screen.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImageFactoryTheme {
                val viewModel = viewModel<HomeViewModel>()
                HomeScreen(
                    images = viewModel.images,
                    onImageClick = {}
                )
            }
        }
    }
}

