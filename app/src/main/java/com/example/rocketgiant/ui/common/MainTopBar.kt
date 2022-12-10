package com.example.rocketgiant.ui.common

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainTopBar(
    showBackButton: Boolean = false,
    barTitle: String? = null,
    onBackClick: (() -> Unit)? = null
) {
    if (showBackButton && onBackClick != null) {
        TopAppBar(
            title = { Text(text = barTitle?.takeIf { it.isNotEmpty() } ?: "") },
            navigationIcon = { ArrowBackIcon(onBackClick = onBackClick) }
        )
    } else {
        TopAppBar(title = {
            Text(text = barTitle?.takeIf { it.isNotEmpty() } ?: "")
        })
    }
}

@Preview(showBackground = true)
@Composable
fun PrevWithIconMainTopBar() {
    MainTopBar(
        showBackButton = true,
        barTitle = "Title with back button",
        onBackClick = {
            //Empty on purpose
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PrevWithNoIconMainTopBar() {
    MainTopBar(
        showBackButton = false,
        barTitle = "Title with no back button"
    )
}