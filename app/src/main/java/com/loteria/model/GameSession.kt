package com.loteria.model

import java.time.Instant

/**
 * Holds lobby and match state for a single Lotería session.
 */
data class GameSession(
    val id: String,
    val lobbyCode: String,
    val hostId: String,
    val players: List<Player> = emptyList(),
    val createdAt: Instant = Instant.now(),
    val status: SessionStatus = SessionStatus.LOBBY,
) {
    val remainingSeats: Int = (MAX_PLAYERS - players.size).coerceAtLeast(0)

    fun canJoin(): Boolean = status == SessionStatus.LOBBY && players.size < MAX_PLAYERS

    fun addPlayer(player: Player): GameSession {
        require(canJoin()) { "Lobby is full or no longer accepting players." }
        return copy(players = players + player)
    }

    fun removePlayer(playerId: String): GameSession =
        copy(players = players.filterNot { it.id == playerId })

    fun updatePlayer(updated: Player): GameSession =
        copy(players = players.map { if (it.id == updated.id) updated else it })
}

enum class SessionStatus {
    LOBBY,
    IN_PROGRESS,
    COMPLETE,
}
