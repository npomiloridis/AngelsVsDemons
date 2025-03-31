# Angels vs Demons - Strategic Board Game

A turn-based strategy game where an Angel tries to escape to the board's edges while the Devil attempts to block its path by breaking squares. Features both human and AI players.

---

## 🎮 Game Overview

### Core Mechanics
- **Angel Player**:
  - Moves up to `power` squares in any direction each turn
  - Wins by reaching any edge of the board
    
- **Devil Player**:
  - Breaks one empty square per turn (marked as 'B')
  - Wins by trapping the Angel (no valid moves left)

### Game Modes
1. **Human vs Human** - Two players alternate turns
2. **Computer vs Computer** - Watch AI opponents battle

---

## 🚀 How to Run

### Prerequisites
- Java JDK 8+
- `algs4.jar` (Princeton Standard Libraries, included in repository)
- `angel.png` and `crack.png` (Images used for rendering, included in repository under `lib` directory)

### Steps

1. **Clone the repository:**
 ```bash
	git clone https://github.com/npomiloridis/AngelsVsDemons.git
	cd AngelsVsDemons
```
2. **Compile the code:**

- **Windows**: `javac -cp .;algs4.jar hw2/*.java`
- **Linux**: `javac -cp .:algs4.jar hw2/*.java`

3. **Launch the game:**
- **Windows**: `java -cp .;algs4.jar hw2.AngelsVsDemons`
- **Linux**: `java -cp .:algs4.jar hw2.AngelsVsDemons`

---

## 📝 Example Game Flow
```bash
Welcome to the Angel game.
Choose a way to play:
1 - You play versus another user
2 - Computer plays versus computer
Enter a category: 1
Size of the board? 5
Power of Angel? 2

[Graphical board appears]
Current Player : Angel
Choose a square to move to.
```

---

## 📁 Project Structure

### Core Classes
| Class | Description | Key Features |
|-------|-------------|--------------|
| `AngelsVsDemons` | Main entry point | Handles game initialization |
| `Game` | Game controller | Manages turn flow and win conditions |
| `GraphicBoard` | Visual board | Renders game state with images |
| `Board` | Logical board | Tracks cell states and positions |

### Player Classes
| Class | Role | Key Features |
|-------|------|-------------------|
| `Player` | Abstract base | Mouse input handling |
| `Angel` | Escape artist | Power-based movement |
| `Devil` | Blocker | Square-breaking |
| `ComputerAngel` | AI Angel | Pathfinding to nearest edge |
| `ComputerDevil` | AI Devil | Strategic blocking |

### Support Classes
| Class | Purpose |
|-------|---------|
| `Cell` | Tracks cell state |
| `Position` | Handles board coordinates |
