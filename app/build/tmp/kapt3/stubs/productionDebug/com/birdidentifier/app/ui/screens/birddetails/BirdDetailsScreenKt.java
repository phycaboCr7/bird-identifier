package com.birdidentifier.app.ui.screens.birddetails;

import androidx.compose.animation.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.font.FontWeight;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import com.birdidentifier.app.BirdIdentifierApp;
import com.birdidentifier.app.data.model.BirdDetails;
import com.birdidentifier.app.data.model.ColorPalette;
import com.birdidentifier.app.data.repository.BirdRepository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a0\u0010\u0006\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a\u0016\u0010\r\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0003\u001a \u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0003\u001a\u0016\u0010\u0016\u001a\u00020\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0003\u00a8\u0006\u0018"}, d2 = {"BirdDetailsScreen", "", "birdId", "", "onNavigateBack", "Lkotlin/Function0;", "BirdSoundSection", "soundUrl", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "isPlaying", "", "onPlayPause", "ColorPaletteSection", "colors", "", "Lcom/birdidentifier/app/data/model/ColorPalette;", "InfoSection", "title", "content", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ResourcesSection", "resources", "app_productionDebug"})
public final class BirdDetailsScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void BirdDetailsScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String birdId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateBack) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ColorPaletteSection(java.util.List<com.birdidentifier.app.data.model.ColorPalette> colors) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void InfoSection(java.lang.String title, java.lang.String content, androidx.compose.ui.graphics.vector.ImageVector icon) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void BirdSoundSection(java.lang.String soundUrl, androidx.media3.exoplayer.ExoPlayer exoPlayer, boolean isPlaying, kotlin.jvm.functions.Function0<kotlin.Unit> onPlayPause) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ResourcesSection(java.util.List<java.lang.String> resources) {
    }
}