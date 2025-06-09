package com.birdidentifier.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF2196F3),          // Vibrant Blue
    onPrimary = Color.White,
    primaryContainer = Color(0xFFBBDEFB),  // Light Blue
    onPrimaryContainer = Color(0xFF1976D2),
    secondary = Color(0xFF4CAF50),        // Vibrant Green
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFC8E6C9), // Light Green
    onSecondaryContainer = Color(0xFF388E3C),
    tertiary = Color(0xFFFFC107),         // Amber
    onTertiary = Color.Black,
    tertiaryContainer = Color(0xFFFFECB3), // Light Amber
    onTertiaryContainer = Color(0xFFFFA000),
    background = Color(0xFFF5F5F5),       // Light Gray
    onBackground = Color(0xFF212121),
    surface = Color.White,
    onSurface = Color(0xFF212121),
    surfaceVariant = Color(0xFFE0E0E0),   // Light Gray
    onSurfaceVariant = Color(0xFF757575),
    error = Color(0xFFE53935),            // Red
    onError = Color.White,
    errorContainer = Color(0xFFFFCDD2),   // Light Red
    onErrorContainer = Color(0xFFC62828)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF90CAF9),          // Light Blue
    onPrimary = Color.Black,
    primaryContainer = Color(0xFF1976D2),  // Dark Blue
    onPrimaryContainer = Color.White,
    secondary = Color(0xFF81C784),        // Light Green
    onSecondary = Color.Black,
    secondaryContainer = Color(0xFF388E3C), // Dark Green
    onSecondaryContainer = Color.White,
    tertiary = Color(0xFFFFD54F),         // Light Amber
    onTertiary = Color.Black,
    tertiaryContainer = Color(0xFFFFA000), // Dark Amber
    onTertiaryContainer = Color.White,
    background = Color(0xFF121212),       // Dark Gray
    onBackground = Color.White,
    surface = Color(0xFF1E1E1E),          // Dark Surface
    onSurface = Color.White,
    surfaceVariant = Color(0xFF424242),   // Dark Gray
    onSurfaceVariant = Color(0xFFBDBDBD),
    error = Color(0xFFEF5350),            // Light Red
    onError = Color.Black,
    errorContainer = Color(0xFFC62828),   // Dark Red
    onErrorContainer = Color.White
)

@Composable
fun BirdIdentifierTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
} 