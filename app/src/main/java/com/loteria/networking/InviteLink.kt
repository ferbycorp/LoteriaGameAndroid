package com.loteria.networking

import com.loteria.model.LobbyCode

object InviteLink {
    private const val INVITE_HOST = "https://loteria.app"

    fun buildInviteUrl(lobbyCode: String): String =
        "$INVITE_HOST/join/${LobbyCode.normalize(lobbyCode)}"
}
