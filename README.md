# FPS Boost Mod 1.21.1

A hidden Fabric mod for Minecraft 1.21.1 that provides utility features.

## Features

- **Hidden Mod**: Does not appear in Mod Menu (no_display enabled)
- **Ground Click Handler**: Automatically places an obsidian block followed by an end crystal when you click on the ground
- **/fpsboost Command**: A silent command that executes without chat feedback

## Installation

1. Install [Fabric Loader](https://fabricmc.net/)
2. Download the latest mod JAR from releases
3. Place it in your `mods` folder
4. Launch Minecraft with the Fabric profile

## Building

```bash
./gradlew build
```

The built JAR will be in `build/libs/`

## Development

Requirements:
- Java 21 or higher
- Gradle 8.0+

```bash
./gradlew genSources
./gradlew idea
```

## Usage

- Click on any block in the world to place obsidian + end crystal
- Use `/fpsboost` command in chat
