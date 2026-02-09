package com.loteria.model

import java.security.SecureRandom

private const val CODE_LENGTH = 6
private const val CODE_ALPHABET = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789"

object LobbyCode {
    private val random = SecureRandom()

    fun generate(): String = buildString {
        repeat(CODE_LENGTH) {
            val index = random.nextInt(CODE_ALPHABET.length)
            append(CODE_ALPHABET[index])
        }
    }

    fun normalize(raw: String): String = raw.trim().uppercase()
}
