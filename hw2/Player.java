package hw2;

import edu.princeton.cs.algs4.StdDraw;

/**
 * The {@link Player} class represents an abstract player in the game. It
 * provides common functionality for handling user input and interactions.
 * <p>
 * This abstract class serves as a base for different player types and handles
 * basic operations like detecting mouse clicks and converting them to board
 * positions.
 * </p>
 *
 * @author Nikolas Pomiloridis
 * @version 1.0
 * @since 22/03/2025
 * @see GraphicBoard
 * @see Position
 */
public abstract class Player {

	/** The game board this player interacts with. */
	protected GraphicBoard board;

	/**
	 * Constructs a new Player with the specified game board.
	 *
	 * @param board the {@link GraphicBoard} instance that this player will interact
	 *              with
	 */
	public Player(GraphicBoard board) {
		this.board = board;
	}

	/**
	 * Waits for and processes a mouse click from the user.
	 * <p>
	 * This method waits until the user clicks the mouse, then converts the click
	 * coordinates to match the board's coordinate system. If the user clicks on the
	 * exit button, the program terminates.
	 * </p>
	 *
	 * @return a {@link Position} object representing the board coordinates where
	 *         the user clicked
	 */
	public Position getMouseClick() {

		// wait for mouse click
		while (!StdDraw.isMousePressed())
			;

		// get mouse coordinates and transpose them to match board coordinates.
		int col = (int) StdDraw.mouseX();
		int row = board.getSize() - 1 - (int) StdDraw.mouseY();

		// If any player clicks on the exit button, the programme ends.
		if (row == -1 && (col == board.getSize() || col == board.getSize() - 1))
			System.exit(0);

		Position coordinates = new Position(row, col);

		StdDraw.pause(100);

		return coordinates;
	}

	/**
	 * Abstract method that defines how a player takes their turn.
	 * <p>
	 * This method must be implemented by concrete subclasses to specify the
	 * specific behaviour during a player's turn.
	 * </p>
	 */
	public abstract void takeTurn();

	/**
	 * Returns a string representation of the player.
	 * <p>
	 * This method must be implemented by concrete subclasses to provide a
	 * meaningful textual representation of the player.
	 * </p>
	 *
	 * @return a string representation of the player
	 */
	public abstract String toString();

}
