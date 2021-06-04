package dev.caiqueminhare

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    private var _todoItems = MutableLiveData(listOf<TodoItem>())
    val todoItems: LiveData<List<TodoItem>> = _todoItems

    init {
        _todoItems.value = listOf(
            TodoItem("Aprender compose"),
            TodoItem("Aprender compose 1"),
            TodoItem("Aprender compose 2"),
            TodoItem("Aprender compose 3")
        )
    }

    fun addItem(item: TodoItem) {

    }

    fun removeItem(item: TodoItem) {

    }
}