# AsteorBar

[![](https://img.shields.io/curseforge/dt/959237?logo=curseforge&logoColor=%23000000&label=CurseForge&labelColor=%23f16436&color=%23555555)](https://www.curseforge.com/minecraft/mc-mods/asteorbar)
[![](https://img.shields.io/modrinth/dt/QMWG8bVO?logo=modrinth&logoColor=%23000000&label=Modrinth&labelColor=%2300AF5C&color=%23555555)](https://modrinth.com/mod/asteorbar)

A simple mod to display player's status using slim bars and display entity's status using bars.
Get it from badge links above.

See changelog [here](version_history.md).

## Features

### HUD Overlay

- Vanilla feel. Bars can blink as vanilla hearts do(on regen health, on hurt, and so on).
- Display health, hunger, mount health and more.
- Change the color of the bars while be with regeneration, poison, wither or starvation effects. Frozen also supported.
- Won't be affected by max health. Suitable for situations with high max health.
- Display health and absorption together.
- Display saturation and exhaustion together with hunger.
- Display experience value.
- Bars will flash and shake when the player has low health or hunger.
- Use stacked bars to display health.
- Multiple layout, vanilla and corner included.
- Hide bars when the value has not changed for a while.
- Configurable. You can change whether to display some bars.

### Entity info

- Display living entity's health and max health.
- Display absorption of living entity.
- Very simple with good look.
- Dynamic color of health bar. The color will change when the entity's health is low.
- Highly configurable. You can change whether to display bars in many situations. And you can change many properties of
  the bars(e.g. color,
  scale, offset...).

### Compatibility

Depends on the latest version when the corresponding AsteorBar version was released.
May not work with newer versions, if they changed their implementation.

#### Forge

| Mod                         | 1.18.2 | 1.19.2 | 1.19.4 | 1.20.1 | 1.20.2 | 1.20.4 | 1.20.6 | 1.21.1 | 1.21.3 | 1.21.4 |
|-----------------------------|:------:|:------:|:------:|:------:|:------:|:------:|:------:|:------:|:------:|:------:|
| Mekanism                    |   ✓    |   ✓    |        |   ✓    |        |        |        |        |        |        |
| Tough As Nails              |   ✓    |   ✓    |        |   ✓    |   ✓    |   ✓    |   ✓    |  [ ]   |  [ ]   |        |
| Thirst Was Taken            |   ✓    |   ✓    |        |   ✓    |        |        |        |        |        |        |
| Iron's Spells 'n Spellbooks |   ✓    |   ✓    |        |   ✓    |        |        |        |        |        |        |
| Light Shield                |        |        |        |   ✓    |        |        |        |        |        |        |
| Parcool                     |   ✓    |   ✓    |   ✓    |   ✓    |   ✓    |        |        |        |        |        |
| Feathers                    |   ✓    |   ✓    |   ✓    |   ✓    |        |        |        |        |        |        |
| Apple Skin                  |   ✓    |   ✓    |   ✓    |   ✓    |   ✓    |   ✓    |        |        |        |        |
| Vampirism                   |   ✓    |   ✓    |   ✓    |   ✓    |        |        |        |        |        |        |
| Superior Shields            |   ✓    |   ✓    |        |   ✓    |        |        |        |        |        |        |
| Homeostatic                 |   ✓    |   ✓    |   ✓    |   ✓    |        |        |        |        |        |        |
| TerraFirmaCraft             |   ✓    |        |        |   ✓    |        |        |        |        |        |        |
| Botania                     |   ✓    |   ✓    |        |   ✓    |        |        |        |        |        |        |
| Ars Nouveau                 |   ✓    |   ✓    |        |   ✓    |        |        |        |        |        |        |

#### Fabric

| Mod            | 1.18.2 | 1.19.2 | 1.19.4 | 1.20.1 | 1.20.2 | 1.20.4 | 1.20.6 | 1.21.1 | 1.21.3 | 1.21.4 |
|----------------|:------:|:------:|:------:|:------:|:------:|:------:|:------:|:------:|:------:|:------:|
| Tough As Nails |        |   ✓    |        |   ✓    |   ✓    |   ✓    |   ✓    |  [ ]   |  [ ]   |        |
| Dehydration    |   ✓    |   ✓    |        |   ✓    |        |        |        |        |        |        |
| Apple Skin     |   ✓    |   ✓    |   ✓    |   ✓    |   ✓    |   ✓    |   ✓    |  [ ]   |  [ ]   |        |

#### Neoforge

| Mod              | 1.20.2 | 1.20.4 | 1.20.6 | 1.21.1 | 1.21.3 | 1.21.4 |
|------------------|:------:|:------:|:------:|:------:|:------:|:------:|
| Tough As Nails   |   ✓    |   ✓    |   ✓    |  [ ]   |        |        |
| Thirst Was Taken |        |        |        |  [ ]   |        |        |
| Light Shield     |        |        |   ✓    |        |        |        |
| Apple Skin       |   ✓    |   ✓    |   ✓    |  [ ]   |        |        |
| Vampirism        |        |        |   ✓    |        |        |        |

## Notes

### Data Sync

The following features will not take effect on servers because they are not synced in vanilla Minecraft

- Saturation and exhaustion
- Absorption of living entities

This [plugin](https://www.spigotmc.org/resources/asteorbar.114684/) for Spigot/Paper server can sync saturation and
exhaustion to client.

### Compatibility

Due to the limitation of the API, this mod couldn't automatically turn off some third party's mod.
For a better experience, you will need to turn off their HUD manually.
Usually you can achieve this by setting the `enable` option in their config file to `false`.
For those mods that don't provide such an option, you may find `offset` or `location` options in their config file.
By setting these values to a large number(above 1000 is enough in most cases), you can move their HUD out of the screen,
which is equivalent
to turning them off.

### Known Incompatibility

Here are some known incompatibility with other mods, and currently there is no solution for them.

- Oculus: while using shaders, living entity's health bar may not display correctly.

## Q&A

**How to change the layout of HUD?**</br>
Press F8 by default, the HUD style will be cycled, include vanilla layout.

**How to disable HUD or Entity Bar, I do only need one of the features?**</br>
HUD can be closed by pressing F8, Entity Bar can be close by pressing F10, you can also disable these features in the
config file.

**How to configure the mod in game?**</br>
For Fabric version, you'll need to install Mod Menu. For Other version, you can use any in-game configuration editor,
such as configured.

**The bars are too close and the text is stacking on each other.**</br>
You can change the text scale in config, 1.0 should be well with force Unicode, and I recommend 0.75 if you are using
vanilla font.

**How to change color in config, I don't understand what these numbers mean.**</br>
Colors are in ARGB hex format, but displayed as dec values. You can use Windows calculator, switch to programmer mode,
click the 'QWORD' until it becomes 'DWORD', then click on HEX and input your ARGB color. The DEC value is just what you
needed.

## Supported Minecraft versions and mod loaders

Earlier versions is not planned to be supported.

| Version | Forge       | Fabric      |  NeoForge   |
|---------|-------------|-------------|:-----------:|
| 1.18.2  | v1.4.6      | v1.4.6      |             |
| 1.19.2  | v1.4.6      | v1.4.6      |             |
| 1.19.3  | v1.4.1      | v1.4.1      |             |
| 1.19.4  | v1.4.6      | v1.4.6      |             |
| 1.20    | v1.2.2      | v1.2        |             |
| 1.20.1  | latest      | latest      |             |
| 1.20.2  | v1.4.6      | v1.4.6      |   v1.4.6    |
| 1.20.3  | v1.2.2      | v1.2        |             |
| 1.20.4  | latest      | latest      |   latest    |
| 1.20.6  | latest      | latest      |   latest    |
| 1.21    | v1.4.6      | v1.4.6      |   v1.4.6    |
| 1.21.1  | latest      | latest      |   latest    |
| 1.21.3  | in progress | in progress | in progress |
| 1.21.4  | in progress | in progress | in progress |

## Acknowledgements

The mod is inspired by

- [AppleSkin](https://github.com/squeek502/AppleSkin) by squeek502
- [Neat](https://github.com/VazkiiMods/Neat) by VazkiiMods
