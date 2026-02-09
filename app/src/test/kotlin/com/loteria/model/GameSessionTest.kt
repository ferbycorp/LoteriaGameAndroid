package com.loteria.model

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GameSessionTest {
    @Test
    fun `cannot join when lobby is full`() {
        val players = (1..MAX_PLAYERS).map {
            Player(id = "player-$it", displayName = "Player $it")
        }
        val session = GameSession(
            id = "session-1",
            lobbyCode = "ABC123",
            hostId = "player-1",
            players = players,
        )

        assertFalse(session.canJoin())
        assertFailsWith<IllegalArgumentException> {
            session.addPlayer(Player(id = "player-21", displayName = "Late Joiner"))
        }
    }

    @Test
    fun `prevents duplicate player ids`() {
        val host = Player(id = "player-1", displayName = "Host", isHost = true)
        val session = GameSession(
            id = "session-1",
            lobbyCode = "ABC123",
            hostId = host.id,
            players = listOf(host),
        )

        assertFailsWith<IllegalArgumentException> {
            session.addPlayer(host)
        }
    }

    @Test
    fun `allows joining when space is available`() {
        val host = Player(id = "player-1", displayName = "Host", isHost = true)
        val session = GameSession(
            id = "session-1",
            lobbyCode = "ABC123",
            hostId = host.id,
            players = listOf(host),
        )

        val updated = session.addPlayer(Player(id = "player-2", displayName = "Guest"))

        assertTrue(updated.canJoin())
        assertTrue(updated.players.any { it.id == "player-2" })
    }
}
