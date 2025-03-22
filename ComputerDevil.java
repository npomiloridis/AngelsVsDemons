package hw2;

/**
 * The {@link ComputerDevil} class represents an AI-controlled Devil player in
 * the game.
 * <p>
 * ComputerDevil extends the {@link Devil} class and implements an intelligent
 * strategy to place broken squares on the board. The primary strategy is to
 * block the Angel's shortest path to the nearest edge, making it harder for the
 * Angel to win.
 * </p>
 *
 * @author Nikolas Pomiloridis
 * @version 1.0
 * @since 22/03/2025
 * @see Devil
 * @see ComputerAngel
 * @see GraphicBoard
 */
public class ComputerDevil extends Devil {

	/**
	 * The power of the Angel player. This information is used to calculate optimal
	 * blocking strategies.
	 */
	private int angelPower;

	/**
	 * Constructs a new ComputerDevil with the specified game board and the Angel's
	 * power.
	 *
	 * @param board      the {@link GraphicBoard} instance that this ComputerDevil
	 *                   will interact with
	 * @param angelPower the movement capability of the opposing Angel player
	 */
	public ComputerDevil(GraphicBoard board, int angelPower) {
		super(board);
		this.angelPower = angelPower;
	}

	/**
	 * Finds any available empty square on the board.
	 * <p>
	 * This method is used when the primary blocking strategy cannot be applied.
	 * </p>
	 *
	 * @return a {@link Position} representing any empty square on the board, or
	 *         null if no empty squares are available
	 */
	private Position getAnyAvailableMove() {
		int boardSize = board.getSize();

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (board.getCell(i, j) == 'E') {
					return new Position(i, j);
				}
			}
		}

		return null; // No available moves (shouldn't happen in normal gameplay)
	}

	/**
	 * Determines the optimal next move for the ComputerDevil.
	 * <p>
	 * This method applies different strategies in order of priority:
	 * <ol>
	 * <li>Block the Angel's shortest path to the nearest edge</li>
	 * <li>If no blocking move is found, choose any available empty square</li>
	 * </ol>
	 * </p>
	 *
	 * @return the {@link Position} representing the optimal square to break
	 */
	private Position getNextMove() {

		// Block the shortest path to the nearest edge
		Position blockingMove = blockPathToNearestEdge();
		if (blockingMove != null) {
			return blockingMove;
		}

		// Find any valid move
		return getAnyAvailableMove();
	}

	/**
	 * Attempts to find a position that blocks the Angel's shortest path to the
	 * nearest edge.
	 * <p>
	 * This method first determines which edge is closest to the Angel's current
	 * position. Then it attempts to find an empty square at a distance of
	 * angelPower from the Angel in the direction of that edge, to prevent the Angel
	 * from reaching the edge.
	 * </p>
	 *
	 * @return a {@link Position} that blocks the Angel's path to the nearest edge,
	 *         or null if no suitable blocking position is found
	 */
	private Position blockPathToNearestEdge() {

		Position angelPos = board.getAngelPosition();
		int angelX = angelPos.getColumn();
		int angelY = angelPos.getRow();
		String nearestEdge = "";

		// Determine which edge is closest to the Angel
		if (Math.abs(angelY - (board.getSize() - 1) / 2.0) < Math.abs(angelX - (board.getSize() - 1) / 2.0))
			if (angelX < board.getSize() / 2.0)
				nearestEdge = "left";
			else
				nearestEdge = "right";
		else if (angelY < board.getSize() / 2.0)
			nearestEdge = "top";
		else
			nearestEdge = "bottom";

		// Try to block the path to the nearest edge
		if (nearestEdge.equals("top")) {
			int i = Math.max(angelY - angelPower, 0);
			int j = 0;

			while (true) {
				if (angelX + j < board.getSize() && board.getCell(i, angelX + j) == 'E')
					return new Position(i, angelX + j);
				else if (angelX - j >= 0 && board.getCell(i, angelX - j) == 'E')
					return new Position(i, angelX - j);

				j++;

				if (angelX + j > board.getSize() && angelX - j < 0)
					break;
			}
			
		} else if (nearestEdge.equals("bottom")) {
			int i = Math.min(angelY + angelPower, board.getSize() - 1);
			int j = 0;

			while (true) {
				if (angelX + j < board.getSize() && board.getCell(i, angelX + j) == 'E')
					return new Position(i, angelX + j);
				else if (angelX - j >= 0 && board.getCell(i, angelX - j) == 'E')
					return new Position(i, angelX - j);

				j++;

				if (angelX + j > board.getSize() && angelX - j < 0)
					break;
			}
			
		} else if (nearestEdge.equals("left")) {
			int i = 0;
			int j = Math.max(angelX - angelPower, 0);

			while (true) {
				if (angelY + i < board.getSize() && board.getCell(angelY + i, j) == 'E')
					return new Position(angelY + i, j);
				else if (angelY - i >= 0 && board.getCell(angelY - i, j) == 'E')
					return new Position(angelY - i, j);

				i++;

				if (angelY + i > board.getSize() && angelY - i < 0)
					break;
			}
			
		} else if (nearestEdge.equals("right")) {
			int i = 0;
			int j = Math.min(angelX + angelPower, board.getSize() - 1);

			while (true) {
				if (angelY + i < board.getSize() && board.getCell(angelY + i, j) == 'E')
					return new Position(angelY + i, j);
				else if (angelY - i >= 0 && board.getCell(angelY - i, j) == 'E')
					return new Position(angelY - i, j);

				i++;

				if (angelY + i > board.getSize() && angelY - i < 0)
					break;
			}
		}

		return null;

	}

	/**
	 * Executes the ComputerDevil's turn by automatically breaking a square on the
	 * board based on AI strategy.
	 * <p>
	 * This implementation overrides the method from {@link Devil} to use the AI's
	 * determined optimal move.
	 * </p>
	 */
	@Override
	public void takeTurn() {
		board.setCell(getNextMove(), 'B');
	}

}
