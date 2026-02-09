package com.loteria.repository

import com.loteria.model.CardAsset
import com.loteria.model.LoteriaCard

object DefaultCardCatalog {
    val cards: List<LoteriaCard> = listOf(
        LoteriaCard(
            id = "el-sol",
            name = "El Sol",
            defaultAsset = CardAsset(
                assetUri = "android.resource://com.loteria/drawable/card_el_sol",
                attribution = "Starter art generated for this prototype.",
            ),
        ),
        LoteriaCard(
            id = "la-luna",
            name = "La Luna",
            defaultAsset = CardAsset(
                assetUri = "android.resource://com.loteria/drawable/card_la_luna",
                attribution = "Starter art generated for this prototype.",
            ),
        ),
        LoteriaCard(
            id = "el-gallo",
            name = "El Gallo",
            defaultAsset = CardAsset(
                assetUri = "android.resource://com.loteria/drawable/card_el_gallo",
                attribution = "Starter art generated for this prototype.",
            ),
        ),
        LoteriaCard(
            id = "la-rosa",
            name = "La Rosa",
            defaultAsset = CardAsset(
                assetUri = "android.resource://com.loteria/drawable/card_la_rosa",
                attribution = "Starter art generated for this prototype.",
            ),
        ),
    )
}
