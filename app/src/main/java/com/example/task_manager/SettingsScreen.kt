package com.example.task_manager

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(modifier: Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text("Page des paramètres", style = MaterialTheme.typography.labelLarge)
        Text("Ici, vous pouvez ajouter des paramètres.", modifier = Modifier.padding(top = 8.dp))
    }
}
