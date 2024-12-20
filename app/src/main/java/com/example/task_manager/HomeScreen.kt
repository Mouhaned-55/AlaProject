package com.example.task_manager

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier) {
    var tasks by remember { mutableStateOf(listOf("Étudier le cours Java", "Étudier le cours Android")) }
    var newTask by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        Text("Mes Tâches", style = MaterialTheme.typography.labelLarge)

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(tasks) { task ->
                Text(task, modifier = Modifier.padding(8.dp))
            }
        }

        OutlinedTextField(
            value = newTask,
            onValueChange = { newTask = it },
            label = { Text("Nouvelle tâche") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (newTask.isNotBlank()) {
                    tasks = tasks + newTask
                    newTask = ""
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Ajouter une tâche")
        }
    }
}
