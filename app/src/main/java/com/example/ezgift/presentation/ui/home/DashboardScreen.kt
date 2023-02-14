package com.example.ezgift.presentation.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ezgift.presentation.ui.theme.EzGiftTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun DashBoard(cards: List<Int>) {

    val swipeRefreshState = rememberSwipeRefreshState(false)

    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = { /* todo */ },
        indicator = { state, trigger ->
            SwipeRefreshIndicator(
                // Pass the SwipeRefreshState + trigger through
                state = state,
                refreshTriggerDistance = trigger,
                // Enable the scale animation
                scale = true,
                // Change the color and shape
                backgroundColor = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.small,
            )
        }
    ) {
        LazyColumn(modifier = Modifier.padding(bottom = 60.dp)) {
            items(cards) {
                Item()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashBoardPreview() {
    EzGiftTheme {
        DashBoard(listOf())
    }
}