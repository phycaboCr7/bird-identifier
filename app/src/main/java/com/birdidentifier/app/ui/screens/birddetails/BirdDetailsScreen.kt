package com.birdidentifier.app.ui.screens.birddetails

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.compose.ui.viewinterop.AndroidView
import com.birdidentifier.app.BirdIdentifierApp
import com.birdidentifier.app.data.model.BirdDetails
import com.birdidentifier.app.data.model.ColorPalette
import com.birdidentifier.app.data.repository.BirdRepository
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirdDetailsScreen(
    birdId: String,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var birdDetails by remember { mutableStateOf<BirdDetails?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }
    var isPlaying by remember { mutableStateOf(false) }
    
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            playWhenReady = false
            repeatMode = ExoPlayer.REPEAT_MODE_OFF
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    LaunchedEffect(birdId) {
        try {
            // TODO: Replace with actual API call
            birdDetails = BirdRepository.getBirdDetails(birdId)
            isLoading = false
        } catch (e: Exception) {
            error = e.message
            isLoading = false
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(birdDetails?.name ?: "Bird Details") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        when {
            isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            error != null -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Error: $error")
                }
            }
            birdDetails != null -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    // Bird Image
                    item {
                        AsyncImage(
                            model = birdDetails?.imageUrl,
                            contentDescription = "Bird Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp),
                            contentScale = ContentScale.Crop
                        )
                    }

                    // Bird Name and Scientific Name
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = birdDetails?.name ?: "",
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = birdDetails?.scientificName ?: "",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    // Color Palette
                    item {
                        ColorPaletteSection(birdDetails?.colors ?: emptyList())
                    }

                    // Location and Habitat
                    item {
                        InfoSection(
                            title = "Location & Habitat",
                            content = birdDetails?.habitat ?: "",
                            icon = Icons.Default.LocationOn
                        )
                    }

                    // Diet Information
                    item {
                        InfoSection(
                            title = "Diet",
                            content = birdDetails?.diet ?: "",
                            icon = Icons.Default.Restaurant
                        )
                    }

                    // Feeding Instructions
                    item {
                        InfoSection(
                            title = "Feeding Instructions",
                            content = birdDetails?.feedingInstructions ?: "",
                            icon = Icons.Default.Info
                        )
                    }

                    // Temperature Range
                    item {
                        InfoSection(
                            title = "Temperature Range",
                            content = birdDetails?.temperatureRange ?: "",
                            icon = Icons.Default.Thermostat
                        )
                    }

                    // Bird Sound
                    item {
                        BirdSoundSection(
                            soundUrl = birdDetails?.soundUrl,
                            exoPlayer = exoPlayer,
                            isPlaying = isPlaying,
                            onPlayPause = { isPlaying = !isPlaying }
                        )
                    }

                    // Additional Resources
                    item {
                        ResourcesSection(birdDetails?.resources ?: emptyList())
                    }
                }
            }
        }
    }
}

@Composable
private fun ColorPaletteSection(colors: List<ColorPalette>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Color Palette",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            colors.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(android.graphics.Color.parseColor(color.hexCode)))
                )
            }
        }
    }
}

@Composable
private fun InfoSection(
    title: String,
    content: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun BirdSoundSection(
    soundUrl: String?,
    exoPlayer: ExoPlayer,
    isPlaying: Boolean,
    onPlayPause: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Bird Sound",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            if (soundUrl != null) {
                LaunchedEffect(soundUrl) {
                    val mediaItem = MediaItem.fromUri(soundUrl)
                    exoPlayer.setMediaItem(mediaItem)
                    exoPlayer.prepare()
                }

                LaunchedEffect(isPlaying) {
                    exoPlayer.playWhenReady = isPlaying
                }

                AndroidView(
                    factory = { ctx ->
                        PlayerView(ctx).apply {
                            player = exoPlayer
                            useController = false
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                )

                IconButton(
                    onClick = onPlayPause,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Icon(
                        imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                        contentDescription = if (isPlaying) "Pause" else "Play",
                        modifier = Modifier.size(48.dp)
                    )
                }
            } else {
                Text(
                    text = "No sound available",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun ResourcesSection(resources: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Additional Resources",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        resources.forEach { resource ->
            TextButton(
                onClick = { /* TODO: Open resource link */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = resource,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
} 