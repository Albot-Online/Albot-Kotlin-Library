package online.albot.connector.model

enum class BoardState {
    WON,
    LOST,
    DRAW,
    ONGOING
}

enum class Action {
    RESTART_GAME,
    MAKE_MOVE,
    SIMULATE_MOVE,
    SIMULATE_MOVE_DELTA,
    EVALUATE_BOARD,
    GET_POSSIBLE_MOVIES
}

