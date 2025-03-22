package hw2;

/**
 * Represents a single cell in the game board. Each cell has a state that can be:
 * <ul>
 *   <li>'E' - Empty</li>
 *   <li>'A' - Occupied by an Angel</li>
 *   <li>'B' - Blocked</li>
 * </ul>
 * 
 * @author Nikolas Pomiloridis
 * @version 1.0
 * @since 22/03/2025
 */
public class Cell {

    /**
     * Describes the current state of this {@link Cell}.
     */
	private char state;

	/**
	 * The no parameter constructor for a {@link Cell}.
	 * 
	 * Sets the cell's state to empty.
	 */
	public Cell() {
		state = 'E';
	}

	/**
	 * Setter method for the state attribute.
	 * 
	 * Sets this cell's state to the parameter given.
	 * 
	 * @param state A character to set the cell's state as.
	 */
	public void setState(char state) {
		this.state = state;
	}

	/**
	 * Getter method for the state attribute.
	 * 
	 * @return The character representing the state of this cell.
	 */
	public char getState() {
		return state;
	}

	/**
	 * Checks whether this cell is empty.
	 * 
	 * @return {@code true} if the state attribute is 'E', returns {@code false}
	 *         otherwise.
	 */
	public boolean isEmpty() {
		return state == 'E';
	}

	/**
	 * Checks whether this cell is blocked.
	 * 
	 * @return {@code true} if the state of this cell is 'B', returns {@code false}
	 *         otherwise.
	 */
	public boolean isBlocked() {
		return state == 'B';
	}

	/**
	 * Returns a string representation of the cell. If the cell is empty ('E'), a
	 * space character is returned instead.
	 * 
	 * @return A string representing the cell's state.
	 */
	public String toString() {
		char display = state;

		if (state == 'E')
			display = ' ';

		return "" + display;
	}
}