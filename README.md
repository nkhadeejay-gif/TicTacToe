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

## Screenshot
<img width="394" height="249" alt="Login Panel" src="https://github.com/user-attachments/assets/1045109c-cf58-4e63-bc08-64cab45ec717" />
<img width="324" height="172" alt="Invalid User:Password Panel" src="https://github.com/user-attachments/assets/06560b96-ed1b-429e-bae2-1200856df077" />
<img width="260" height="172" alt="Valid User   Password" src="https://github.com/user-attachments/assets/4f65fcf7-d600-40b9-ba71-dd8efb35a333" />
<img width="399" height="344" alt="Main Menu Panel" src="https://github.com/user-attachments/assets/5888a1a5-a176-47a4-ba85-2d58aebf0dd1" />
<img width="400" height="500" alt="Game Playing Panel" src="https://github.com/user-attachments/assets/64debc09-424a-4501-b59e-c7b0e7273a67" />
<img width="261" height="175" alt="Lose Panel" src="https://github.com/user-attachments/assets/cade4c3b-4c5a-4a4f-b38d-80afd7288ec9" />
<img width="260" height="172" alt="Win Panel" src="https://github.com/user-attachments/assets/b1251abc-c443-4c64-92b7-61d8e0243cdf" />
<img width="300" height="247" alt="Statistics Panel" src="https://github.com/user-attachments/assets/aa3488b8-9fbe-4072-948f-d67e29ef7041" />
<img width="502" height="298" alt="Top Scoreboard Panel" src="https://github.com/user-attachments/assets/d872935c-6c87-45dc-9b77-278c5d961164" />

## Video Link
YouTube: [https://youtu.be/XDENXZrLjqs](https://youtu.be/s4cQ3rz9QVw)
