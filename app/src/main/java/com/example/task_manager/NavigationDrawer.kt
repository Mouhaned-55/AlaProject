package com.example.task_manager

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(onLogout: () -> Unit) {
    var selectedScreen by remember { mutableStateOf("Home") }
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val screens = listOf("Home", "Settings")

    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                screens.forEach { screen ->
                    TextButton(
                        onClick = {
                            selectedScreen = screen
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(screen)
                    }
                }
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                TextButton(
                    onClick = {
                        onLogout()
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Déconnexion")
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Task Manager") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch {
                            drawerState.open()
                        }}) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            when (selectedScreen) {
                "Home" -> HomeScreen(Modifier.padding(innerPadding).fillMaxSize())
                "Settings" -> SettingsScreen(Modifier.padding(innerPadding).fillMaxSize())
            }
        }
    }
}
