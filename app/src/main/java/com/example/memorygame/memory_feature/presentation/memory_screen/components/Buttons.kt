package com.example.memorygame.memory_feature.presentation.memory_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.memorygame.memory_feature.presentation.memory_screen.MemoryEvent
import com.example.memorygame.memory_feature.presentation.memory_screen.MemoryViewModel

@Composable
fun BuildButtons(
    viewModel : MemoryViewModel,
    modifier: Modifier = Modifier
) {

    val state = viewModel.state.value

    IconButton(
        onClick = { viewModel.onEvent(MemoryEvent.AddPair) },
        icon = Icons.Default.KeyboardArrowUp,
        contentDescription = "Add Pair Button",
        tint = state.currentTheme.iconColor,
        modifier = modifier)

    IconButton(
        onClick = { viewModel.onEvent(MemoryEvent.ReducePair) },
        icon = Icons.Default.KeyboardArrowDown,
        contentDescription = "Reduce Pair Button",
        tint = state.currentTheme.iconColor,
        modifier = modifier)



    IconButton(
        onClick = { viewModel.onEvent(MemoryEvent.ResetGame) },
        icon = Icons.Default.Refresh,
        contentDescription = "Reset game button",
        tint = state.currentTheme.iconColor,
        modifier = modifier)


    Box(
        modifier = modifier) {
        Button(
            onClick = { viewModel.onEvent(MemoryEvent.ChangeTheme) },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                Color.Transparent
            )) {

            Image(
                painter = painterResource(
                    id = state.currentTheme.getImageResourceForNumber(1)!!),
                contentDescription = "Switch Theme",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit)
            
            
        }
    }

}


@Composable
fun IconButton (
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: ImageVector,
    contentDescription: String,
    tint: Color
) {
    Box(
        modifier = modifier
    ) {
        Button(
            onClick = onClick,
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                Color.Transparent
            )
        ){

            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = tint,
                modifier = Modifier.size(80.dp))

        }
    }
}