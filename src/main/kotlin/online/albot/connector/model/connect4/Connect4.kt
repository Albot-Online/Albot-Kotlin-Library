package online.albot.connector.model.connect4

import online.albot.connector.model.Action
import online.albot.connector.model.BoardState

enum class Player {
    ONE,
    TWO
}

data class PossibleMoves(
        val action: Action = Action.GET_POSSIBLE_MOVIES,
        val board: Board
)

data class EvaluateBoard(
        val action: Action = Action.EVALUATE_BOARD,
        val move: Int,
        val player: Player,
        val board: Board
)

data class SimulateMove(
        val action: Action = Action.SIMULATE_MOVE
)

data class PpossibleMoveResponse(
        val possMoves: List<Int>
)


data class EvaluateBoardResponse(
        val boardState: BoardState
)

data class SimulateResponse(
        val board: Board
)

data class StateResponse(
        val board: Board,
        val boardState: BoardState
)


data class Board(
        val board: List<List<Int>>
)