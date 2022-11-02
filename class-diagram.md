# Class Diagram

Below is a mermaid-js generated UML class diagram overview of the project.

```mermaid
classDiagram-v2
    Game "1" o-- "*" Player
    Game "1" *-- "1" EntryGraphics
    Game "1" o-- "1" HerokuPostgreDatabase
    Game ..> Splash
    Game --|> JFrame
    EntryGraphics --|> JPanel
    EntryGraphics ..|> KeyListener
    Player <|.. BaiscPlayer
    PlayerDatabase <|.. HerokuPostgreDatabase

    <<interface>> KeyListener

    class Game {
        +entryScreen: EntryGraphics
        +redTeam: Player[]
        +greenTeam: Player[]
        +herokuDB: HerokuPostgreDatabase
        +Game()
        +run(): void
        +main(String[] args): void
    }

    class Player {
        <<interface>>
        +id(): int
        +codename(): String
        +score(): int
        +score(newScore: int): void
        +addToScore(amount: int): void
    }

    class PlayerDatabase {
        +getCodename(id: int): String
        +addPlayerRecord(id: int, codename: String): boolean
    }

    class Splash {
        -t: int
        +Splash(time: int)
        +show(): void
    }

    class EntryGraphics {
        +redTeamIDs: int[]
        +greenTeamIDs: int[]
        +redTeamNames: String[]
        +greenTeamNames: String[]
        -frameW: int
        -frameH: int
        -playerSelected: int
        -teamSelected: int
        -editingCodename: boolean
        -pixelsBetweenBoxes: int
        -boxHeight: int
        -idWidth: int
        -playerWidth: int
        -redTeamX: int
        -greenTeamX: int
        -startingY: int
        -currentEditText: String
        -acceptableIDchars: String
        -acceptableCodenameChars: String
        -textFont: Font
        +EntryGraphics(game: Game, width: int, height: int)
        +paintComponent(g: Graphics): void
    }
```
