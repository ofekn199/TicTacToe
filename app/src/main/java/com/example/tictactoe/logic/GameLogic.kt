package com.example.tictactoe.logic

fun checkWinner(board: Array<Array<String>>, player: String): Boolean {
    
    for (i in 0..2) {
        if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
            (board[0][i] == player && board[1][i] == player && board[2][i] == player)
        ) return true
    }
    // Check diagonals
    return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)
}

fun isBoardFull(board: Array<Array<String>>): Boolean {
    return board.all { row -> row.all { it.isNotEmpty() } }
}
