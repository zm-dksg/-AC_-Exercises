import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Pick a maximum number: ");
        int max = scan.nextInt();
        System.out.print("Pick the number of players: ");
        int nPlayer = scan.nextInt();
        System.out.print("Pick the number of guesses per player: ");
        int nGuesses = scan.nextInt();

        GameMaster game = new GameMaster(max,nPlayer,nGuesses); // create a new game instance
        game.gameStart();

    }

}
