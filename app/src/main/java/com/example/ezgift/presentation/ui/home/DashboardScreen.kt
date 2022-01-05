package com.example.ezgift.presentation.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.ezgift.presentation.ui.theme.EzGiftTheme

@Composable
fun DashBoard(cards: List<Int>) {
    LazyColumn {
        items(cards) {
            Item()
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