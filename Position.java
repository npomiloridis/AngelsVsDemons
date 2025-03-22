package hw2;

/**
 * Represents a position on a 2D grid with row and column coordinates.
 * 
 * @author Nikolas Pomiloridis
 * @version 2.0
 * @since 22/03/2025
 */
public class Position {

	/**
	 * The row of the position.
	 */
	private int row;

	/**
	 * The column of the position.
	 */
	private int column;

	/**
	 * Constructs a {@link Position} with specified row and column values.
	 *
	 * @param r The row of the specified position.
	 * @param c The column of the specified position.
	 */
	public Position(int r, int c) {
		row = r;
		column = c;
	}

	/**
	 * Copy constructor for {@link Position}.
	 *
	 * @param p The position to copy.
	 */
	public Position(Position p) {
		this(p.row, p.column);
	}

	/**
	 * Default constructor for a {@link Position}.
	 *
	 * Creates a position with the default value of (0,0).
	 */
	public Position() {
		this(0, 0);
	}

	/**
	 * Retrieves the row of this {@link Position}.
	 *
	 * @return The row as an integer.
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Retrieves the column of this {@link Position}.
	 *
	 * @return The column as an integer.
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Returns a string representation of this {@link Position}.
	 *
	 * Example: If the row is 5 and the column is 3, this method returns "(5,3)".
	 *
	 * @return A string representing the position.
	 */
	public String toString() {
		return "(" + row + "," + column + ")";
	}

	/**
	 * Calculates the absolute row distance between this {@link Position} and
	 * another.
	 *
	 * @param p The position to compare with.
	 * @return The absolute difference in row values.
	 */
	public int rowDistance(Position p) {
		return Math.abs(p.getRow() - row);
	}

	/**
	 * Calculates the absolute column distance between this {@link Position} and
	 * another.
	 *
	 * @param p The position to compare with.
	 * @return The absolute difference in column values.
	 */
	public int columnDistance(Position p) {
		return Math.abs(p.getColumn() - column);
	}

}