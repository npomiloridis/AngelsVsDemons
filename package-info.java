/**
 * The hw2 package contains classes for an Angel and Devil game implementation.
 * <p>
 * This package implements a game where an Angel player tries to reach the edge of the board
 * while a Devil player tries to block the Angel's path by breaking squares on the board.
 * The package includes both human-controlled and computer-controlled player classes.
 * </p>
 * 
 * Key Components:
 * <ul>
 *   <li>{@link hw2.AngelsVsDemons} - The main class from which this game is run.</li>
 *   <li>{@link hw2.Game} - Manages the overall game flow</li>
 *   <li>{@link hw2.Player} - Abstract base class for all player types</li>
 *   <li>{@link hw2.Angel} - Represents the Angel player who tries to reach the edge</li>
 *   <li>{@link hw2.Devil} - Represents the Devil player who breaks squares</li>
 *   <li>{@link hw2.ComputerAngel} - AI implementation of the Angel player</li>
 *   <li>{@link hw2.ComputerDevil} - AI implementation of the Devil player</li>
 *   <li>{@link hw2.Board} - Representation of the board of the game</li>
 *   <li>{@link hw2.GraphicBoard} - Graphical representation of the game board</li>
 *   <li>{@link hw2.Position} - Utility class for handling board positions</li>
 *   <li>{@link hw2.Cell} - Utility class for each cell in the board</li>
 * </ul>
 * 
 * Game Rules:
 * <ul>
 *   <li>The Angel has a power value that determines how many squares it can move in a turn</li>
 *   <li>The Angel wins by reaching any edge of the board</li>
 *   <li>The Devil breaks one empty square per turn</li>
 *   <li>The Devil wins if the Angel has no valid moves</li>
 * </ul>
 * 
 * Compilation Commands: 
 * <ul>
 * 	<li>javac -cp .:algs4.jar hw2/*.java  (Linux)</li>
 * 	<li>javac -cp .;algs4.jar hw2/*.java  (Windows)</li>
 * </ul>
 * 
 * Execution Commands:
 * <ul>
 * 	<li>java -cp .:algs4.jar hw2.AngelsVsDemons  (Linux)</li>
 * 	<li>java -cp .;algs4.jar hw2.AngelsVsDemons  (Windows)</li>
 * </ul>
 * 
 * Note: Files "angel.png" and "crack.png" must be placed under the same directory as the package.
 * <ul>
 * 	<li>Parent Directory</li>
 * 	<ul>
 * 		<li>hw2</li>
 * 		<li>algs4.jar</li>
 * 		<li>angel.png</li>
 * 		<li>crack.png</li>
 * 	</ul>
 * </ul>
 * 
 * @author Nikolas Pomiloridis
 * @version 1.0
 * @since 22/03/2025
 */
package hw2;