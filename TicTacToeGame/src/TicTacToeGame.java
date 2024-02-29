import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        char[][] gameBoard = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};

        printBoard(gameBoard);

        while (true) {
            playerMove(gameBoard, inputScanner);
            if (isGameCompleted(gameBoard)) {
                break;
            }
            printBoard(gameBoard);

            computerMove(gameBoard);
            if (isGameCompleted(gameBoard)) {
                break;
            }
            printBoard(gameBoard);
        }
        inputScanner.close();
    }

    private static void displayBoard(char[][] gameBoard) {
        System.out.println(gameBoard[0][0] + "|" +  gameBoard[0][1] + "|" +  gameBoard[0][2] );
        System.out.println("-+-+-");
        System.out.println(gameBoard[1][0] + "|" +  gameBoard[1][1] + "|" +  gameBoard[1][2] );
        System.out.println("-+-+-");
        System.out.println(gameBoard[2][0] + "|" +  gameBoard[2][1] + "|" +  gameBoard[2][2] );
    }

    // ... (rest of the code remains the same)

    private static void printBoard(char[][] gameBoard) {
        System.out.println(gameBoard[0][0] + "|" +  gameBoard[0][1] + "|" +  gameBoard[0][2] );
        System.out.println("-+-+-");
        System.out.println(gameBoard[1][0] + "|" +  gameBoard[1][1] + "|" +  gameBoard[1][2] );
        System.out.println("-+-+-");
        System.out.println(gameBoard[2][0] + "|" +  gameBoard[2][1] + "|" +  gameBoard[2][2] );
    }


    private static boolean isGameCompleted(char[][] gameBoard) {

        if (hasPlayerWon(gameBoard, 'X')) {
            displayBoard(gameBoard);
            System.out.println("Player wins!");
            return true;
        }

        if (hasPlayerWon(gameBoard, 'O')) {
            displayBoard(gameBoard);
            System.out.println("Computer wins!");
            return true;
        }

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        displayBoard(gameBoard);
        System.out.println("The game ended in a tie!");
        return true;
    }

    private static boolean hasPlayerWon(char[][] gameBoard, char symbol) {
        if ((gameBoard[0][0] == symbol && gameBoard[0][1] == symbol && gameBoard[0][2] == symbol) ||
                (gameBoard[1][0] == symbol && gameBoard[1][1] == symbol && gameBoard[1][2] == symbol) ||
                (gameBoard[2][0] == symbol && gameBoard[2][1] == symbol && gameBoard[2][2] == symbol) ||

                (gameBoard[0][0] == symbol && gameBoard[1][0] == symbol && gameBoard[2][0] == symbol) ||
                (gameBoard[0][1] == symbol && gameBoard[1][1] == symbol && gameBoard[2][1] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][2] == symbol && gameBoard[2][2] == symbol) ||

                (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    private static void computerMove(char[][] gameBoard) {
        Random randomGenerator = new Random();
        int computerMove;
        while (true) {
            computerMove = randomGenerator.nextInt(9) + 1;
            if (isValidMove(gameBoard, Integer.toString(computerMove))) {
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        placeMove(gameBoard, Integer.toString(computerMove), 'O');
    }

    private static boolean isValidMove(char[][] gameBoard, String position) {
        switch (position) {
            case "1":
                return (gameBoard[0][0] == ' ');
            case "2":
                return (gameBoard[0][1] == ' ');
            case "3":
                return (gameBoard[0][2] == ' ');
            case "4":
                return (gameBoard[1][0] == ' ');
            case "5":
                return (gameBoard[1][1] == ' ');
            case "6":
                return (gameBoard[1][2] == ' ');
            case "7":
                return (gameBoard[2][0] == ' ');
            case "8":
                return (gameBoard[2][1] == ' ');
            case "9":
                return (gameBoard[2][2] == ' ');
            default:
                return false;
        }
    }

    private static void playerMove(char[][] gameBoard, Scanner inputScanner) {
        String userInput;
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            userInput = inputScanner.nextLine();
            if (isValidMove(gameBoard, userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        placeMove(gameBoard, userInput, 'X');
    }

    private static void placeMove(char[][] gameBoard, String position, char symbol) {
        switch (position) {
            case "1":
                gameBoard[0][0] = symbol;
                break;
            case "2":
                gameBoard[0][1] = symbol;
                break;
            case "3":
                gameBoard[0][2] = symbol;
                break;
            case "4":
                gameBoard[1][0] = symbol;
                break;
            case "5":
                gameBoard[1][1] = symbol;
                break;
            case "6":
                gameBoard[1][2] = symbol;
                break;
            case "7":
                gameBoard[2][0] = symbol;
                break;
            case "8":
                gameBoard[2][1] = symbol;
                break;
            case "9":
                gameBoard[2][2] = symbol;
                break;
            default:
                System.out.println(":(");
        }
    }
}