package hw2;

/**
 * The {@link Game} class manages the overall game flow, including initialising
 * the board, handling turns between the Angel and Devil, and determining the
 * winner.
 * 
 * @author Nikolas Pomiloridis
 * @version 1.0
 * @since 22/03/2025
 */
public class Game {

	/**
	 * Indicates whether the game is in auto mode (computer vs. computer) or in
	 * manual mode (player vs. player).
	 */
	private boolean auto;

	/** The size of the game board. */
	private int boardSize;

	/** The power of the angel. */
	private int angelPower;

	/**
	 * Keeps track of the turn number. This is used to determine which player goes
	 * next and to determine the winner of the game.
	 */
	private int turn = 0;

	/** The Angel player in the game, either controlled by a human or AI. */
	private Angel angel;

	/** The Devil player in the game, either controlled by a human or AI. */
	private Devil devil;

	/**
	 * Constructs a new {@link Game} instance with the specified board size, angel
	 * power, and game mode.
	 *
	 * @param size  The size of the board.
	 * @param power The power of the angel.
	 * @param auto  {@code true} if the game should be played by computer-controlled
	 *              players, {@code false} if it is played by human players.
	 */
	public Game(int size, int power, boolean auto) {
		boardSize = size;
		angelPower = power;
		this.auto = auto;
	}

	/**
	 * Checks if the game has been won by either the Angel or the Devil.
	 *
	 * @return {@code true} if the game is over, {@code false} otherwise.
	 */
	private boolean hasWin() {
		if (angel.hasWon())
			return true;
		if (!angel.canMove())
			return true;
		return false;
	}

	/**
	 * Starts and controls the main game loop, alternating turns between Angel and
	 * Devil until one of them wins. Displays the board and results accordingly.
	 */
	public void play() {

		GraphicBoard board = new GraphicBoard(boardSize);
		board.display();

		// Initialise Angel and Devil based on game mode
		if (auto == false) {
			angel = new Angel(board, angelPower);
			devil = new Devil(board);
		} else {
			angel = new ComputerAngel(board, angelPower);
			devil = new ComputerDevil(board, angelPower);
		}

		// Main game loop.
		while (!hasWin()) {
			turn++;

			if (turn % 2 == 1) {
				System.out.println(angel);
				board.changeTopText(angel.toString());
				angel.takeTurn();
			} else {
				System.out.println(devil);
				board.changeTopText(devil.toString());
				devil.takeTurn();
			}

			board.display();
		}

		board.changeBotText("");

		// Determine and announce the winner.
		if (turn % 2 == 1) {
			System.out.println("Angel Wins!");
			board.changeTopText("Angel Wins!");
		} else {
			System.out.println("Devil Wins!");
			board.changeTopText("Devil Wins!");
		}

	}

}
