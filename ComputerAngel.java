package hw2;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link ComputerAngel} class represents an AI-controlled Angel player in
 * the game.
 * <p>
 * ComputerAngel extends the {@link Angel} class and implements an algorithm to
 * automatically determine the optimal move. The ComputerAngel analyses possible
 * moves and selects the one that minimises the distance to the nearest edge of
 * the board, as reaching any edge results in a win for the Angel.
 * </p>
 *
 * @author Nikolas Pomiloridis
 * @version 1.0
 * @since 22/03/2025
 * @see Angel
 * @see Board
 * @see Position
 */
public class ComputerAngel extends Angel {

	/**
	 * Constructs a new ComputerAngel with the specified game board and power.
	 *
	 * @param board the {@link GraphicBoard} instance that this ComputerAngel will
	 *              interact with
	 * @param power the movement capability of this ComputerAngel
	 */
	public ComputerAngel(GraphicBoard board, int power) {
		super(board, power);
	}

	/**
	 * Creates a list of all valid positions where the Angel can move.
	 * <p>
	 * This method examines all squares within the Angel's power range and collects
	 * those that are empty into a list of possible moves.
	 * </p>
	 *
	 * @param board the {@link Board} to search for possible moves
	 * @return a {@link List} of {@link Position} objects representing valid moves
	 */
	private List<Position> getPossibleMoves(Board board) {
		Position currentPosition = board.getAngelPosition();

		List<Position> moves = new ArrayList<>();
		for (int i = currentPosition.getRow() - getPower(); i <= currentPosition.getRow() + getPower(); i++)
			for (int j = currentPosition.getColumn() - getPower(); j <= currentPosition.getColumn() + getPower(); j++) {
				if (i < 0 || i >= board.getSize() || j < 0 || j >= board.getSize())
					continue;
				if (board.getCell(i, j) == 'E') {
					moves.add(new Position(i, j));
				}
			}
		return moves;
	}

	/**
	 * Calculates the minimum distance from a given position to any edge of the
	 * board.
	 * <p>
	 * This is a function used to evaluate how close a position is to winning the
	 * game.
	 * </p>
	 *
	 * @param p the {@link Position} to evaluate
	 * @return the minimum number of squares from the position to the nearest edge
	 */
	private int calculateMinDistanceToEdge(Position p) {
		int x = p.getRow();
		int y = p.getColumn();

		int distanceToTop = x;
		int distanceToBottom = board.getSize() - x - 1;
		int distanceToLeft = y;
		int distanceToRight = board.getSize() - y - 1;

		return Math.min(Math.min(distanceToTop, distanceToBottom), Math.min(distanceToLeft, distanceToRight));
	}

	/**
	 * Determines the optimal next move for the ComputerAngel.
	 * <p>
	 * This method analyses all possible moves and selects the one that:
	 * <ul>
	 * <li>Immediately wins the game if possible (by moving to an edge)</li>
	 * <li>Otherwise, minimises the distance to the nearest edge</li>
	 * </ul>
	 * </p>
	 *
	 * @return the {@link Position} representing the optimal next move, or null if
	 *         no moves are available
	 */
	private Position determineNextMove() {
		Position bestMove = null;
		int shortestDistance = Integer.MAX_VALUE;

		// Get all possible moves based on Angel's power
		List<Position> possibleMoves = getPossibleMoves(board);

		// Evaluate each possible move
		for (Position move : possibleMoves) {
			int x = move.getRow();
			int y = move.getColumn();

			// Check if this move is an edge square (instant win)
			if (x == 0 || x == board.getSize() - 1 || y == 0 || y == board.getSize() - 1) {
				return move; // Return immediately if we can win
			}

			// Calculate minimum distance to any edge
			int distanceToEdge = calculateMinDistanceToEdge(move);

			// Update best move if this one is closer to an edge
			if (distanceToEdge < shortestDistance) {
				shortestDistance = distanceToEdge;
				bestMove = move;
			}
		}

		return bestMove;
	}

	/**
	 * Executes the computer-controlled movement for the Angel.
	 * <p>
	 * This method determines the optimal move using AI logic and then updates the
	 * Angel's position on the board.
	 * </p>
	 */
	public void move() {
		Position nextPosition = determineNextMove();

		board.moveAngel(nextPosition);
	}

	/**
	 * Executes the ComputerAngel's turn by automatically moving to the optimal
	 * position.
	 * <p>
	 * This implementation overrides the abstract method from {@link Player} and
	 * calls the {@link #move()} method to handle the AI-controlled movement.
	 * </p>
	 */
	@Override
	public void takeTurn() {
		move();
	}
}
