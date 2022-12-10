package com.example.rocketgiant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.rocketgiant.ui.app.RocketScreensApp
import com.example.rocketgiant.ui.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RocketScreensApp {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}