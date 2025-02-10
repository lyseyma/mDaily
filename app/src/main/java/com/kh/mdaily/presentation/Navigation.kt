package com.kh.mdaily.presentation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kh.mdaily.data.repository.LoginRepository
import com.kh.mdaily.data.repository.TaskRepository
import com.kh.mdaily.presentation.detailTodo.DetailToDoScreen
import com.kh.mdaily.presentation.login.LoginScreen
import com.kh.mdaily.presentation.login.LoginViewModel
import com.kh.mdaily.presentation.task.TaskViewModel
import com.kh.mdaily.presentation.taskList.TaskList

@Composable
fun Navigation(intent: Intent) {
    val navController = rememberNavController()
    val authRepository = LoginRepository()
    val taskRepository = TaskRepository()
    val loginViewModel = LoginViewModel(authRepository)
    val taskViewModel = TaskViewModel(taskRepository)
    NavHost(
        navController = navController,
        startDestination = "taskList_screen"
    ) {
        composable("login_screen") { LoginScreen(navController,viewModel = loginViewModel, "login_screen" ,intent ) }
        composable("signup_screen") { LoginScreen(navController,viewModel = loginViewModel, "signup_screen" ,intent) }
        composable("forgot_screen") { LoginScreen(navController,viewModel = loginViewModel, "forgot_screen" , intent) }
        composable("taskList_screen") {  TaskList(navController,viewModel = taskViewModel) }
        composable("detail_screen") {  DetailToDoScreen(navController) }

    }
}