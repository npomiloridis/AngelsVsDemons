package hw2;

import java.util.Scanner;

/**
 * The {@link AngelsVsDemons} class serves as the entry point for the game. It
 * prompts the user for game settings such as game mode, board size, and angel
 * power, then initialises and starts the game.
 * 
 * Compilation Commands: 
 * <ul>
 * 	<li>javac -cp .:algs4.jar hw2/*.java  (Linux)</li>
 * 	<li>javac -cp .;algs4.jar hw2/*.java  (Windows)</li>
 * </un>
 * 
 * Execution Commands:
 * <ul>
 * 	<li>java -cp .:algs4.jar hw2.AngelsVsDemons  (Linux)</li>
 * 	<li>java -cp .;algs4.jar hw2.AngelsVsDemons  (Windows)</li>
 * </ul>
 * 
 * @author Nikolas Pomiloridis
 * @version 1.0
 * @since 22/03/2025
 */
public class AngelsVsDemons {

	/**
	 * The main method prompts the user for game settings and starts the game
	 * accordingly.
	 *
	 * @param args Command-line arguments (not used in this application).
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the Angel game.\nChoose a way to play :\n1 - You play versus another user.\n"
						+ "2 - Computer plays versus computer\nEnter a category: ");

		// validate gameMode input.
		int gameMode = scan.nextInt();
		while (gameMode != 1 && gameMode != 2) {
			System.out.println("Invalid category code. Please enter category again: ");
			gameMode = scan.nextInt();
		}

		// validate size input.
		System.out.println("Size of the board ? ");
		int size = scan.nextInt();
		while (size < 3) {
			System.out.println("Board size should be at least 3. Please enter size again: ");
			size = scan.nextInt();
		}

		// validate power input.
		System.out.println("Power of Angel ? ");
		int power = scan.nextInt();
		while (power < 1) {
			System.out.println("The power of the angel should be at least 1. Please enter power again: ");
			power = scan.nextInt();
		}

		System.out.println("Begin the game...");

		boolean auto = gameMode == 2;

		// create and start the game.
		Game game = new Game(size, power, auto);
		game.play();

		scan.close();

	}

}
