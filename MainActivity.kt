package com.mpconnection.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mpconnection.app.ui.theme.MPconnectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MPconnectionTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ConnectionScreen()
                }
            }
        }
    }
}

@Composable
fun ConnectionScreen() {
    var status by remember { mutableStateOf("Disconnected") }
    var ping by remember { mutableStateOf("-- ms") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "MPconnection", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            status = "Connecting..."
            // simulate connect logic
            status = "Connected"
            ping = "42 ms"
        }) {
            Text("Connect")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            status = "Disconnected"
            ping = "-- ms"
        }) {
            Text("Disconnect")
        }

        Spacer(modifier = Modifier.height(32.dp))
        Text("Status: $status")
        Text("Ping: $ping")
    }
}
