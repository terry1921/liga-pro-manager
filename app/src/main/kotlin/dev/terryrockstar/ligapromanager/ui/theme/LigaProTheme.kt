package dev.terryrockstar.ligapromanager.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF0B70C0),
    secondary = Color(0xFF161B24),
    tertiary = Color(0xFF112228),
    tertiaryContainer = Color(0xFF12262B),
    background = Color(0xFF10131E),
    surface = Color(0xFF11141D),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color(0xFFB00020),
    onError = Color.White,
    outline = Color(0xFF868690),
    outlineVariant = Color(0xFF4C9784),
    scrim = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF0B70C0),            // mismo azul, resalta bien en light
    secondary = Color(0xFFE2E6F1),          // fondo suave gris-azulado claro
    tertiary = Color(0xFFE8F1F4),           // azul muy claro para áreas alternativas
    tertiaryContainer = Color(0xFFD9EEF3),  // más claro para contenedores
    background = Color(0xFFF9FAFC),         // casi blanco con toque azulado
    surface = Color(0xFFF0F2F5),            // similar a background, para elevación
    onPrimary = Color.White,
    onSecondary = Color(0xFF10131E),        // texto oscuro sobre fondos claros
    onBackground = Color(0xFF10131E),
    onSurface = Color(0xFF10131E),
    error = Color(0xFFB00020),
    onError = Color.White,
    outline = Color(0xFF707070),            // gris medio para bordes
    outlineVariant = Color(0xFF2A6E61),     // verde azulado suave para énfasis
    scrim = Color.Black
)


@Composable
fun LigaProTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme //if (useDarkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
