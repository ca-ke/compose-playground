package dev.caiqueminhare

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

object TodoActivityScreen {
    @Composable
    fun Init(todoViewModel: TodoViewModel) {
        val items: List<TodoItem> by todoViewModel.todoItems.observeAsState(listOf())

        UI(
            todos = items,
            onAddItem = todoViewModel::addItem,
            onRemoveItem = todoViewModel::removeItem
        )
    }

    @Composable
    fun UI(
        todos: List<TodoItem>,
        onAddItem: (TodoItem) -> Unit,
        onRemoveItem: (TodoItem) -> Unit
    ) {
        LazyColumn {
            items(todos.size) { index: Int ->
                TodoRow(todoItem = todos[index], onItemClicked = onAddItem, modifier = Modifier)
            }
        }
    }

    @Composable
    fun TodoRow(todoItem: TodoItem, onItemClicked: (TodoItem) -> Unit, modifier: Modifier) {
        Row(
            modifier = modifier
                .clickable { onItemClicked(todoItem) }
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = todoItem.name,
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_android_black_24dp),
                contentDescription = null,
                modifier = Modifier
                    .height(20.dp)
                    .padding(horizontal = 4.dp)
            )
        }
    }
}