package hw2;

/**
 * The {@link Angel} class represents an Angel player in the game.
 * <p>
 * An Angel is a type of {@link Player} that can move up to a certain number of
 * squares in any direction, defined by its power. The Angel wins by reaching
 * any edge of the board.
 * </p>
 *
 * @author Nikolas Pomiloridis
 * @version 1.0
 * @since 22/03/2025
 * @see Player
 * @see GraphicBoard
 */
public class Angel extends Player{

    /**
     * The movement capability of this Angel, determining how many squares it can move in a single turn.*/
	private int power;
	
    /**
     * Constructs a new Angel with the specified game board and power.
     *
     * @param board the {@link GraphicBoard} instance that this Angel will interact with
     * @param power the movement capability of this Angel
     */
	public Angel(GraphicBoard board, int power) {
		super(board);
		this.power = power;
	}
	
    /**
     * Handles the movement logic for the Angel player.
     * <p>
     * Prompts the user to select a valid destination square. The destination must be:
     * <ul>
     *   <li>Within the Angel's power range (in both row and column)</li>
     *   <li>An empty square on the board</li>
     * </ul>
     * The method continues prompting until a valid move is selected.
     * </p>
     */
	private void move() {
		System.out.println("Choose a square to move to.");
		board.changeBotText("Choose a square to move to.");
		Position p = getMouseClick();
		Position currentPosition = board.getAngelPosition();
		
		while(p.rowDistance(currentPosition) > power || p.columnDistance(currentPosition) > power || !board.isEmpty(p)) {
			
			if(!board.isEmpty(p)) {
				System.out.println("You can only move to an empty square. Choose another spot.");
				board.changeBotText("You can only move to an empty square. Choose another spot.");
			}
			else {
				System.out.println("You can only move a number of squares less than or equal to your power. Choose another spot.");
				board.changeBotText("You can only move a number of squares less than or equal to your power. Choose another spot.");
			}
			
			p = getMouseClick();
		}
		
		board.moveAngel(p);
	}

    /**
     * Executes the Angel's turn by moving to a new position.
     *<p>
     * This implementation of the abstract method from {@link Player}
     * calls the private {@link #move()} method to handle the Angel's movement.
     *</p>
     */
	@Override
	public void takeTurn() {
		move();		
	}

    /**
     * Determines if the Angel has any valid moves available.
     * <p>
     * Checks all squares within the Angel's power range to find if there
     * are any empty cells where the Angel can move.
     * </p>
     *
     * @return {@code true} if the Angel can make at least one valid move, {@code false} otherwise.
     */
	public boolean canMove() {
		Position currentPosition = board.getAngelPosition();
		for(int i=currentPosition.getRow()-power; i <= currentPosition.getRow() + power; i++)
			for(int j=currentPosition.getColumn()-power; j <= currentPosition.getColumn() + power; j++) {
				if(i<0 || i >= board.getSize() ||  j<0 || j>= board.getSize() )
					continue;
				if(board.getCell(i, j) == 'E')
					return true;
			}
		return false;
	}
	
    /**
     * Determines if the Angel has won the game.
     * <p>
     * The Angel wins by reaching any edge of the board.
     * </p>
     *
     * @return {@code true} if the Angel has reached any edge of the board, {@code false} otherwise.
     */
	public boolean hasWon() {
		Position currentPosition = board.getAngelPosition();
		if(currentPosition.getRow() == 0 || currentPosition.getRow() == board.getSize()-1 || currentPosition.getColumn() == 0 || currentPosition.getColumn() == board.getSize()-1)
			return true;
		return false;
	}
	
    /**
     * Gets the power of this Angel.
     *
     * @return the movement capability of this Angel.
     */
	public int getPower() {
		return power;
	}
	
    /**
     * Returns a string representation of this Angel player.
     *
     * @return a string indicating this is an Angel player
     */
	@Override
	public String toString() {
		return "Current Player : Angel";
	}
}
