# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics
## Student Information
Name: Noura Khadeeja Yuniarto

Student ID: 5026251169

Class: E
## Project Description
This project is a simple Tic-Tac-Toe game built using Java Swing.
The application includes login, game statistics, and Top 5 scorer
feature.
## Features
- Login using database
- Play Tic-Tac-Toe using Swing GUI
- Record wins, losses, draws, and score
- Display personal statistics
- Display Top 5 scorers using JTable
## Database
Database used: MySQL
## How to Run
1. Create the database.
2. Import schema.sql.
3. Open the Java project.
4. Add JDBC driver.
5. Configure DatabaseManager.java.
6. Run Main.java.
## Class Explanation
Main: The entry point of the application. It starts the program by creating and displaying the LoginFrame.

DatabaseManager: Handles the connection between the Java application and the MySQL database using JDBC. It provides a reusable method for establishing a database connection that can be used throughout the application.

Player: Represents a player object. It stores player information, including ID, username, password, wins, losses, draws, and score. The class uses getter and setter methods to access and modify player data.

PlayerService: Handles all database operations related to players. It authenticates user login, updates player statistics after each game, retrieves player information, and fetches the Top 5 scorers from the database.

GameLogic: Contains the core Tic Tac Toe game logic. It manages the game board, validates player moves, checks for winning combinations, determines draws, resets the board, and generates random computer moves.

LoginFrame: Provides the graphical login interface where users enter their username and password. It validates the login credentials using PlayerService before allowing access to the main menu

MainMenuFrame: Displays the main menu after a successful login. It allows users to start a new game, view their statistics, view the Top 5 scorers, or log out of the application.

GameFrame: Displays the Tic Tac Toe game board using Java Swing components. It manages player interactions, communicates with GameLogic to process gameplay, updates the interface, and saves the game result to the database.

StatisticsFrame: Displays the logged-in player's statistics, including the total number of wins, losses, draws, and current score retrieved from the database.

TopScorersFrame: Displays the Top 5 players ranked by score using a JTable. The leaderboard data is retrieved from the MySQL database and sorted in descending order based on player score.

## Video Link
YouTube: https://youtu.be/XDENXZrLjqs
