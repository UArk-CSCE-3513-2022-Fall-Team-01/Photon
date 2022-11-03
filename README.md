# Photon

CSCE-3513 Fall 2022 Team 01's project repo

## Building from Source

### Requirements

- JDK 17
- Latest Maven

### Building

To build from source, do the following steps in order

1. Clone the repo from <https://github.com/UArk-CSCE-3513-2022-Fall-Team-01/Photon>
2. Change directory to cloned repo
3. In command line, type mvn package (from Photon directory)
This will create a photon-\<version\>-jar-with-dependencies.jar file under the Photon/target folder which can be run.

## Using the app

### Requirements

- JRE 17

### Playing

To "play" the game, do the following

1. Run photon-\<version\>-jar-with-dependencies.jar
2. Wait 3 seconds for the splash screen to fade
3. Type a number for the ID (if it is already in use, a name will pop up once pressing tab)
4. Press tab
5. If the ID is not in use, type a codename to be assigned to the ID
6. Press tab again to go to the next player slot
