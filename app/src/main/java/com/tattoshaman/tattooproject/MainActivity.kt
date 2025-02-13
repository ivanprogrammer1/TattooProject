package com.tattoshaman.tattooproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tattoshaman.core.ui.theme.TattooProjectTheme
import com.tattoshaman.tattooproject.main.navigation.MainNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TattooProjectTheme {
                MainNavHost()
            }
        }
    }

}