package com.prg.imagefactory

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prg.imagefactory.ui.theme.ImageFactoryTheme
import com.prg.imagefactory.presentation.home_screen.HomeScreen
import com.prg.imagefactory.presentation.home_screen.HomeViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImageFactoryTheme {
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
                val viewModel = viewModel<HomeViewModel>()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(scrollBehavior.nestedScrollConnection)
                ) {
                    HomeScreen(
                        scrollBehavior = scrollBehavior,
                        images = viewModel.images,
                        onImageClick = {},
                        onSearchClick = {},
                        onFABClick = {}
                    )
                }
            }
        }
    }
}

