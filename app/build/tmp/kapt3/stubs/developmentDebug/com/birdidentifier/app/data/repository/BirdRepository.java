package com.birdidentifier.app.data.repository;

import com.birdidentifier.app.BirdIdentifierApp;
import com.birdidentifier.app.data.model.*;
import com.google.gson.Gson;
import kotlinx.coroutines.Dispatchers;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0086@\u00a2\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u0004H\u0082@\u00a2\u0006\u0002\u0010\rJ\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/birdidentifier/app/data/repository/BirdRepository;", "", "()V", "GEMINI_API_URL", "", "XENO_CANTO_API_URL", "client", "Lokhttp3/OkHttpClient;", "gson", "Lcom/google/gson/Gson;", "getBirdDetails", "Lcom/birdidentifier/app/data/model/BirdDetails;", "birdId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBirdSound", "Lcom/birdidentifier/app/data/model/BirdSound;", "identifyBird", "Lcom/birdidentifier/app/data/model/BirdIdentificationResponse;", "imageData", "location", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_developmentDebug"})
public final class BirdRepository {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String GEMINI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String XENO_CANTO_API_URL = "https://xeno-canto.org/api/2/recordings";
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.birdidentifier.app.data.repository.BirdRepository INSTANCE = null;
    
    private BirdRepository() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object identifyBird(@org.jetbrains.annotations.NotNull()
    java.lang.String imageData, @org.jetbrains.annotations.Nullable()
    java.lang.String location, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.birdidentifier.app.data.model.BirdIdentificationResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getBirdDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String birdId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.birdidentifier.app.data.model.BirdDetails> $completion) {
        return null;
    }
    
    private final java.lang.Object getBirdSound(java.lang.String birdId, kotlin.coroutines.Continuation<? super com.birdidentifier.app.data.model.BirdSound> $completion) {
        return null;
    }
}