package com.kh.mdaily.presentation.task

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kh.mdaily.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    private val _isLoading =  MutableStateFlow(false)
    var isLoading: StateFlow<Boolean> = _isLoading

    fun createTask(task: Task) {
        repository.createTask(task) { success ->
            if (success) fetchTasks()
        }
    }

    fun fetchTasks() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            repository.fetchTasks { taskList , success  ->

                Log.d("TAG", "fetchTasks:$taskList ")
                _tasks.value = taskList
                _isLoading.value = false
                Log.d("TAG", "Loading:$success ")
            }
        }



    }

    fun updateTask(task: Task) {
        repository.updateTask(task) { success ->
            if (success) fetchTasks()
        }
    }

    fun deleteTask(taskId: String) {
        repository.deleteTask(taskId) { success ->
            if (success) fetchTasks()
        }
    }
}

