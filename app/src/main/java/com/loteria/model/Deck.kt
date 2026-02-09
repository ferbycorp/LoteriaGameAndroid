package com.loteria.model

/**
 * Maintains the current deck order and draw history.
 */
data class Deck(
    val cards: List<LoteriaCard>,
    val drawnCards: List<LoteriaCard> = emptyList(),
) {
    fun drawNext(): Deck {
        require(cards.isNotEmpty()) { "No cards left to draw." }
        val next = cards.first()
        return copy(
            cards = cards.drop(1),
            drawnCards = drawnCards + next,
        )
    }
}
