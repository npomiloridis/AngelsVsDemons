package hw2;

import java.awt.Color;
import java.awt.Font;
import edu.princeton.cs.algs4.StdDraw;

/**
 * The {@link GraphicBoard} class extends {@link Board} to provide a graphical
 * representation of the game board. It uses {@code StdDraw} to render the
 * board, the angel, and cracks dynamically.
 * 
 * @author Nikolas Pomiloridis
 * @version 1.0
 * @since 22/03/2025
 * @see Board
 */
public class GraphicBoard extends Board {

	/** The pen radius used for drawing borders. */
	private static final double PEN_RADIUS = 0.035;

	/** The file path for the angel image. */
	private static final String ANGEL_PATH = "lib/angel.png";

	/** The file path for the crack image. */
	private static final String CRACK_PATH = "lib/crack.png";

	/** The color used for text and letters. */
	private static final Color LETTERS = new Color(24, 29, 39);

	/** The primary color for board squares. */
	private static final Color SQUARE1 = new Color(210, 209, 185);

	/** The secondary color for board squares. */
	private static final Color SQUARE2 = new Color(251, 252, 235);

	/** The color used for the background */
	private static final Color BACKGROUND = new Color(230, 212, 182);

	/**
	 * Constructs a {@link GraphicBoard} with the specified size.
	 * 
	 * @param size The size of the board.
	 */
	public GraphicBoard(int size) {
		super(size);

		createCanvas();
		drawBoarder();
		drawExitButton();
		update();

		// Pre-loads images to reduce delay during gameplay.
		drawAngel(500, 500);
		drawCrack(500, 500);
	}

	/**
	 * Initialises the drawing canvas and sets the background.
	 */
	private void createCanvas() {
		StdDraw.setCanvasSize(750, 750);
		StdDraw.setXscale(-1, getSize() + 1);
		StdDraw.setYscale(-1, getSize() + 1);
		StdDraw.enableDoubleBuffering();

		// Draws the background
		StdDraw.setPenColor(BACKGROUND);
		StdDraw.filledSquare(getSize() / 2.0, getSize() / 2.0, getSize() / 2.0 + 1);

	}

	/**
	 * Draws the grid squares on the {@link Board}.
	 */
	private void drawGrid() {
		// Draw grid squares.
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {

				if ((i + j) % 2 == 0)
					StdDraw.setPenColor(SQUARE1);
				else
					StdDraw.setPenColor(SQUARE2);

				StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
			}
		}
	}

	/**
	 * Draws the {@link Angel} at the specified {@link Position}.
	 * 
	 * @param row    The row index.
	 * @param column The column index.
	 */
	private void drawAngel(int row, int column) {
		StdDraw.picture(column + 0.5, row + 0.5, ANGEL_PATH, 0.75, 0.75);
	}

	/**
	 * Draws a crack at the specified {@link Position}.
	 * 
	 * @param row    The row index.
	 * @param column The column index.
	 */
	private void drawCrack(int row, int column) {
		StdDraw.picture(column + 0.5, row + 0.5, CRACK_PATH, 1, 1);
	}

	/**
	 * Draws the border around the {@link Board}.
	 */
	private void drawBoarder() {
		StdDraw.setPenRadius(PEN_RADIUS);
		StdDraw.setPenColor(Color.BLACK);

		StdDraw.square(getSize() / 2.0, getSize() / 2.0, getSize() / 2.0);
		;
	}

	/**
	 * Draws the exit button on the {@link Board}.
	 */
	private void drawExitButton() {
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledRectangle(getSize(), getSize() + 0.5, 0.8, 0.3);

		Font exitFont = new Font("Arial", Font.BOLD, 30);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.setFont(exitFont);
		StdDraw.text(getSize(), getSize() + 0.4, "EXIT");
	}

	/**
	 * Displays the given text at a specified height on the board.
	 * 
	 * @param text   The text to display.
	 * @param height The height position where the text should appear.
	 */
	private void displayText(String text, double height) {
		// creates a new bold arial font of size 60.
		Font font;
		if (text.length() < 40)
			font = new Font("Arial", Font.BOLD, 30);
		else
			font = new Font("Arial", Font.BOLD, 15);

		// prints text using that font in the middle of the board.
		StdDraw.setPenColor(LETTERS);
		StdDraw.setFont(font);
		StdDraw.text(getSize() / 2.0, height, text);
	}

	/**
	 * Updates the board by redrawing the grid and elements.
	 */
	private void update() {
		// redraws grid in order to erase previous state
		drawGrid();

		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {

				if (getCell(i, j) == 'A')
					drawAngel(getSize() - 1 - i, j);
				else if (getCell(i, j) == 'B')
					drawCrack(getSize() - 1 - i, j);
			}
		}

	}

	/**
	 * Updates and displays text at the bottom of the board.
	 * 
	 * @param text The text to display.
	 */
	public void changeBotText(String text) {

		StdDraw.setPenColor(BACKGROUND);
		StdDraw.filledRectangle(getSize() / 2.0, -0.5, getSize() / 2.0 + 1, 0.35);

		displayText(text, -0.5);
		StdDraw.show();

	}

	/**
	 * Updates and displays text at the top of the board.
	 * 
	 * @param text The text to display.
	 */
	public void changeTopText(String text) {
		StdDraw.setPenColor(BACKGROUND);
		StdDraw.filledRectangle(getSize() / 2.0, getSize() + 0.5, getSize() / 3.0, 0.35);

		displayText(text, getSize() + 0.5);
		StdDraw.show();
	}

	/**
	 * Redraws and updates the board display.
	 */
	// @Override
	public void display() {
		update();
		StdDraw.show();
	}

}
