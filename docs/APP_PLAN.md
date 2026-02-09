# Lotería Android App Plan

## Product Goals
- Multiplayer lobby support for up to 20 players.
- Invite flows via a short lobby code and a shareable link.
- Customizable card images with defaults included.

## Architecture Outline

### Lobby + Multiplayer
- **Lobby creation**: Host generates a lobby code (`LobbyCode`) and invite link (`InviteLink`).
- **Join flow**: Players join by entering the code or opening the link, which deep-links into the app.
- **Player limit**: Enforce a 20-player cap at the session level.

### Game Flow
- **Deck**: Server randomizes the deck order and streams draws.
- **State sync**: Use a backend (Firebase or a custom WebSocket service) to broadcast deck draws and player readiness.
- **Match lifecycle**: LOBBY → IN_PROGRESS → COMPLETE.

### Custom Images
- **Default catalog**: Shipped drawables provide initial art.
- **User overrides**: Store image URIs in local storage so players can upload their own artwork.
- **Sharing**: Optionally sync custom decks to all players by uploading assets to cloud storage.

## Implementation Checklist

1. ✅ Define models and lobby utilities (this repo).
2. 🔜 Build UI screens: Home, Lobby, Deck View, Winner confirmation.
3. 🔜 Implement backend sync for players + deck draws.
4. 🔜 Add storage for custom cards and allow importing images.
5. 🔜 Add full Lotería deck and audio callouts.
