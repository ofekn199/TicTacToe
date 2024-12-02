package com.example.tictactoe.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text

@Composable
fun Board(board: Array<Array<String>>, onCellClick: (Int, Int) -> Unit) {
    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (row in board.indices) {
            Row(horizontalArrangement = Arrangement.Center) {
                for (col in board[row].indices) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(4.dp)
                            .background(Color.LightGray)
                            .clickable { onCellClick(row, col) },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = board[row][col],
                            fontSize = 32.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}
