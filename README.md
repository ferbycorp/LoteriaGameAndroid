# Lotería Game Android (Prototype)

This repository provides a starting point for a Mexican Lotería multiplayer Android app. The goal is to support up to **20 players**, joining via a **lobby code or invite link**, while allowing card artwork to be customized.

## What's Included

- Kotlin models for players, lobby sessions, deck progression, and card assets.
- Lobby code generation plus invite link utilities.
- A simple customization repository to swap card artwork.
- Starter drawable assets that can be replaced with your own art.

## Next Steps

1. Wire the models into your Android UI (Jetpack Compose or XML).
2. Replace the stubbed storage in `CustomizationRepository` with Room/DataStore.
3. Add real-time multiplayer sync (Firebase Realtime Database, Firestore, or WebSocket backend).
4. Expand the card catalog to the full Lotería deck.

See `docs/APP_PLAN.md` for a development roadmap.
