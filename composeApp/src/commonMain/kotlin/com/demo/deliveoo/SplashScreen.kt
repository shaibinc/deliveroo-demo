package com.demo.deliveoo
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import deliveroo.composeapp.generated.resources.Res
import deliveroo.composeapp.generated.resources.deliveroo_logo
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource



@Composable
fun SplashScreen(onSplashFinished: () -> Unit) {
    // Animation state
    val scale = remember { Animatable(0f) }

    // Start scaling animation
    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1.2f,
            animationSpec = tween(durationMillis = 800, easing = FastOutSlowInEasing)
        )
        delay(1500) // Show splash for 1.5 seconds
        onSplashFinished() // Navigate to next screen
    }

    // UI
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(resource = Res.drawable.deliveroo_logo),
                contentDescription = "Deliveroo Logo",
                modifier = Modifier
                    .size(150.dp)
                    .scale(scale.value)
            )
        }
    }
}
