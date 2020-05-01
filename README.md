# Mod
This Mod is based off of the [Forge default project](https://mcforge.readthedocs.io/en/latest/gettingstarted/).

## Environment Setup
- Install Minecraft.
- Download JRE and JDK, Install both. You need 64bit!
  - https://www.oracle.com/java/technologies/javase/javase9-archive-downloads.html
- Make sure the JDK path is showing up in your JAVA_HOME variable.
- Make sure to reference %JAVA_HOME% in your PATH variable.
- Download and install Gradle. (Probably install it to C:\Program Files\Gradle, rather than C:\Gradle)
  - https://gradle.org/install/
- Install IntelliJ IDEA (Community Edition)
  - https://www.jetbrains.com/idea/
  - Choose the dark theme. Default options should be fine beyond that.
- Install Git if you haven't.
- Clone this repo.
- Open a bash console in the root of this repo and execute `./gradlew.bat runClient`

## Building & Testing

## Building for Distribution
- Update the mod version in src/main/resources/META-INF/mods.toml
- Update the mod version in build.gradle.