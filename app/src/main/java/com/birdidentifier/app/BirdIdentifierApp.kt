package com.birdidentifier.app

import android.app.Application
import android.speech.SpeechRecognizer
import android.content.Context

class BirdIdentifierApp : Application() {
    companion object {
        const val XENO_CANTO_API_KEY = "76ceeb98a78c8758c70e66dd281c123dfe1d1e12"
        const val GEMINI_API_KEY = "AIzaSyAZwsGltX9rq0GpjKh3ExYvOO9BExHhxCg"
        
        lateinit var instance: BirdIdentifierApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
} 