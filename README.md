# AngelsVsDemons

<h2>Overview</h2>

Angels vs. Demons is a game that pits celestial and infernal forces against each other in an epic battle. Players can choose between angels and demons, each with unique abilities and strategies.
The hw2 package contains classes for an Angel and Devil game implementation.
<p>
This package implements a game where an Angel player tries to reach the edge of the board
while a Devil player tries to block the Angel's path by breaking squares on the board.
The package includes both human-controlled and computer-controlled player classes.
</p>

Key Components:
<ul>
  <li> <a href="https://github.com/npomiloridis/AngelsVsDemons/blob/main/AngelsVsDemons.java">AngelsVsDemons</a> - The main class from which this game is run.</li>
  <li><a href="https://github.com/npomiloridis/AngelsVsDemons/blob/main/Game.java">Game</a> - Manages the overall game flow</li>
  <li><a href="https://github.com/npomiloridis/AngelsVsDemons/blob/main/Player.java">Player</a> - Abstract base class for all player types</li>
  <li><a href="https://github.com/npomiloridis/AngelsVsDemons/blob/main/Angel.java">Angel</a> - Represents the Angel player who tries to reach the edge</li>
  <li><a href="https://github.com/npomiloridis/AngelsVsDemons/blob/main/Devil.java">Devil</a> - Represents the Devil player who breaks squares</li>
  <li><a href="https://github.com/npomiloridis/AngelsVsDemons/blob/main/ComputerAngel.java">ComputerAngel</a> - AI implementation of the Angel player</li>
  <li><a href="https://github.com/npomiloridis/AngelsVsDemons/blob/main/ComputerDevil.java">ComputerDevil</a> - AI implementation of the Devil player</li>
  <li><a href="https://github.com/npomiloridis/AngelsVsDemons/blob/main/Board.java">Board</a> - Representation of the board of the game</li>
  <li><a href="https://github.com/npomiloridis/AngelsVsDemons/blob/main/GraphicBoard.java">GraphicBoard</a> - Graphical representation of the game board</li>
  <li><a href="https://github.com/npomiloridis/AngelsVsDemons/blob/main/Position.java">Position</a> - Utility class for handling board positions</li>
  <li><a href="https://github.com/npomiloridis/AngelsVsDemons/blob/main/Cell.java">Cell</a> - Utility class for each cell in the board</li>
</ul>

Game Rules:
<ul>
  <li>The Angel has a power value that determines how many squares it can move in a turn</li>
  <li>The Angel wins by reaching any edge of the board</li>
  <li>The Devil breaks one empty square per turn</li>
  <li>The Devil wins if the Angel has no valid moves</li>
</ul>

Compilation Commands: 
<ul>
	<li>javac -cp .:algs4.jar hw2/*.java  (Linux)</li>
 	<li>javac -cp .;algs4.jar hw2/*.java  (Windows)</li>
</ul>
 
Execution Commands:
<ul>
	<li>java -cp .:algs4.jar hw2.AngelsVsDemons  (Linux)</li>
	<li>java -cp .;algs4.jar hw2.AngelsVsDemons  (Windows)</li>
</ul>

Note: Files "angel.png" and "crack.png" must be placed under the same directory as the package.
<ul>
	<li>Parent Directory</li>
	<ul>
		<li>hw2</li>
		<ul>
			<li>Enter java files here.</li>
		</ul>
		<li>algs4.jar</li>
		<li>angel.png</li>
		<li>crack.png</li>
  </ul>
</ul>

Author: Nikolas Pomiloridis<br>
Version: 1.0<br>
Since: 22/03/2025<br>
