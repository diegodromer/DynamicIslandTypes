package com.diegooliveira.dynamicislandtypes.island

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.diegooliveira.dynamicislandtypes.ui.theme.Green
import com.diegooliveira.dynamicislandtypes.ui.theme.Orange
import com.diegooliveira.dynamicislandtypes.ui.theme.White
import kotlin.random.Random

@Composable
fun CallWaveform() {
    Box(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
    ) {
        Waveform(color = Green)
        Waveform(color = Orange)
        Waveform(color = White, limit = .7f)
    }
}

@Composable
fun Waveform(
    color: Color,
    limit: Float = 1f
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        for (i in 0..4) {
            val heigth = remember { Animatable(0f) }

            LaunchedEffect(Unit) {
                while(true) {
                    heigth.animateTo(
                        Random.nextFloat() * limit,
                        animationSpec = spring(stiffness = Spring.StiffnessMediumLow)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .background(
                        color = color,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .fillMaxHeight(heigth.value)
                    .weight(1f)
            )
            Box(modifier = Modifier.width(2.dp))
        }
    }
}