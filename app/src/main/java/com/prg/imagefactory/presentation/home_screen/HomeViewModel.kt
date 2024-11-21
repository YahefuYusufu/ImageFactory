package com.prg.imagefactory.presentation.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prg.imagefactory.data.mapper.toDomainModelList
import com.prg.imagefactory.di.AppModule
import com.prg.imagefactory.domain.model.UnsplashImage
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    var images: List<UnsplashImage> by mutableStateOf(emptyList())
        private set

    init {
        getImages()
    }

    private fun getImages() {
        viewModelScope.launch {
            val result = AppModule.retrofitService.getEditorialFeedImages()
            images = result.toDomainModelList()
        }
    }

}