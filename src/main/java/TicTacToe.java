import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                              {'-', '+', '-', '+', '-'},
                              {' ', '|', ' ', '|', ' '},
                              {'-', '+', '-', '+', '-'},
                              {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        Scanner scanner = new Scanner(System.in);

        while (!boardFull(gameBoard)) {
            int humanMove;
            int cpuMove;
            System.out.println("Enter your move: ");
            humanMove = scanner.nextInt();

            playPiece(gameBoard, humanMove, "Human");

            Random rand = new Random();
            cpuMove = rand.nextInt(9) + 1;
            while (humanMove == cpuMove) {
                cpuMove = rand.nextInt();
            }

            playPiece(gameBoard, cpuMove, "CPU");

            printGameBoard(gameBoard);
        }

    }

    public static void playPiece(char[][] gameBoard, int move, String player){

        char playerInput = ' ';

        if (player.equals("Human")) {
            playerInput = 'X';
        } else if (player.equals("CPU")){
            playerInput = 'O';
        }

        switch (move) {
            case 1:
                gameBoard[0][0] = playerInput;
                break;
            case 2:
                gameBoard[0][2] = playerInput;
                break;
            case 3:
                gameBoard[0][4] = playerInput;
                break;
            case 4:
                gameBoard[2][0] = playerInput;
                break;
            case 5:
                gameBoard[2][2] = playerInput;
                break;
            case 6:
                gameBoard[2][4] = playerInput;
                break;
            case 7:
                gameBoard[4][0] = playerInput;
                break;
            case 8:
                gameBoard[4][2] = playerInput;
                break;
            case 9:
                gameBoard[4][4] = playerInput;
                break;
            default:
                break;
        }
    }

    public static void printGameBoard(char[][] gameBoard){
        for (char[] row: gameBoard){
            for (char col: row){
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static boolean boardFull(char[][] gameBoard){
        boolean isFull = false;
        for (char[] row: gameBoard) {
            for (char col : row) {
                if (col != ' ') {
                    isFull = true;
                } else {
                    isFull = false;
                }
            }
        }
        return isFull;
    }
}
