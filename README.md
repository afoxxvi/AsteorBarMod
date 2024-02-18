# AsteorBar

A simple mod to display player's status using slim bars and display entity's status using bars.

## Features

### HUD Overlay

- Vanilla feel. Bars can blink as vanilla hearts do(on regen health, on hurt, and so on).
- Display health, hunger, mount health and more.
- Change the color of the bars while be with regeneration, poison, wither or starvation effects. Frozen also supported.
- Won't be affected by max health. Suitable for situations with high max health.
- Display health and absorption together.
- Display saturation and exhaustion together with hunger.
- Display experience value.
- Bars will flash when the player has low health or hunger.
- Configurable. You can change whether to display some bars.

### Entity info

- Display living entity's health and max health.
- Display absorption of living entity.
- Very simple with good look.
- Dynamic color of health bar. The color will change when the entity's health is low.
- Highly configurable. You can change whether to display bars in many situations. And you can change many properties of the bars(e.g. color,
  scale, offset...).

## Notes

Only Chinese and English localization are guaranteed to be correct. If you want to help with the localization, you can create a pull
request.
Thanks a lot!

The following features will not take effect on servers because they are not synced in vanilla Minecraft

- Saturation and exhaustion
- Absorption of living entities

This [plugin](https://github.com/afoxxvi/AsteorBarServer) for Spigot/Paper server can sync saturation and exhaustion to client.

## Supported Minecraft versions and mod loaders

| Version | Forge  | Fabric | NeoForge |
|---------|--------|--------|----------|
| 1.18.2  | latest | latest |          |
| 1.19.2  | latest | latest |          |
| 1.19.3  | latest | latest |          |
| 1.19.4  | latest | latest |          |
| 1.20    | latest | latest |          |
| 1.20.1  | latest | latest |          |
| 1.20.2  | latest | latest |          |
| 1.20.4  | latest | latest |          |

## Compatibility

| Version | Tough As Nails | Thirst Was Taken |
|---------|:--------------:|------------------|
| 1.18.2  |                |                  |
| 1.19.2  |                |                  |
| 1.19.4  |                |                  |
| 1.20    |                |                  |
| 1.20.1  |                |                  |
| 1.20.2  |     forge      |                  |
| 1.20.4  |                |                  |

## Screenshots

Absorption display together with health.
![Absorption](assets/abs.png)
Exhaustion display together with hunger(Similar to AppleSkin).
![Exhaustion](assets/exh.png)
Saturation display together with hunger.
![Saturation](assets/stv.png)
Mount health.
![Mount](assets/mnt.png)
Air level.
![Air](assets/air.png)
Regeneration effect.
![Regeneration](assets/rgn.png)

## Acknowledgements

The mod is inspired by

- [AppleSkin](https://github.com/squeek502/AppleSkin) by squeek502
- [Neat](https://github.com/VazkiiMods/Neat) by VazkiiMods