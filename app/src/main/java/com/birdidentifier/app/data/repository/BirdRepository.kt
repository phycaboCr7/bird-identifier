package com.birdidentifier.app.data.repository

import com.birdidentifier.app.BirdIdentifierApp
import com.birdidentifier.app.data.model.*
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.util.concurrent.TimeUnit

object BirdRepository {
    private const val GEMINI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent"
    private const val XENO_CANTO_API_URL = "https://xeno-canto.org/api/2/recordings"
    
    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val gson = Gson()

    suspend fun identifyBird(imageData: String, location: String? = null): BirdIdentificationResponse {
        return withContext(Dispatchers.IO) {
            val requestBody = gson.toJson(
                mapOf(
                    "contents" to listOf(
                        mapOf(
                            "parts" to listOf(
                                mapOf(
                                    "text" to "Identify this bird from the image. " +
                                            "Return the response in JSON format with fields: " +
                                            "birdId (string), confidence (float), alternatives (list of {birdId, confidence}). " +
                                            "Image data: $imageData" +
                                            if (location != null) " Location: $location" else ""
                                )
                            )
                        )
                    )
                )
            ).toRequestBody("application/json".toMediaType())

            val request = Request.Builder()
                .url("$GEMINI_API_URL?key=${BirdIdentifierApp.GEMINI_API_KEY}")
                .post(requestBody)
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected response ${response.code}")
                
                val responseBody = response.body?.string()
                    ?: throw IOException("Empty response body")
                
                // Parse Gemini's response and convert to our model
                // Note: In a real app, you'd want to properly parse the Gemini response
                // This is a simplified example
                BirdIdentificationResponse(
                    birdId = "sample_bird_id",
                    confidence = 0.95f,
                    alternatives = listOf(
                        BirdAlternative("alt_bird_1", 0.85f),
                        BirdAlternative("alt_bird_2", 0.75f)
                    )
                )
            }
        }
    }

    suspend fun getBirdDetails(birdId: String): BirdDetails {
        return withContext(Dispatchers.IO) {
            // In a real app, you'd want to:
            // 1. Get basic bird info from your database
            // 2. Get sounds from Xeno-canto
            // 3. Get additional info from Gemini
            // This is a simplified example
            BirdDetails(
                id = birdId,
                name = "Sample Bird",
                scientificName = "Sampleus Birdus",
                imageUrl = "https://example.com/bird.jpg",
                colors = listOf(
                    ColorPalette("Blue", "#2196F3"),
                    ColorPalette("White", "#FFFFFF"),
                    ColorPalette("Black", "#000000")
                ),
                habitat = "Found in forests and woodlands across North America",
                diet = "Omnivorous, feeding on seeds, insects, and small fruits",
                feedingInstructions = "Can be attracted to feeders with sunflower seeds and suet",
                temperatureRange = "Survives in temperatures between -10°C to 35°C",
                soundUrl = getBirdSound(birdId)?.url,
                resources = listOf(
                    "https://www.allaboutbirds.org/guide/Sample_Bird",
                    "https://www.audubon.org/field-guide/bird/sample-bird"
                )
            )
        }
    }

    private suspend fun getBirdSound(birdId: String): BirdSound? {
        return withContext(Dispatchers.IO) {
            val request = Request.Builder()
                .url("$XENO_CANTO_API_URL?query=$birdId&api_key=${BirdIdentifierApp.XENO_CANTO_API_KEY}")
                .get()
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) return@withContext null
                
                val responseBody = response.body?.string() ?: return@withContext null
                
                // Parse Xeno-canto's response and get the first recording
                // Note: In a real app, you'd want to properly parse the Xeno-canto response
                // This is a simplified example
                BirdSound(
                    id = "12345",
                    url = "https://xeno-canto.org/12345/download",
                    type = "song",
                    quality = "A",
                    duration = 30,
                    background = "clean"
                )
            }
        }
    }
} 