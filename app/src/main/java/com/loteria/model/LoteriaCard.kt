package com.loteria.model

/**
 * Represents a Lotería card with customizable artwork.
 */
data class LoteriaCard(
    val id: String,
    val name: String,
    val defaultAsset: CardAsset,
    val customAssetUri: String? = null,
) {
    fun effectiveAssetUri(): String = customAssetUri ?: defaultAsset.assetUri
}

data class CardAsset(
    val assetUri: String,
    val attribution: String,
)
