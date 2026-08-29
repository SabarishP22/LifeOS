package com.lifeos

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import com.lifeos.designsystem.LifeOSTheme
import com.lifeos.navigation.AppShell

@Composable
@Preview
fun App() {
    LifeOSTheme {
        AppShell()
    }
}