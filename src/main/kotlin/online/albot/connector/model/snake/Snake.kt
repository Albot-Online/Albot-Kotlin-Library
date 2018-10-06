package online.albot.connector.model.snake

import online.albot.connector.model.Action
import online.albot.connector.model.BoardState

enum class Move {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

data class PossibleMoves(
        val action: Action = Action.GET_POSSIBLE_MOVIES,
        val playerMove: Move,
        val enemyMove: Move
)

data class EvaluateBoard(
        val action: Action = Action.EVALUATE_BOARD,
        val board: Board
)

data class SimulateMove(
        val action: Action = Action.SIMULATE_MOVE,
        val board: Board,
        val playerMove: Move,
        val enemyMove: Move
)

data class SimulateMoveDalta(
        val action: Action = Action.SIMULATE_MOVE_DELTA,
        val player: Position,
        val playerMove: Move,
        val enemy: Position,
        val enemyMove: Move
)

data class PossibleMovesResponse(
        val playerMoves: List<Move>,
        val enemy: List<Move>
)

data class EvaluateBoardResponse(
        val boardState: BoardState
)

data class SimulateMoveResponse(
        val board: Board
)

data class Board(
        val player: Position,
        val enemy: Position,
        val blocked: Position,
        val boardState: BoardState?
)

data class Position(
        val dir: Move?,
        val x: Int,
        val y: Int
)