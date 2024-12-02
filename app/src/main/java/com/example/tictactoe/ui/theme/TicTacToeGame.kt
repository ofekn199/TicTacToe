package com.example.tictactoe.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoe.logic.checkWinner
import com.example.tictactoe.logic.isBoardFull

@Composable
fun TicTacToeGame() {
    var board by remember { mutableStateOf(Array(3) { Array(3) { "" } }) }
    var currentPlayer by remember { mutableStateOf("X") }
    var winner by remember { mutableStateOf<String?>(null) }
    var gameOver by remember { mutableStateOf(false) }

    fun resetGame() {
        board = Array(3) { Array(3) { "" } }
        currentPlayer = "X"
        winner = null
        gameOver = false
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (gameOver) {
            Text(
                text = winner?.let { "$it Wins!" } ?: "It's a Draw!",
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { resetGame() }) {
                Text("Play Again")
            }
        } else {
            Text(
                text = "Player $currentPlayer's Turn",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Board(board = board, onCellClick = { row, col ->
                if (board[row][col].isEmpty() && !gameOver) {
                    board[row][col] = currentPlayer
                    if (checkWinner(board, currentPlayer)) {
                        winner = currentPlayer
                        gameOver = true
                    } else if (isBoardFull(board)) {
                        gameOver = true
                    } else {
                        currentPlayer = if (currentPlayer == "X") "O" else "X"
                    }
                }
            })
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { resetGame() }) {
                Text("Reset Game")
            }
        }
    }
}