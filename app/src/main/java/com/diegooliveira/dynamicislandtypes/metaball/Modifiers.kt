package com.diegooliveira.dynamicislandtypes.metaball

import android.graphics.RenderEffect
import android.graphics.Shader
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer

fun Modifier.custom(blur: Float) = this.then(
    graphicsLayer {
        renderEffect = RenderEffect
            .createBlurEffect(
                blur,
                blur,
                Shader.TileMode.DECAL,
            )
            .asComposeRenderEffect()
    }
)