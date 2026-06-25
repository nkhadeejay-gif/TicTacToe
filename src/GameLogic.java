import java.util.Random;

public class GameLogic {

    private char[] board;

    public GameLogic() {
        board = new char[9];
        resetBoard();
    }

    // Reset the board
    public void resetBoard() {

        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }

    }

    // Player or computer makes a move
    public boolean makeMove(int index, char symbol) {

        if (index < 0 || index > 8)
            return false;

        if (board[index] != ' ')
            return false;

        board[index] = symbol;

        return true;

    }

    // Check winner
    public boolean checkWinner(char symbol) {

        int[][] win = {
                {0,1,2},
                {3,4,5},
                {6,7,8},

                {0,3,6},
                {1,4,7},
                {2,5,8},

                {0,4,8},
                {2,4,6}
        };

        for (int i = 0; i < win.length; i++) {

            int a = win[i][0];
            int b = win[i][1];
            int c = win[i][2];

            if (board[a] == symbol &&
                    board[b] == symbol &&
                    board[c] == symbol) {

                return true;

            }

        }

        return false;

    }

    // Check draw
    public boolean isDraw() {

        for (int i = 0; i < board.length; i++) {

            if (board[i] == ' ')
                return false;

        }

        return true;

    }

    // Random computer move
    public int computerMove() {

        Random random = new Random();

        while (true) {

            int move = random.nextInt(9);

            if (board[move] == ' ') {

                board[move] = 'O';

                return move;

            }

        }

    }

    public char[] getBoard() {
        return board;
    }
}