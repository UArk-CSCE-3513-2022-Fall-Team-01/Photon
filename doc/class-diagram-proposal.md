# Class Diagram

Below is a mermaid-js generated UML class diagram overview of the project in a proposed future state.

```mermaid
classDiagram-v2
    direction LR
    BaseController o--* BaseView
    BaseController *--o Model
    Game --* BaseView
    Model o--* BaseView
    Game --* Model
    PlayerDatabase --o Model
    Model o-- Player
    Team o-- Player
    Team --o Model
    Player --> Team
    BaseView <|-- EntryView
    BaseView <|-- PlayView
    Splash <.. Game
    KeyListener <|-- BaseController
    Game --* BaseController

    <<interface>> KeyListener

    class Splash {
        -t : int
        +show() void
    }

    class Player {
        -id : int
        -codename : String
        -score : int
        -team : Team
        +Player(id : int, codename : String, team : Team)
        +id() int
        +codename() String
        +score() int
        +score(newScore : int) void
        +addToScore(amount : int) void
    }

    class Team {
        -score : int
        -name : String
        -players : HashMap~int, Player~
        +Team(name : String)
        +name() String
        +score() int
        +addToScore(amount : int) void
        +score(score : int) void
        +addPlayer(player : Player) void
        +players() Collection~Player~
    }

    class Model {
        -teams : ArrayList~Team~
        -players : HashMap~int, Player~
        +Model()
        +addTeam(team : Team) boolean
        +addPlayer(player : Player, team : Team) void
        +playerHit(attacker : Player, victim : Player) void
        +startMatch() void
        +readyToStart() boolean
    }

    class BaseView {
        <<abstract>>
        +BaseView(model : Model, controller : Controller)
        +EXAMPLE_update() void
        +TODO()
    }

    class BaseController {
        <<abstract>>
        BaseController(model : Model)
        +TODO()
    }

    class EntryController {
    }
    BaseController <|-- EntryController

    class Game {
        +main(String[] args) void
        -run() void
        -switchToPlay() void
        -switchToEntry() void
    }

    class PlayerDatabase {
        +getCodename(id : int) String
        +addPlayerRecord(id : int, codename : String) boolean
    }

    class EntryView {
        -frameW : int
        -frameH : int
        -playerSelected : int
        -teamSelected : int
        -editingCodename : boolean
        -pixelsBetweenBoxes : int
        -boxHeight : int
        -idWidth : int
        -playerWidth : int
        -redTeamX : int
        -greenTeamX : int
        -startingY : int
        -currentEditText : String
        -acceptableIDchars : String
        -acceptableCodenameChars : String
        -textFont : Font
        +paintComponent(g : Graphics) void
    }
```
