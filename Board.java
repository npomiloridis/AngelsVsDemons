package hw2;

/**
 * Represents the game board for Angels vs Demons. Manages cell states, angel
 * position, and board display.
 * 
 * @author Nikolas Pomiloridis
 * @version 1.0
 * @since 22/03/2025
 * @see Cell
 * @see Position
 */
public class Board {

	/**
	 * A 2D array representing the game board.
	 */
	private Cell[][] board;

	/**
	 * The current position of the Angel on the board.
	 */
	private Position angelPosition;

	/**
	 * Constructs a square {@link Board} of the given size and initialises its
	 * cells. The angel is placed at the centre of the board.
	 *
	 * @param size The size of the board.
	 */
	public Board(int size) {
		board = new Cell[size][size];

		// Initialise board with empty cells.
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				board[i][j] = new Cell();

		// Set the angel's position to the middle of the board.
		angelPosition = new Position(size / 2, size / 2);
		setCell(angelPosition, 'A');
	}

	/**
	 * Checks if the specified {@link Position} is empty.
	 * 
	 * If the position given is outside of the board's bounds, this method returns
	 * {@code false}
	 *
	 * @param p The position to check.
	 * @return {@code true} if the cell is empty, {@code false} otherwise.
	 */
	public boolean isEmpty(Position p) {
		if (p.getRow() < 0 || p.getRow() >= board.length || p.getColumn() < 0 || p.getColumn() >= board.length)
			return false;
		return board[p.getRow()][p.getColumn()].isEmpty();
	}

	/**
	 * Sets the state of a {@link Cell} at the given {@link Position}.
	 *
	 * @param p        The position of the cell to update.
	 * @param newState The new state of the cell.
	 */
	public void setCell(Position p, char newState) {
		board[p.getRow()][p.getColumn()].setState(newState);
	}

	/**
	 * Moves the {@link Angel} to a new {@link Position} on the board.
	 *
	 * @param p The new position of the angel.
	 */
	public void moveAngel(Position p) {
		setCell(angelPosition, 'E');

		setCell(p, 'A');
		angelPosition = new Position(p);
	}

	/**
	 * Gets the size of the board.
	 *
	 * @return The size of the board.
	 */
	public int getSize() {
		return board.length;
	}

	/**
	 * Gets the current {@link Position} of the angel.
	 *
	 * @return A new position representing the angel's location.
	 */
	public Position getAngelPosition() {
		return new Position(angelPosition);
	}

	/**
	 * Retrieves the state of a {@link Cell} at the specified row and column.
	 *
	 * @param row    The row index of the cell.
	 * @param column The column index of the cell.
	 * @return The character representing the state of the cell.
	 */
	public char getCell(int row, int column) {
		return board[row][column].getState();
	}

	/**
	 * Retrieves the state of a {@link Cell} at the given {@link Position}.
	 *
	 * @param p The position of the cell.
	 * @return The character representing the state of the cell.
	 */
	public char getCell(Position p) {
		return board[p.getRow()][p.getColumn()].getState();
	}

	/**
	 * Displays the board state in a formatted grid.
	 */
	public void display() {
		StringBuilder display = new StringBuilder();
		display.append(" ");

		for (int i = 0; i < board.length; i++) {
			display.append("   ");
			display.append(i + 1);
		}

		// adds horizontal line.
		display.append("\n  ");

		for (int k = 0; k < 4 * board.length + 1; k++)
			display.append("-");
		display.append("\n");

		// adds vertical lines and cells.
		for (int i = 0; i < board.length; i++) {

			display.append(i + 1 + " ");

			for (int j = 0; j < board[0].length; j++) {
				display.append("| ");
				display.append(board[i][j]);
				display.append(" ");
			}

			display.append("|\n  ");

			// prints horizontal line.
			for (int k = 0; k < 4 * board.length + 1; k++)
				display.append("-");

			display.append("\n");
		}

		System.out.print(display);
	}

}
