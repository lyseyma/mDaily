package com.kh.mdaily.presentation

import android.content.Intent
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
        composable(
            route = "login_screen",
            enterTransition = {
                slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(300))
            }
        ) { LoginScreen(navController, viewModel = loginViewModel, "login_screen", intent) }

        composable(
            route = "signup_screen",
            enterTransition = {
                slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(300))
            }
        ) { LoginScreen(navController, viewModel = loginViewModel, "signup_screen", intent) }

        composable(
            route = "forgot_screen",
            enterTransition = {
                slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(300))
            }
        ) { LoginScreen(navController, viewModel = loginViewModel, "forgot_screen", intent) }

        composable(
            route = "taskList_screen",
            enterTransition = {
                slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(300))
            }
        ) { TaskList(navController, viewModel = taskViewModel) }

        composable(
            route = "detail_screen",
            enterTransition = {
                slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(300))
            }
        ) { DetailToDoScreen(navController) }
    }
}