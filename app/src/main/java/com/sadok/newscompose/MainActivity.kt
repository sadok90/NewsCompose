package com.sadok.newscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.sadok.newscompose.presentation.onboarding.component.OnBoardingScreen
import com.sadok.newscompose.ui.theme.NewsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            NewsComposeTheme {
                OnBoardingScreen()
            }
        }
    }
}
