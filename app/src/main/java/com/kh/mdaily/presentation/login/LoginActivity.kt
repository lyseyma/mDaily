package com.kh.mdaily.presentation.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kh.mdaily.data.repository.LoginRepository
import com.kh.mdaily.ui.theme.MDailyTheme

class LoginActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MDailyTheme {
                AppNavigation()
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MDailyTheme {
            AppNavigation()
        }
    }

    @Composable
    fun AppNavigation() {
        val authRepository = LoginRepository()
        val loginViewModel = LoginViewModel(authRepository)

//        LoginScreen(viewModel = loginViewModel)
    }
}