package com.birdidentifier.app.data.model

data class BirdDetails(
    val id: String,
    val name: String,
    val scientificName: String,
    val imageUrl: String,
    val colors: List<ColorPalette>,
    val habitat: String,
    val diet: String,
    val feedingInstructions: String,
    val temperatureRange: String,
    val soundUrl: String?,
    val resources: List<String>
)

data class ColorPalette(
    val name: String,
    val hexCode: String
)

data class BirdIdentificationRequest(
    val imageData: String, // Base64 encoded image
    val location: String? = null
)

data class BirdIdentificationResponse(
    val birdId: String,
    val confidence: Float,
    val alternatives: List<BirdAlternative>
)

data class BirdAlternative(
    val birdId: String,
    val confidence: Float
)

data class BirdSound(
    val id: String,
    val url: String,
    val type: String,
    val quality: String,
    val duration: Int,
    val background: String
) 