import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {


        // draws the game board

        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };

        printGameBoard(gameBoard);

        // begin game loop

        while (!checkIsBoardFull(gameBoard)) {

            // asks the user for input

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your move (1-9): ");
            int humanMove = scanner.nextInt();

            while (checkIsSpotFull(gameBoard, humanMove)) {
                humanMove = scanner.nextInt();
            }

            playMove(gameBoard, humanMove, 'X');

            if (checkIsBoardFull(gameBoard) || gameOver(gameBoard)) {
                printGameBoard(gameBoard);
                System.out.println("Human wins!");
                break;
            }

            // sends a randomised computer input

            int cpuMove;
            Random rand = new Random();
            cpuMove = rand.nextInt(9) + 1;

            while (checkIsSpotFull(gameBoard, cpuMove)) {
                cpuMove = rand.nextInt(9) + 1;
            }

            playMove(gameBoard, cpuMove, 'O');

            // prints gameboard after one round

            printGameBoard(gameBoard);

            if (gameOver(gameBoard)){
                System.out.println("Computer wins!");
                break;
            }

        }
    }

    /*

    Converts gameboard coordinates to index numbers 1-9

    @param gameBoard        takes the most recent gameboard
    @param move             takes the index move number
    @param player           takes X for human, O for cpu

     */

    public static void playMove(char[][] gameBoard, int move, char player){
        if (move == 1){
            gameBoard[0][0] = player;
        } else if (move == 2){
            gameBoard[0][2] = player;
        } else if (move == 3){
            gameBoard[0][4] = player;
        } else if (move == 4){
            gameBoard[2][0] = player;
        } else if (move == 5){
            gameBoard[2][2] = player;
        } else if (move == 6){
            gameBoard[2][4] = player;
        } else if (move == 7){
            gameBoard[4][0] = player;
        } else if (move == 8){
            gameBoard[4][2] = player;
        } else if (move == 9){
            gameBoard[4][4] = player;
        }
    }

    /*

    Checks if a certain spot is full.

    @param gameBoard        takes the most updated gameboard
    @return                 true if the spot is full
                            false if the spot is not full

     */

    public static boolean checkIsSpotFull(char[][] gameBoard, int move){
        boolean isFull = false;
        isFull = move == 1 && gameBoard[0][0] != ' ' ||
                move == 2 && gameBoard[0][2] != ' ' ||
                move == 3 && gameBoard[0][4] != ' ' ||
                move == 4 && gameBoard[2][0] != ' ' ||
                move == 5 && gameBoard[2][2] != ' ' ||
                move == 6 && gameBoard[2][4] != ' ' ||
                move == 7 && gameBoard[4][0] != ' ' ||
                move == 8 && gameBoard[4][2] != ' ' ||
                move == 9 && gameBoard[4][4] != ' ';
        return isFull;
    }

    /*

    Checks whether a board is full and no more moves can be played

    @param gameBoard        takes the most recent gameboard
    @return                 true if board is full
                            false if board is not full

     */

    public static boolean checkIsBoardFull(char[][] gameBoard){
        boolean isBoardFull = false;

        isBoardFull = gameBoard[0][0] != ' ' &&
                gameBoard[0][2] != ' ' &&
                gameBoard[0][4] != ' ' &&
                gameBoard[2][0] != ' ' &&
                gameBoard[2][2] != ' ' &&
                gameBoard[2][4] != ' ' &&
                gameBoard[4][0] != ' ' &&
                gameBoard[4][2] != ' ' &&
                gameBoard[4][4] != ' ';
        return isBoardFull;
    }

    /*

    Ends the game if any of the patterns are complete

    @param gameBoard            takes the most updated gameboard
    @return                     true if a pattern is made
                                false otherwise

     */
    public static boolean gameOver(char[][] gameBoard){

        if (gameBoard[0][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][4] == 'X' ||  // top diagonal
               gameBoard[0][2] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][2] == 'X' || // middle vertical
               gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X' || // middle horizontal
               gameBoard[4][0] == 'X' && gameBoard[4][2] == 'X' && gameBoard[4][4] == 'X' || // bottom horizontal
               gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X' || // top horizontal
               gameBoard[0][0] == 'X' && gameBoard[2][0] == 'X' && gameBoard[4][0] == 'X' || // left vertical
               gameBoard[0][4] == 'X' && gameBoard[2][4] == 'X' && gameBoard[4][4] == 'X' || // right vertical
               gameBoard[0][4] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][0] == 'X') // right diagonal
                 {
            return true;

        } else if (gameBoard[0][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][4] == 'O' || // top diagonal
                gameBoard[0][2] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][2] == 'O' || // middle vertical
                gameBoard[2][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2][4] == 'O' || // middle horizontal
                gameBoard[4][0] == 'O' && gameBoard[4][2] == 'O' && gameBoard[4][4] == 'O' || // bottom horizontal
                gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O' || // top horizontal
                gameBoard[0][0] == 'O' && gameBoard[2][0] == 'O' && gameBoard[4][0] == 'O' || // left vertical
                gameBoard[0][4] == 'O' && gameBoard[2][4] == 'O' && gameBoard[4][4] == 'O' || // right vertical
                gameBoard[0][4] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][0] == 'O') // right diagonal
        {
            return true;

        } else {

            return false;

        }
    }

    /*

    Prints the gameboard

    @param gameBoard       reads through the most updated gameboard

     */
    public static void printGameBoard(char[][] gameBoard){
        for (char[] row: gameBoard){
            for (char col: row){
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
