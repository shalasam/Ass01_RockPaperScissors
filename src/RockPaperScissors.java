import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            // Get move choice from playerA
            String playerA = getPlayerMove(scanner, "Player A");

            // Get move choice from playerB
            String playerB = getPlayerMove(scanner, "Player B");

            // Display the results
            displayResults(playerA, playerB);

            // Prompt the user to play again
            System.out.print("\nDo you want to play again? (Y/N): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("y");
        }

        // Close the scanner
        scanner.close();
    }

    private static String getPlayerMove(Scanner scanner, String player) {
        String move;
        do {
            System.out.print(player + ", enter your move (R/P/S): ");
            move = scanner.next().toUpperCase();

            // Validate the move
            if (!move.equals("R") && !move.equals("P") && !move.equals("S")) {
                System.out.println("Invalid move. Please enter R, P, or S.");
            }
        } while (!move.equals("R") && !move.equals("P") && !move.equals("S"));

        return move;
    }

    private static void displayResults(String playerA, String playerB) {
        System.out.println("\nResults:");
        System.out.println("Player A chose: " + playerA);
        System.out.println("Player B chose: " + playerB);

        // Determine the winner
        if (playerA.equals(playerB)) {
            System.out.println("It's a Tie!");
        } else if ((playerA.equals("R") && playerB.equals("S")) ||
                (playerA.equals("P") && playerB.equals("R")) ||
                (playerA.equals("S") && playerB.equals("P"))) {
            System.out.println("Player A wins!");
        } else {
            System.out.println("Player B wins!");
        }
    }
}