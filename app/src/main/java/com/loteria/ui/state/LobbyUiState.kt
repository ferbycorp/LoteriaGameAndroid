package com.loteria.ui.state

import com.loteria.model.GameSession
import com.loteria.model.Player
import com.loteria.networking.InviteLink

/**
 * UI-ready state for lobby screens.
 */
data class LobbyUiState(
    val session: GameSession,
) {
    val lobbyCode: String = session.lobbyCode
    val inviteUrl: String = InviteLink.buildInviteUrl(session.lobbyCode)
    val players: List<Player> = session.players
    val remainingSeats: Int = session.remainingSeats
}
