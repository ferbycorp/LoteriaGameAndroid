package com.loteria.repository

import com.loteria.model.LoteriaCard

/**
 * Stores and retrieves custom image overrides for cards.
 *
 * In production, this would be backed by Room or DataStore.
 */
class CustomizationRepository {
    private val overrides = mutableMapOf<String, String>()

    fun setCustomAsset(cardId: String, assetUri: String) {
        overrides[cardId] = assetUri
    }

    fun clearCustomAsset(cardId: String) {
        overrides.remove(cardId)
    }

    fun applyOverrides(cards: List<LoteriaCard>): List<LoteriaCard> =
        cards.map { card ->
            val overrideUri = overrides[card.id]
            if (overrideUri != null) {
                card.copy(customAssetUri = overrideUri)
            } else {
                card
            }
        }
}
