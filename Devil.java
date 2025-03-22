package hw2;

/**
 * The {@link Devil} class represents a Devil player in the game.
 * <p>
 * A Devil is a type of {@link Player} whose primary action is to break empty
 * squares on the board, making them inaccessible to the Angel. The Devil's
 * strategy involves limiting the Angel's movement options.
 * </p>
 *
 * @author Nikolas Pomiloridis
 * @version 1.0
 * @since 22/03/2025
 * @see Player
 * @see Angel
 * @see GraphicBoard
 */
public class Devil extends Player {

	/**
	 * Constructs a new Devil player with the specified game board.
	 *
	 * @param board the {@link GraphicBoard} instance that this Devil will interact
	 *              with
	 */
	public Devil(GraphicBoard board) {
		super(board);
	}

	/**
	 * Handles the square-breaking process for the Devil player.
	 * <p>
	 * Prompts the user to select a valid empty square to break. The method
	 * continues prompting until a valid empty square is selected. Once selected,
	 * the square is marked as broken ('B') on the board.
	 * </p>
	 */
	private void breakSquare() {
		System.out.println("Choose a square to break.");
		board.changeBotText("Choose a square to break.");

		Position p = getMouseClick();

		while (!board.isEmpty(p)) {
			System.out.println("Square must be empty to break. Choose another spot.");
			board.changeBotText("Square must be empty to break. Choose another spot.");

			p = getMouseClick();
		}

		board.setCell(p, 'B');
	}

	/**
	 * Executes the Devil's turn by breaking a square on the board.
	 * <p>
	 * This implementation of the abstract method from {@link Player} calls the
	 * private {@link #breakSquare()} method to handle the Devil's square-breaking
	 * action.
	 * </p>
	 */
	@Override
	public void takeTurn() {
		breakSquare();
	}

	/**
	 * Returns a string representation of this Devil player.
	 *
	 * @return a string indicating this is a Devil player
	 */
	@Override
	public String toString() {
		return "Current Player : Devil";
	}

}
