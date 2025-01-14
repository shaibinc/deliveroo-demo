package com.demo.deliveoo

import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview

import moe.tlaster.precompose.PreComposeApp

@Composable
@Preview
fun App() {
    PreComposeApp {
        AppNavigation()
    }
}