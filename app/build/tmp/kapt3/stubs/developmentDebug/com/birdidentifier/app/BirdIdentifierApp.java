package com.birdidentifier.app;

import android.app.Application;
import android.speech.SpeechRecognizer;
import android.content.Context;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/birdidentifier/app/BirdIdentifierApp;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_developmentDebug"})
public final class BirdIdentifierApp extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String XENO_CANTO_API_KEY = "76ceeb98a78c8758c70e66dd281c123dfe1d1e12";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GEMINI_API_KEY = "AIzaSyAZwsGltX9rq0GpjKh3ExYvOO9BExHhxCg";
    private static com.birdidentifier.app.BirdIdentifierApp instance;
    @org.jetbrains.annotations.NotNull()
    public static final com.birdidentifier.app.BirdIdentifierApp.Companion Companion = null;
    
    public BirdIdentifierApp() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/birdidentifier/app/BirdIdentifierApp$Companion;", "", "()V", "GEMINI_API_KEY", "", "XENO_CANTO_API_KEY", "<set-?>", "Lcom/birdidentifier/app/BirdIdentifierApp;", "instance", "getInstance", "()Lcom/birdidentifier/app/BirdIdentifierApp;", "app_developmentDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.birdidentifier.app.BirdIdentifierApp getInstance() {
            return null;
        }
    }
}