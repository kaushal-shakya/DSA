# Q1. How Well Does the Design Show the Entities?

**Evaluator's Score:** **8.0/10**

## Evaluator's Feedback

### Evaluator 1

## Strengths

### 1. Well-defined Domain Models

Your design demonstrates a solid understanding of the core entities required for a chess game.

You have correctly identified and modeled the following entities:

* `Game`
* `Player`
* `ChessBoard`
* `Cell`
* `King`
* `Queen`
* `Rook`
* `Bishop`
* `Knight`
* `Pawn`

This reflects good domain analysis and object-oriented modeling.

---

### 2. Appropriate Use of Enums

The use of the following enums is excellent:

* `GameStatus`
* `PieceType`
* `Color`

These enums improve:

* Type safety
* Readability
* Maintainability

For example, `GameStatus` clearly represents all possible game states:

* `STARTED`
* `ONGOING`
* `CHECK`
* `STALEMATE`
* `CHECKMATE`

---

### 3. Core Relationships Captured

Your design correctly models several important relationships:

* `Game` contains `Player` objects.
* `Game` contains a `ChessBoard`.
* `ChessBoard` contains `Cell` objects.
* Each `Cell` can contain a `Piece`.

These relationships accurately reflect the real-world chess domain.

---

# Areas for Improvement

## 1. Missing Move Entity

There is no representation of a **Move** (or **Turn**) in the current design.

In chess, a move is a first-class concept because it is needed for:

* Move history
* Undo/Redo
* Replay
* Move validation
* PGN (Portable Game Notation)

Without a dedicated `Move` entity, these features become difficult to implement.

---

## 2. Missing Move Validation Logic

There is no class responsible for validating moves according to chess rules.

A dedicated component should verify:

* Piece movement rules
* Path obstruction
* Check and checkmate conditions
* Special moves such as castling and en passant

Separating this logic greatly improves maintainability.

---

## 3. Incomplete Player–Piece Relationship

Although `Player` maintains a list of pieces, the relationship is incomplete.

It is not clear:

* How a piece knows its owner.
* How color is associated with a piece.
* How ownership is maintained after captures.

Making these relationships explicit would improve the overall design.

---

## 4. Missing Current Turn Tracking

The `Game` class does not indicate whose turn it currently is.

Since chess is a turn-based game, the design should explicitly track:

* Current player
* Turn switching
* Turn validation

This is essential for correct game flow.

---

# Actionable Suggestions

## 1. Introduce a `Move` Entity

```java
class Move {

    private Player player;

    private Cell fromCell;
    private Cell toCell;

    private Piece movedPiece;
    private Piece capturedPiece;

    private long timestamp;

    private boolean isCastling;
    private boolean isEnPassant;

    public Move(Player player,
                Cell from,
                Cell to,
                Piece piece) {

        this.player = player;
        this.fromCell = from;
        this.toCell = to;
        this.movedPiece = piece;
        this.timestamp = System.currentTimeMillis();
    }

    public Player getPlayer() {
        return player;
    }

    public Cell getFromCell() {
        return fromCell;
    }

    public Cell getToCell() {
        return toCell;
    }
}
```

### Why this is better

A dedicated `Move` entity enables:

* Complete move history
* Undo/Redo functionality
* Move validation
* PGN generation
* Game replay

Since moves are central to chess, modeling them explicitly leads to a more complete domain model.

---

## 2. Create a `MoveValidator` (Rule Engine)

```java
class MoveValidator {

    private ChessBoard board;

    public MoveValidator(ChessBoard board) {
        this.board = board;
    }

    public boolean isValidMove(Move move) {

        // Validate movement rules

        // Check if path is clear

        // Ensure own king is not left in check

        return true;
    }

    public boolean isKingInCheck(Color kingColor) {

        return false;
    }

    public boolean isCheckmate(Color kingColor) {

        return false;
    }
}
```

### Why this is better

Separating validation logic into its own class follows the **Single Responsibility Principle (SRP)**.

Benefits include:

* Easier testing
* Better maintainability
* Reusable validation logic
* Cleaner `Game` class

Chess rules are complex enough to justify a dedicated rule engine.

---

## 3. Update the `Game` Class to Track Turns

```java
class Game {

    private List<Player> players;

    private ChessBoard board;

    private List<Piece> removedPieces;

    private List<Move> moveHistory;

    private GameStatus status;

    private Player currentPlayer;

    private MoveValidator validator;

    public Game() {

        players = new ArrayList<>(2);

        removedPieces = new ArrayList<>();

        moveHistory = new ArrayList<>();

        board = new ChessBoard(8);

        validator = new MoveValidator(board);

        status = GameStatus.STARTED;

        currentPlayer = players.get(0); // White moves first
    }

    public boolean makeMove(Move move) {

        if (!move.getPlayer().equals(currentPlayer)) {
            return false;
        }

        if (validator.isValidMove(move)) {

            moveHistory.add(move);

            switchPlayer();

            updateGameStatus();

            return true;
        }

        return false;
    }

    private void switchPlayer() {

        currentPlayer =
                currentPlayer.equals(players.get(0))
                        ? players.get(1)
                        : players.get(0);
    }

    private void updateGameStatus() {

        // Check for check

        // Checkmate

        // Stalemate
    }
}
```

### Why this is better

Tracking the current player provides a complete representation of game flow.

This design also:

* Maintains move history.
* Coordinates gameplay.
* Delegates validation to `MoveValidator`.
* Updates game state after every move.

The `Game` class now acts as the central coordinator while other classes handle specialized responsibilities.

---

# Overall Feedback

Your design demonstrates a strong understanding of the primary entities required for a chess game. The domain model is comprehensive, and the use of enums and object relationships reflects good object-oriented design practices.

The design can be further strengthened by introducing:

* A dedicated `Move` entity.
* A `MoveValidator` (or rule engine).
* Explicit turn tracking.
* Clearer ownership relationships between players and pieces.

These enhancements will make the design more complete, extensible, and better aligned with real-world chess game requirements.

# Q2. How Easy Would It Be to Add Future Scope Requirements?

**Evaluator's Score:** **7.0/10**

## Evaluator's Feedback

### Evaluator 1

## Strengths

### 1. Factory Pattern Implementation

Your `PieceFactory` is an excellent design choice for extensibility.

If new chess pieces are introduced (for example, in chess variants such as Fairy Chess with pieces like **Archbishop** or **Chancellor**), the factory can be extended with minimal changes.

This demonstrates good foresight and adherence to the **Open/Closed Principle (OCP)**.

---

### 2. Abstract `Piece` Class

The abstract `Piece` class defines the `possibleMoves()` method, providing a strong foundation for polymorphism.

Each chess piece is responsible for implementing its own movement logic.

Benefits include:

* Easy addition of new piece types.
* Piece-specific movement behavior.
* Minimal impact on existing classes.

---

### 3. Enum-Based Status Management

Using the `GameStatus` enum makes the design flexible.

Future game states can easily be introduced, such as:

* `PAUSED`
* `RESIGNED`
* `DRAW_OFFERED`
* `DRAW_ACCEPTED`
* `TIMEOUT`

without changing the existing design significantly.

---

# Areas for Improvement

## 1. Hard-coded Board Initialization

The `ChessBoard` constructor currently initializes the standard 8×8 chess board directly.

This makes it difficult to support future requirements such as:

* Chess960 (Fischer Random Chess)
* Capablanca Chess (10×10)
* Chess puzzles
* Loading saved games
* Custom starting positions (FEN)

The board creation logic should be separated from the board itself.

---

## 2. No Strategy Pattern for Move Validation

Movement validation is embedded within each piece's `possibleMoves()` implementation.

This makes it difficult to introduce additional rules such as:

* Threefold repetition
* Fifty-move rule
* Variant-specific movement rules
* Tournament-specific restrictions

A dedicated strategy for move validation would improve flexibility.

---

## 3. Tightly Coupled Game Logic

The `Game` class appears to coordinate many different responsibilities.

Adding future features such as:

* AI opponents
* Online multiplayer
* Saving and loading games
* Time controls
* Tournament support

would require significant modifications to the `Game` class.

---

## 4. Missing Observer Mechanism

There is currently no mechanism to notify external systems about game events.

As a result, implementing features like:

* GUI updates
* Move logging
* Spectator mode
* Analytics
* Game replay

would require tightly coupling these features to the `Game` class.

---

## 5. Missing Builder Pattern

There is no flexible way to configure a chess game.

Future configuration options such as:

* Time controls
* Board variants
* Custom rules
* Event listeners

would require modifying constructors or core classes.

---

# Actionable Suggestions

## 1. Introduce a Strategy Pattern for Board Initialization

```java
interface BoardInitializer {

    void initializeBoard(ChessBoard board);
}

class StandardChessInitializer
        implements BoardInitializer {

    @Override
    public void initializeBoard(ChessBoard board) {

        placeStandardPieces(board);
    }

    private void placeStandardPieces(
            ChessBoard board) {

        // Standard chess setup
    }
}

class Chess960Initializer
        implements BoardInitializer {

    @Override
    public void initializeBoard(ChessBoard board) {

        placeRandomizedPieces(board);
    }

    private void placeRandomizedPieces(
            ChessBoard board) {

        // Fischer Random setup
    }
}

class CustomPositionInitializer
        implements BoardInitializer {

    private String fenString;

    public CustomPositionInitializer(String fenString) {
        this.fenString = fenString;
    }

    @Override
    public void initializeBoard(
            ChessBoard board) {

        // Parse FEN and initialize board
    }
}

class ChessBoard {

    private List<List<Cell>> cells;

    public ChessBoard(int size,
                      BoardInitializer initializer) {

        createBoard(size);

        initializer.initializeBoard(this);
    }

    private void createBoard(int size) {

        cells = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            cells.add(new ArrayList<>(size));
        }
    }
}
```

### Why this is better

Separating board initialization from the `ChessBoard` allows multiple board configurations without modifying the board implementation.

This makes supporting:

* Chess960
* Puzzle mode
* Custom positions
* Saved games

extremely straightforward.

It also follows the **Open/Closed Principle**.

---

## 2. Implement the Observer Pattern

```java
interface GameEventListener {

    void onMoveMade(Move move);

    void onPieceCaptured(Piece piece);

    void onGameStatusChanged(
            GameStatus oldStatus,
            GameStatus newStatus);

    void onCheck(Color kingColor);

    void onCheckmate(Color kingColor);
}

class Game {

    private List<Player> players;

    private ChessBoard board;

    private List<Piece> removed;

    private GameStatus status;

    private List<GameEventListener> listeners;

    public Game() {

        players = new ArrayList<>(2);

        removed = new ArrayList<>();

        status = GameStatus.STARTED;

        board = new ChessBoard(
                8,
                new StandardChessInitializer());

        listeners = new ArrayList<>();
    }

    public void addListener(
            GameEventListener listener) {

        listeners.add(listener);
    }

    public void removeListener(
            GameEventListener listener) {

        listeners.remove(listener);
    }

    private void notifyMoveMade(Move move) {

        for (GameEventListener listener : listeners) {
            listener.onMoveMade(move);
        }
    }

    private void notifyGameStatusChanged(
            GameStatus oldStatus,
            GameStatus newStatus) {

        for (GameEventListener listener : listeners) {

            listener.onGameStatusChanged(
                    oldStatus,
                    newStatus);
        }
    }

    public boolean makeMove(Move move) {

        // Execute move

        notifyMoveMade(move);

        return true;
    }
}
```

Example listeners:

```java
class UIUpdateListener
        implements GameEventListener {

    @Override
    public void onMoveMade(Move move) {

        // Refresh UI
    }

    @Override
    public void onPieceCaptured(Piece piece) {

        // Capture animation
    }

    @Override
    public void onGameStatusChanged(
            GameStatus oldStatus,
            GameStatus newStatus) {

        // Update status display
    }

    @Override
    public void onCheck(Color kingColor) {

        // Highlight king
    }

    @Override
    public void onCheckmate(Color kingColor) {

        // Game over
    }
}

class GameLogger
        implements GameEventListener {

    @Override
    public void onMoveMade(Move move) {

        System.out.println("Move: " + move);
    }

    // Other logging methods...
}
```

### Why this is better

The **Observer Pattern** decouples game logic from external systems.

New functionality such as:

* GUI updates
* Logging
* Replay systems
* Online spectators
* Analytics

can be added simply by creating another listener, without modifying the `Game` class.

---

## 3. Use the Builder Pattern for Game Configuration

```java
class GameConfig {

    private int boardSize;

    private BoardInitializer boardInitializer;

    private boolean timedGame;

    private int timeLimit;

    private List<GameEventListener> listeners;

    private GameConfig(Builder builder) {

        this.boardSize = builder.boardSize;
        this.boardInitializer =
                builder.boardInitializer;

        this.timedGame = builder.timedGame;
        this.timeLimit = builder.timeLimit;

        this.listeners = builder.listeners;
    }

    public static class Builder {

        private int boardSize = 8;

        private BoardInitializer boardInitializer =
                new StandardChessInitializer();

        private boolean timedGame = false;

        private int timeLimit = 0;

        private List<GameEventListener> listeners =
                new ArrayList<>();

        public Builder withBoardSize(int size) {

            boardSize = size;
            return this;
        }

        public Builder withInitializer(
                BoardInitializer initializer) {

            boardInitializer = initializer;
            return this;
        }

        public Builder withTimeControl(int seconds) {

            timedGame = true;
            timeLimit = seconds;

            return this;
        }

        public Builder addListener(
                GameEventListener listener) {

            listeners.add(listener);

            return this;
        }

        public GameConfig build() {

            return new GameConfig(this);
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public BoardInitializer getBoardInitializer() {
        return boardInitializer;
    }

    public boolean isTimedGame() {
        return timedGame;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public List<GameEventListener> getListeners() {
        return listeners;
    }
}

class Game {

    private GameConfig config;

    private ChessBoard board;

    private List<GameEventListener> listeners;

    public Game(GameConfig config) {

        this.config = config;

        board = new ChessBoard(
                config.getBoardSize(),
                config.getBoardInitializer());

        listeners =
                new ArrayList<>(config.getListeners());
    }
}
```

Example usage:

```java
GameConfig config =
        new GameConfig.Builder()
                .withBoardSize(8)
                .withInitializer(
                        new Chess960Initializer())
                .withTimeControl(600)
                .addListener(
                        new UIUpdateListener())
                .addListener(
                        new GameLogger())
                .build();

Game game = new Game(config);
```

### Why this is better

The **Builder Pattern** makes the game highly configurable.

Future options can be added without changing constructor signatures, including:

* Tournament mode
* Time controls
* Custom board variants
* AI difficulty
* Rule sets
* Spectator support

This significantly improves maintainability and extensibility.

---

# Overall Feedback

Your design already provides a solid foundation for future enhancements through the use of:

* Factory Pattern
* Abstract `Piece` hierarchy
* Enum-based state management

However, extensibility can be greatly improved by introducing:

* **Strategy Pattern** for board initialization.
* **Observer Pattern** for game events.
* **Builder Pattern** for game configuration.

These changes reduce coupling, improve maintainability, and make it significantly easier to support new chess variants and advanced gameplay features without modifying existing classes.


# Q3. How Well Do the Designs Follow SOLID Principles?

**Evaluator's Score:** **6.0/10**

## Evaluator's Feedback

### Evaluator 1

---

# Strengths

## 1. Open/Closed Principle (Partial)

Your use of the abstract `Piece` class is good.

The `possibleMoves()` method allows new piece types to be added without modifying existing code. Each concrete piece (`King`, `Queen`, etc.) extends the base class and provides its own implementation.

---

## 2. Liskov Substitution Principle

Your piece hierarchy correctly follows the **Liskov Substitution Principle (LSP)**.

Any `Piece` reference can be replaced with any specific piece type (`King`, `Queen`, etc.) without breaking functionality, since all implement the required `possibleMoves()` method.

---

## 3. Dependency Inversion Principle (Partial)

The use of the `Piece` abstract class shows some understanding of the **Dependency Inversion Principle (DIP)**.

Higher-level code can depend on the abstraction rather than concrete implementations.

---

# Areas for Improvement

## 1. Single Responsibility Principle (SRP) Violations

### Game Class

The `Game` class appears to have multiple responsibilities:

- Managing players
- Managing the board
- Tracking removed pieces
- Managing game status

This makes it harder to test and modify.

### ChessBoard Class

The `ChessBoard` class is responsible for both:

- Storing the board state
- Initializing pieces (methods like `placesAllBlackPieces()`)

These are separate concerns and should be extracted into different classes.

### Piece Class

The `Piece` class stores both:

- The piece's current position (`Cell`)
- The movement logic

Position is really a property of the board state, not of the piece itself.

---

## 2. Open/Closed Principle (OCP) Violations

### PieceFactory

`PieceFactory` uses a `switch` statement.

Whenever a new chess piece is introduced (for chess variants), the factory must be modified.

### Special Chess Rules

There is no abstraction for rules such as:

- Castling
- En passant
- Promotion
- Chess variants

Supporting these features would require modifying existing classes.

---

## 3. Interface Segregation Principle (ISP)

No interfaces are defined.

As a result:

- Clients depend on concrete implementations.
- Mocking becomes difficult.
- Swapping implementations is harder.

For example, different board implementations (testing, chess variants, network games) cannot easily be introduced.

---

## 4. Dependency Inversion Principle (DIP) Violations

Examples include:

- `Game` directly creates the board.

```java
new ChessBoard(8);
```

- `Piece` classes directly create `Cell` objects in their constructors.

These dependencies tightly couple high-level modules to concrete implementations.

---

# Actionable Suggestions

## 1. Fix Single Responsibility Principle — Extract Responsibilities

### GameState

```java
// Separate game state management from game flow control
class GameState {

    private GameStatus status;
    private Player currentPlayer;
    private List<Move> moveHistory;

    public GameState(Player initialPlayer) {
        this.status =GameStatus.STARTED;
        this.currentPlayer = initialPlayer;
        this.moveHistory = new ArrayList<>();
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public void addMove(Move move) {
        moveHistory.add(move);
    }

    public List<Move> getMoveHistory() {
        return new ArrayList<>(moveHistory);
    }
}
```

### Game

```java
// Game now orchestrates but delegates specific responsibilities
class Game {

    private List<Player> players;
    private ChessBoard board;
    private GameState gameState;
    private MoveValidator validator;
    private MoveExecutor executor;

    public Game(List<Player> players, ChessBoard board) {
        this.players = players;
        this.board = board;
        this.gameState = new GameState(players.get(0));
        this.validator = new MoveValidator(board);
        this.executor = new MoveExecutor(board);
    }

    public boolean makeMove(Move move) {

        if (!validator.isValidMove(move, gameState)) {
            return false;
        }

        executor.executeMove(move);

        gameState.addMove(move);

        updateTurn();

        return true;
    }

    private void updateTurn() {
        // Switch to next player
    }
}
```

### MoveExecutor

```java
// Separate move execution logic
class MoveExecutor {

    private ChessBoard board;

    public MoveExecutor(ChessBoard board) {
        this.board = board;
    }

    public void executeMove(Move move) {

        Cell fromCell = move.getFromCell();
        Cell toCell = move.getToCell();

        Piece piece = fromCell.getPiece();

        toCell.setPiece(piece);
        fromCell.setPiece(null);
    }

    public void undoMove(Move move) {
        // Logic to undo a move
    }
}
```

### Why this matters

By separating concerns:

- `GameState` manages state.
- `MoveValidator` validates moves.
- `MoveExecutor` executes moves.
- `Game` orchestrates gameplay.

Each class now has one responsibility, making the code easier to test, understand, and maintain.

---

## 2. Fix Open/Closed Principle — Replace Switch with Registration

```java
class PieceFactory {

    private Map<PieceType, Supplier<Piece>> pieceCreators;

    public PieceFactory() {

        pieceCreators = new HashMap<>();

        registerDefaultPieces();
    }

    private void registerDefaultPieces() {

        registerPiece(PieceType.KING, () -> new King());
        registerPiece(PieceType.QUEEN, () -> new Queen());
        registerPiece(PieceType.ROOK, () -> new Rook());
        registerPiece(PieceType.BISHOP, () -> new Bishop());
        registerPiece(PieceType.KNIGHT, () -> new Knight());
        registerPiece(PieceType.PAWN, () -> new Pawn());
    }

    public void registerPiece(
            PieceType type,
            Supplier<Piece> creator) {

        pieceCreators.put(type, creator);
    }

    public Piece getPiece(PieceType pieceType) {

        Supplier<Piece> creator = pieceCreators.get(pieceType);

        if (creator == null) {
            throw new IllegalArgumentException(
                    pieceType + " is not registered");
        }

        return creator.get();
    }
}
```

Usage:

```java
// Add a new piece without modifying PieceFactory
PieceFactory factory = new PieceFactory();

factory.registerPiece(
        PieceType.ARCHBISHOP,
        () -> new Archbishop());
```

### Why this matters

The factory is now:

- Open for extension
- Closed for modification

New pieces can be registered without changing factory code.

---

## 3. Fix Interface Segregation & Dependency Inversion

### Board Interface

```java
interface IBoard {

    Cell getCell(int row, int column);

    void setCellPiece(int row, int column, Piece piece);

    Piece getPieceAt(int row, int column);

    int getSize();

    List<Piece> getAllPieces(Color color);
}
```

### ChessBoard

```java
class ChessBoard implements IBoard {

    private List<List<Cell>> cells;
    private int size;

    public ChessBoard(int size) {
        this.size = size;
        createBoard(size);
    }

    @Override
    public Cell getCell(int row, int column) {

        if (row >= 0 &&
            row < size &&
            column >= 0 &&
            column < size) {

            return cells.get(row).get(column);
        }

        return null;
    }

    @Override
    public void setCellPiece(
            int row,
            int column,
            Piece piece) {

        Cell cell = getCell(row, column);

        if (cell != null) {
            cell.setPiece(piece);
        }
    }

    @Override
    public Piece getPieceAt(
            int row,
            int column) {

        Cell cell = getCell(row, column);

        return cell != null ? cell.getPiece() : null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public List<Piece> getAllPieces(Color color) {

        List<Piece> pieces = new ArrayList<>();

        for (List<Cell> row : cells) {

            for (Cell cell : row) {

                Piece piece = cell.getPiece();

                if (piece != null &&
                    piece.getColor() == color) {

                    pieces.add(piece);
                }
            }
        }

        return pieces;
    }

    private void createBoard(int size) {

        cells = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {

            List<Cell> row = new ArrayList<>(size);

            for (int j = 0; j < size; j++) {
                row.add(new Cell(i, j));
            }

            cells.add(row);
        }
    }
}
```

### MoveValidator

```java
class MoveValidator {

    private IBoard board;

    public MoveValidator(IBoard board) {
        this.board = board;
    }

    public boolean isValidMove(
            Move move,
            GameState state) {

        Piece piece =
                board.getPieceAt(
                        move.getFromCell().getRow(),
                        move.getFromCell().getColumn());

        // Validation logic

        return true;
    }
}
```

### Game

```java
class Game {

    private List<Player> players;
    private IBoard board;
    private GameState gameState;

    public Game(
            List<Player> players,
            IBoard board) {

        this.players = players;
        this.board = board;
        this.gameState =
                new GameState(players.get(0));
    }
}
```

### MockBoard (Testing)

```java
class MockBoard implements IBoard {

    @Override
    public Cell getCell(
            int row,
            int column) {

        return new Cell(row, column);
    }

    @Override
    public void setCellPiece(
            int row,
            int column,
            Piece piece) {}

    @Override
    public Piece getPieceAt(
            int row,
            int column) {

        return null;
    }

    @Override
    public int getSize() {
        return 8;
    }

    @Override
    public List<Piece> getAllPieces(Color color) {
        return new ArrayList<>();
    }
}
```

### Why this matters

Programming against interfaces provides:

- Better testability
- Easier mocking
- Flexible implementations
- Proper Dependency Inversion

---

## 4. Fix Piece–Cell Coupling

```java
abstract class Piece {

    protected Color color;
    protected PieceType type;

    // Remove Cell from Piece.
    // Position is maintained by the board.

    public Piece(Color color) {
        this.color = color;
    }

    public abstract List<Cell> possibleMoves(
            IBoard board,
            Cell currentCell);

    public PieceType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}
```

Example:

```java
class King extends Piece {

    public King(Color color) {

        super(color);

        this.type = PieceType.KING;
    }

    @Override
    public List<Cell> possibleMoves(
            IBoard board,
            Cell currentCell) {

        List<Cell> moves =
                new ArrayList<>();

        int row = currentCell.getRow();
        int col = currentCell.getColumn();

        int[] rowOffsets =
                {-1,-1,-1,0,0,1,1,1};

        int[] colOffsets =
                {-1,0,1,-1,1,-1,0,1};

        for (int i = 0; i < 8; i++) {

            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];

            Cell target =
                    board.getCell(newRow, newCol);

            if (target == null)
                continue;

            Piece targetPiece =
                    board.getPieceAt(newRow, newCol);

            if (targetPiece == null ||
                targetPiece.getColor() != color) {

                moves.add(target);
            }
        }

        return moves;
    }
}
```

### Why this matters

Pieces no longer own their position.

The board becomes the single source of truth for piece locations.

Benefits include:

- Better separation of concerns
- Reduced coupling
- Easier move calculation
- Cleaner object model

# Q4. How Well Is the Design Using Interfaces and Abstract Classes?

**Evaluator's Score:** **6.0/10**

## Evaluator's Feedback

### Evaluator 1

---

# Strengths

## 1. Appropriate Use of Abstract Class for `Piece`

Your use of an abstract `Piece` class is correct and well-suited for this problem.

Since all chess pieces share common attributes:

- `color`
- `type`

and common behavior:

- `possibleMoves()`

but each piece has different movement rules, using an abstract class is the right choice.

The abstract method `possibleMoves()` correctly forces every concrete piece to implement its own movement logic.

---

## 2. Good Use of Enums

Although enums are not interfaces or abstract classes, your use of:

- `GameStatus`
- `PieceType`
- `Color`

shows a good understanding of using specialized types for fixed sets of values.

This improves:

- Type safety
- Readability
- Maintainability

---

## 3. Consistent Inheritance Hierarchy

All six chess pieces:

- `King`
- `Queen`
- `Rook`
- `Bishop`
- `Knight`
- `Pawn`

correctly extend the `Piece` abstract class and implement the required abstract methods.

This demonstrates a solid understanding of inheritance.

---

# Areas for Improvement

## 1. No Interfaces Defined

The design currently contains **no interfaces**.

This leads to several issues:

- Difficult to mock dependencies during testing.
- Tight coupling between classes.
- Limited flexibility for alternative implementations.
- Violates the **Dependency Inversion Principle**, which encourages depending on abstractions rather than concrete classes.

---

## 2. Missing Abstract Methods in `Piece`

The `Piece` abstract class could define additional common behaviors, such as:

- `isValidMove()`
- `getValue()` (piece value)
- `getSymbol()` (Unicode/CLI representation)

These methods naturally belong to every chess piece.

---

## 3. Concrete Class Coupling

Classes like:

- `Game`
- `MoveValidator`
- `MoveExecutor`

work directly with concrete classes instead of abstractions.

This makes the design rigid and harder to extend or test.

---

## 4. Factory Returns Concrete Type

Although `PieceFactory` is useful, it always returns the concrete `Piece` type.

If pieces later support different capabilities (promotion, castling, etc.), returning interfaces could provide greater flexibility.

---

## 5. Missing Capability Interfaces

Certain chess pieces have unique capabilities.

For example:

- Pawn → Promotion
- King → Castling
- Rook → Castling

Currently there are no interfaces representing these behaviors.

This forces client code to rely on type checks instead of polymorphism.

---

# Actionable Suggestions

## 1. Introduce Core Interfaces

```java
// Interface for moveable pieces
interface IMoveable {

    List<Cell> possibleMoves(
            IBoard board,
            Cell currentCell);

    boolean canMoveTo(
            IBoard board,
            Cell from,
            Cell to);
}

// Interface for pieces with point values
interface IValuable {

    int getValue();
}

// Interface for displayable pieces
interface IDisplayable {

    String getSymbol();

    Color getColor();
}
```

---

### Piece

```java
abstract class Piece
        implements IMoveable,
                   IValuable,
                   IDisplayable {

    protected Color color;

    protected PieceType type;

    public Piece(Color color) {

        this.color = color;
    }

    @Override
    public abstract List<Cell> possibleMoves(
            IBoard board,
            Cell currentCell);

    @Override
    public boolean canMoveTo(
            IBoard board,
            Cell from,
            Cell to) {

        return possibleMoves(board, from)
                .contains(to);
    }

    @Override
    public abstract int getValue();

    @Override
    public Color getColor() {

        return color;
    }

    @Override
    public abstract String getSymbol();

    public PieceType getType() {

        return type;
    }
}
```

---

### King

```java
class King extends Piece {

    public King(Color color) {

        super(color);

        this.type = PieceType.KING;
    }

    @Override
    public List<Cell> possibleMoves(
            IBoard board,
            Cell currentCell) {

        return new ArrayList<>();
    }

    @Override
    public int getValue() {

        return Integer.MAX_VALUE;
    }

    @Override
    public String getSymbol() {

        return color == Color.WHITE
                ? "♔"
                : "♚";
    }
}
```

---

### Queen

```java
class Queen extends Piece {

    public Queen(Color color) {

        super(color);

        this.type = PieceType.QUEEN;
    }

    @Override
    public List<Cell> possibleMoves(
            IBoard board,
            Cell currentCell) {

        return new ArrayList<>();
    }

    @Override
    public int getValue() {

        return 9;
    }

    @Override
    public String getSymbol() {

        return color == Color.WHITE
                ? "♕"
                : "♛";
    }
}
```

### Why this matters

By implementing multiple interfaces, different parts of the system depend only on the capabilities they require.

For example:

- UI components only require `IDisplayable`.
- Move validation only depends on `IMoveable`.
- AI evaluation only depends on `IValuable`.

This follows the **Interface Segregation Principle (ISP)** and improves modularity.

---

## 2. Create Interfaces for Special Piece Capabilities

```java
// Pieces that can be promoted
interface IPromotable {

    Piece promoteTo(
            PieceType targetType,
            Color color);

    boolean canBePromoted(
            Cell currentCell);
}

// Pieces involved in castling
interface ICastleable {

    boolean canCastle(
            IBoard board,
            Cell from,
            Cell to);

    boolean hasMoved();
}
```

---

### Pawn

```java
class Pawn extends Piece
        implements IPromotable {

    private boolean hasMoved;

    public Pawn(Color color) {

        super(color);

        this.type = PieceType.PAWN;
    }

    @Override
    public List<Cell> possibleMoves(
            IBoard board,
            Cell currentCell) {

        return new ArrayList<>();
    }

    @Override
    public int getValue() {

        return 1;
    }

    @Override
    public String getSymbol() {

        return color == Color.WHITE
                ? "♙"
                : "♟";
    }

    @Override
    public boolean canBePromoted(
            Cell currentCell) {

        return (color == Color.WHITE &&
                currentCell.getRow() == 7)
            ||
               (color == Color.BLACK &&
                currentCell.getRow() == 0);
    }

    @Override
    public Piece promoteTo(
            PieceType targetType,
            Color color) {

        if (targetType == PieceType.KING ||
            targetType == PieceType.PAWN) {

            throw new IllegalArgumentException(
                    "Cannot promote to "
                    + targetType);
        }

        PieceFactory factory =
                new PieceFactory();

        return factory.getPiece(
                targetType,
                color);
    }
}
```

---

### King

```java
class King extends Piece
        implements ICastleable {

    private boolean hasMoved;

    public King(Color color) {

        super(color);

        this.type = PieceType.KING;
    }

    @Override
    public List<Cell> possibleMoves(
            IBoard board,
            Cell currentCell) {

        return new ArrayList<>();
    }

    @Override
    public int getValue() {

        return Integer.MAX_VALUE;
    }

    @Override
    public String getSymbol() {

        return color == Color.WHITE
                ? "♔"
                : "♚";
    }

    @Override
    public boolean hasMoved() {

        return hasMoved;
    }

    @Override
    public boolean canCastle(
            IBoard board,
            Cell from,
            Cell to) {

        if (hasMoved)
            return false;

        // Validate castling conditions

        return true;
    }

    public void setMoved(
            boolean moved) {

        hasMoved = moved;
    }
}
```

---

### Rook

```java
class Rook extends Piece
        implements ICastleable {

    private boolean hasMoved;

    public Rook(Color color) {

        super(color);

        this.type = PieceType.ROOK;
    }

    @Override
    public List<Cell> possibleMoves(
            IBoard board,
            Cell currentCell) {

        return new ArrayList<>();
    }

    @Override
    public int getValue() {

        return 5;
    }

    @Override
    public String getSymbol() {

        return color == Color.WHITE
                ? "♖"
                : "♜";
    }

    @Override
    public boolean hasMoved() {

        return hasMoved;
    }

    @Override
    public boolean canCastle(
            IBoard board,
            Cell from,
            Cell to) {

        return !hasMoved;
    }

    public void setMoved(
            boolean moved) {

        hasMoved = moved;
    }
}
```

### Why this matters

Capability interfaces allow special behaviors to be handled polymorphically instead of using `switch` statements or checking `PieceType`.

Example:

```java
class MoveExecutor {

    public void executeMove(
            IBoard board,
            Move move) {

        Piece piece =
                move.getMovedPiece();

        if (piece instanceof IPromotable promotable &&
            promotable.canBePromoted(
                    move.getToCell())) {

            Piece promoted =
                    promotable.promoteTo(
                            PieceType.QUEEN,
                            piece.getColor());

            board.setCellPiece(
                    move.getToCell().getRow(),
                    move.getToCell().getColumn(),
                    promoted);

            return;
        }

        if (piece instanceof ICastleable castleable &&
            castleable.canCastle(
                    board,
                    move.getFromCell(),
                    move.getToCell())) {

            executeCastling(board, move);
            return;
        }

        executeRegularMove(board, move);
    }

    private void executeRegularMove(
            IBoard board,
            Move move) {

        // Regular move
    }

    private void executeCastling(
            IBoard board,
            Move move) {

        // Castling logic
    }
}
```

This is much cleaner than checking `PieceType`.

---

## 3. Create Board and Game Interfaces

### Board Interface

```java
interface IBoard {

    Cell getCell(int row, int column);

    void setCellPiece(
            int row,
            int column,
            Piece piece);

    Piece getPieceAt(
            int row,
            int column);

    int getSize();

    List<Piece> getAllPieces(
            Color color);

    IBoard clone();
}
```

---

### Game Interface

```java
interface IGame {

    boolean makeMove(Move move);

    GameStatus getStatus();

    Player getCurrentPlayer();

    List<Move> getMoveHistory();

    void undoLastMove();
}
```

---

### Game

```java
class Game implements IGame {

    private List<Player> players;

    private IBoard board;

    private GameState gameState;

    private MoveValidator validator;

    public Game(
            List<Player> players,
            IBoard board) {

        this.players = players;
        this.board = board;

        this.gameState =
                new GameState(players.get(0));

        this.validator =
                new MoveValidator(board);
    }

    @Override
    public boolean makeMove(
            Move move) {

        return true;
    }

    @Override
    public GameStatus getStatus() {

        return gameState.getStatus();
    }

    @Override
    public Player getCurrentPlayer() {

        return gameState.getCurrentPlayer();
    }

    @Override
    public List<Move> getMoveHistory() {

        return gameState.getMoveHistory();
    }

    @Override
    public void undoLastMove() {

        // Undo logic
    }
}
```

### Why this matters

Programming against interfaces makes the design:

- Easier to unit test.
- Flexible for multiple implementations.
- Suitable for AI, multiplayer, or network-based games.
- Better aligned with the **Dependency Inversion Principle**.

Mock implementations can also be created easily for testing.

```java
IGame game = new MockGame();

IBoard board = new MockBoard();
```

This greatly improves maintainability and extensibility.
````

# Q5. How well the design is creating relationships between the entities like Inheritance, Composition, Aggregation etc?

**Evaluator's Score:** **7.0/10**

## Evaluator's Feedback

### Strengths

1. **Correct Inheritance Hierarchy**
    - Your piece inheritance is well-structured.
    - All six piece types (`King`, `Queen`, `Rook`, `Bishop`, `Knight`, `Pawn`) inherit from the abstract `Piece` class, which is the correct relationship since all pieces **"are-a"** type of `Piece`.
    - This demonstrates a good understanding of the **Inheritance ("is-a")** relationship.

2. **Composition in Game**
    - The `Game` class uses composition correctly:
        - `Game` **has-a** `ChessBoard`
        - `Game` **has-a** list of `Players`
        - `Game` **has-a** list of removed pieces
    - These are proper composition relationships because the `Game` owns these objects and they don't exist independently.

3. **Aggregation with Pieces**
    - The `Player` class has an aggregation relationship with `Piece` objects (`List<Piece>`).
    - This is appropriate because pieces can exist independently of players and could theoretically be transferred between players (though not in standard chess).

---

# Areas for Improvement

## 1. Questionable Piece-Cell Relationship

Your design currently has:

```java
protected Cell cell;
```

inside `Piece`.

This creates several issues:

- Is this composition or association?
- The piece creates a new `Cell` in its constructor, suggesting composition.
- A `Cell` should actually be owned by the **Board**, not by the **Piece**.
- This creates dual ownership where both `Piece` and `ChessBoard` manage positions.

The preferred relationship should be:

```
ChessBoard
    └── owns Cells

Cell
    └── references Piece
```

instead of

```
Piece
    └── owns Cell
```

---

## 2. Missing Association from Cell to Piece

Your `Cell` class contains a `Piece` field, which is correct, but it is not being fully utilized.

The class should expose proper getter/setter methods so that the board manages piece placement through the cells.

---

## 3. Unclear Board-Cell Relationship

Although `ChessBoard` contains:

```java
List<List<Cell>> cells;
```

which correctly suggests composition, methods like:

- `placesAllBlackPieces()`
- `placesAllWhitePieces()`

are empty.

As a result, it isn't clear how pieces are actually assigned to board cells.

---

## 4. Missing Player-Game Association

Players currently don't appear to interact directly with the `Game`.

There should be a clear mechanism allowing players to make moves through the game.

---

## 5. Missing Move Entity Relationships

There is no `Move` class.

A chess move connects:

- Player
- Piece
- Source Cell
- Destination Cell

Without this entity, these relationships remain incomplete.

---

# Actionable Suggestions

## 1. Fix the Piece–Cell Relationship

```java
// Cell should be owned by the board and can contain a piece

class Cell {

    private int row;
    private int column;
    private Piece piece;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.piece = null;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public boolean isOccupiedBy(Color color) {
        return piece != null &&
               piece.getColor() == color;
    }
}

// Piece should NOT store its position

abstract class Piece {

    protected Color color;
    protected PieceType type;

    public Piece(Color color) {
        this.color = color;
    }

    public abstract List<Cell> possibleMoves(
            IBoard board,
            Cell currentCell);

    public PieceType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}
```

### Why this is better

- Removes dual ownership.
- The board becomes the single source of truth for positions.
- Pieces become independent of where they are placed.
- Makes move execution much cleaner.

---

## 2. Properly Implement Board–Cell Composition

```java
class ChessBoard implements IBoard {

    private List<List<Cell>> cells;
    private int size;

    public ChessBoard(int size,
                      BoardInitializer initializer) {

        this.size = size;

        createBoard(size);

        initializer.initializeBoard(this);
    }

    private void createBoard(int size) {

        cells = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {

            List<Cell> row = new ArrayList<>(size);

            for (int j = 0; j < size; j++) {
                row.add(new Cell(i, j));
            }

            cells.add(row);
        }
    }

    @Override
    public Cell getCell(int row, int column) {

        if (row >= 0 && row < size &&
            column >= 0 && column < size) {

            return cells.get(row).get(column);
        }

        return null;
    }

    @Override
    public void setCellPiece(int row,
                             int column,
                             Piece piece) {

        Cell cell = getCell(row, column);

        if (cell != null) {
            cell.setPiece(piece);
        }
    }

    @Override
    public Piece getPieceAt(int row,
                            int column) {

        Cell cell = getCell(row, column);

        return cell != null
                ? cell.getPiece()
                : null;
    }

    @Override
    public int getSize() {
        return size;
    }
}
```

### Standard Board Initialization

```java
class StandardChessInitializer
        implements BoardInitializer {

    @Override
    public void initializeBoard(IBoard board) {

        placeBackRow(board, 0, Color.WHITE);
        placePawns(board, 1, Color.WHITE);

        placePawns(board, 6, Color.BLACK);
        placeBackRow(board, 7, Color.BLACK);
    }

    private void placeBackRow(
            IBoard board,
            int row,
            Color color) {

        board.setCellPiece(row,0,new Rook(color));
        board.setCellPiece(row,1,new Knight(color));
        board.setCellPiece(row,2,new Bishop(color));
        board.setCellPiece(row,3,new Queen(color));
        board.setCellPiece(row,4,new King(color));
        board.setCellPiece(row,5,new Bishop(color));
        board.setCellPiece(row,6,new Knight(color));
        board.setCellPiece(row,7,new Rook(color));
    }

    private void placePawns(
            IBoard board,
            int row,
            Color color) {

        for(int col=0; col<8; col++) {
            board.setCellPiece(
                row,
                col,
                new Pawn(color)
            );
        }
    }
}
```

### Why this is better

- Clearly demonstrates **Composition**.
- `ChessBoard` owns every `Cell`.
- Cells are destroyed with the board.
- Ownership becomes explicit.

---

## 3. Add a Move Entity

```java
class Move {

    private Player player;
    private Cell fromCell;
    private Cell toCell;

    private Piece movedPiece;
    private Piece capturedPiece;

    private MoveType moveType;

    public Move(Player player,
                Cell from,
                Cell to,
                Piece piece) {

        this.player = player;
        this.fromCell = from;
        this.toCell = to;
        this.movedPiece = piece;

        this.capturedPiece = null;
        this.moveType = MoveType.REGULAR;
    }

    public Player getPlayer() {
        return player;
    }

    public Cell getFromCell() {
        return fromCell;
    }

    public Cell getToCell() {
        return toCell;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public Piece getCapturedPiece() {
        return capturedPiece;
    }

    public void setCapturedPiece(Piece piece) {
        this.capturedPiece = piece;
    }

    public void setMoveType(MoveType type) {
        this.moveType = type;
    }
}

enum MoveType {

    REGULAR,
    CASTLE_KINGSIDE,
    CASTLE_QUEENSIDE,
    EN_PASSANT,
    PROMOTION
}
```

### Why this is better

The `Move` entity captures relationships between:

- Player
- Piece
- Source Cell
- Destination Cell

It enables:

- Move history
- Undo/Redo
- PGN generation
- Replay
- Validation

---

## 4. Strengthen the Player–Piece Relationship

```java
class Player {

    private String name;
    private Color color;

    private List<Piece> activePieces;
    private List<Piece> capturedPieces;

    public Player(String name,
                  Color color) {

        this.name = name;
        this.color = color;

        activePieces = new ArrayList<>();
        capturedPieces = new ArrayList<>();
    }

    public void addPiece(Piece piece) {

        if(piece.getColor() == color) {
            activePieces.add(piece);
        }
    }

    public void removePiece(Piece piece) {
        activePieces.remove(piece);
    }

    public void capturePiece(Piece piece) {
        capturedPieces.add(piece);
    }

    public List<Piece> getActivePieces() {
        return new ArrayList<>(activePieces);
    }

    public List<Piece> getCapturedPieces() {
        return new ArrayList<>(capturedPieces);
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}
```

### Why this is better

This clearly models **Aggregation**.

A player manages:

- Active pieces
- Captured pieces

without owning their lifecycle.

---

## 5. Complete the Game Relationships

```java
class Game implements IGame {

    private List<Player> players;
    private IBoard board;

    private GameState gameState;

    private List<Move> moveHistory;

    private MoveValidator validator;
    private MoveExecutor executor;

    public Game(
            List<Player> players,
            IBoard board) {

        this.players = new ArrayList<>(players);

        this.board = board;

        this.gameState =
            new GameState(players.get(0));

        this.moveHistory =
            new ArrayList<>();

        this.validator =
            new MoveValidator(board);

        this.executor =
            new MoveExecutor(board);

        initializePlayerPieces();
    }

    private void initializePlayerPieces() {

        for(Player player : players) {

            List<Piece> pieces =
                board.getAllPieces(
                    player.getColor());

            for(Piece piece : pieces) {
                player.addPiece(piece);
            }
        }
    }

    @Override
    public boolean makeMove(Move move) {

        if(!validator.isValidMove(
                move,
                gameState)) {
            return false;
        }

        Piece capturedPiece =
            executor.executeMove(move);

        if(capturedPiece != null) {

            move.setCapturedPiece(capturedPiece);

            move.getPlayer()
                .capturePiece(capturedPiece);

            Player opponent =
                getOpponent(move.getPlayer());

            opponent.removePiece(capturedPiece);
        }

        moveHistory.add(move);

        gameState.addMove(move);

        updateGameState();

        return true;
    }

    private Player getOpponent(Player player) {

        return players.get(0).equals(player)
                ? players.get(1)
                : players.get(0);
    }

    private void updateGameState() {

        // Check:
        // - Check
        // - Checkmate
        // - Stalemate
        // - Change current player
    }
}
```

### Why this is better

The `Game` acts as the **Aggregate Root**, coordinating all major entities.

It owns and manages:

- Players
- Board
- GameState
- Move History
- MoveValidator
- MoveExecutor

This clearly demonstrates proper use of:

- **Composition** (`Game → Board`, `Game → GameState`, `Game → MoveHistory`)
- **Aggregation** (`Player → Pieces`)
- **Association** (`Move ↔ Player`, `Move ↔ Piece`, `Move ↔ Cells`)
- **Inheritance** (`Piece → King`, `Queen`, `Rook`, etc.)

This design makes the ownership, lifecycle, and interactions between entities explicit, resulting in a cleaner, more maintainable object-oriented model.
