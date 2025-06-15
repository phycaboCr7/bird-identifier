package com.birdidentifier.app.ui.screens.gallery

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun GalleryScreen(
    onNavigateBack: () -> Unit = {},
    onBirdClick: (String) -> Unit = {}
) {
    Text("Gallery Screen Placeholder")
}
