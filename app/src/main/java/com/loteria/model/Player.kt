package com.loteria.model

import java.time.Instant

const val MAX_PLAYERS = 20

/**
 * Represents a player in a lobby or active match.
 */
data class Player(
    val id: String,
    val displayName: String,
    val joinedAt: Instant = Instant.now(),
    val isHost: Boolean = false,
    val isReady: Boolean = false,
) {
    fun withReadyState(ready: Boolean): Player = copy(isReady = ready)
}
