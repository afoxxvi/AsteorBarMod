# Version History

## v1.4.6

2024/07/04

This will be the last version that includes Minecraft 1.18.2, 1.19.4 and 1.20.2.

### Features

- Support Minecraft 1.21.
- Compatibility with Origins on Fabric 1.19.2 & 1.20.1.

### Adjustments & Fixes

- Fixed rendering issue with Oculus Shader.

## v1.4.5

2024/05/26

### Features

- Support Minecraft 1.20.6.
- Option to force render all bars at corner.
- Option to toggle bar shake effect.
- Option to disable health bar for armor stands.
- Display bar of TerraFirmaCraft.
- Display mana bar of Ars Nouveau.
- Display mana bar of Botania.

### Adjustments & Fixes

- Fixed bar bound width not calculated correctly.

## v1.4.4

2024/05/10 (not released)

### Features

- Health and food bar will shake in low health or hunger.
- Automatically hide unchanged bars.
- Option to display food level text.

## v1.4.3

2024/04/14

### Adjustments & Fixes

- Add support for NeoForge server.

## v1.4.2

2024/04/13

### Features

- Display thirst info of Homeostatic.

## v1.4.1.1

2024/04/03

### Features

- Added compatibility with Light Shield and Superior Shields in Forge 1.20.1.

## v1.4.1

2024/03/26

### Features

- Preview health&hunger&saturation increment while AppleSkin is loaded.
- Display stamina bar of Parcool.
- Display feather bar of Feather.
- Display mana bar of Iron's Spells 'n Spellbooks
- Display blood bar of Vampirism.
- Display shield bar of Superior Shields.
- Allow to set a global alpha value for entity bars.
- Now display mount health with food level together.

### Adjustments & Fixes

- Fixed the issue in spectator mode in Fabric.
- Fixed entity rendering issue.
- Fixed entity bar not using the lightmap.

## v1.4

2024/03/16

### Features

- Colorful health bar.
- The max value of armor and food level now configurable.
- Display shield info in hud and entity bar of Light Shield(NeoForge 1.20.4).

### Adjustments & Fixes

- Experience value now displays correctly.

## v1.3

2024/02/22

### Features

- Fabric and NeoForge support.
- Color of HUD bars customizable.
- Display thirst info of Tough As Nails.
- Display thirst info of Thirst Was Taken.
- Display thirst info of Dehydration.
- Display MekaSuit's energy level of Mekanism.
- In-game configuration through ModMenu.

### Adjustments & Fixes

- Armor bar now has same length with other bars.
- Display numerical value of armor level and armor toughness.
- Fabric configuration should be working correctly now.

## v1.2.2

2024/02/14

### Adjustments & Fixes

- Adjusted overlay display sequence.
- Added more methods to display absorption.

## v1.2.1

2024/02/07

### Adjustments & Fixes

- Changed health bar's render time in forge version, now should be more compatible with mod entities.
- Added a lightmap to display health bar correctly with shader packs.
- Fixed text display in 1.18 and 1.19.

## v1.2

2024/01/11

### Features

- **Display living entity's health and absorption.**
- More configurable options on hud and entity bars.
- More HUD layout options.
- KeyBind to toggle HUD.
- Localization support.

### Adjustments & Fixes

- Add activation packet to assist server-side plugin.
- Adjusted hunger bar's color.

## v1.1

2024/01/08

### Features

- Display armor.
- Display experience value.
- Now configurable.
- Display exhaustion.
- Server-side support.

### Adjustments & Fixes

- Changed low health flash effect to avoid display issues while both in low health and regeneration.
- Low health now set to fixed rate.
- Optimized the numerical display of health.
- Optimized the height increment after displaying the status bar.

## v1.0

### Features

- Display health, hunger, mount health and air level.
- Change the appearance of the bars in different situations.
- Hidden status, like saturation, can be displayed together with hunger.