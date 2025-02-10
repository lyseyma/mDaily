package com.kh.mdaily.presentation.taskList

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kh.mdaily.R
import com.kh.mdaily.presentation.task.Task
import com.kh.mdaily.presentation.task.TaskViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskList(
    navController: NavHostController,
    viewModel: TaskViewModel
) {

    val tasks by viewModel.tasks.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchTasks()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    /* Intent to Add new task */
                },
                containerColor= colorResource(id = R.color.colorPrimary),
                shape = RoundedCornerShape(50.dp)
            ) {
                Icon(Icons.Filled.AddCircle, contentDescription = "Add Task", tint = Color.White)
            }

        },
        topBar = {
            TopAppBar(
                title = { Text("Welcome M Daily", color = colorResource(id = R.color.colorPrimary)) },
                actions = {
                    IconButton(onClick = {/* Settings */  }) {
                        Icon(Icons.Filled.Settings, contentDescription = "Settings", tint = Color.Gray)
                    }
                },
                modifier = Modifier.background(color = Color.Gray)
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "LIST OF TODO",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.colorPrimary),
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Scrollable content

            if (isLoading){
                LazyColumn {
                    items(5) {
                        ShimmerLoadingList()
                    }
                }
            }else{

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {

                    items(tasks) { task ->
                        TaskCard(navController,task)
                    }
                }
            }
        }
    }
}
