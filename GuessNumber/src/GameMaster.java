public class GameMaster {

    // PROPRIETIES ////
    int max;
    int nPlayer;
    int tGuesses; // total number of guesses = guesses per player * number of players
    int curGuesses;

    // CONSTRUCTOR ////
    public GameMaster(int max, int nPlayer, int nGuesses) {
        this.max = max;
        this.nPlayer = nPlayer;
        this.tGuesses = nGuesses * nPlayer;
        this.curGuesses = 0;

    }

    public void gameStart() {

        int winnerNumber = Generator.numGenerator(max); // create a random number between 0 and max

        // creates the player array and names the players
        Player[] playerArray = new Player[nPlayer];
        for (int i = 0; i < nPlayer; i++) {
            Player player = new Player("Player #" + (i+1));
            playerArray[i] = player;

        }

        System.out.println("> Welcome to the game!");

        while (curGuesses < tGuesses) {
            for (int i = 0; i < nPlayer; i++) {
                playerArray[i].setGuess(Generator.numGenerator(max));

                if (playerArray[i].getGuess() == winnerNumber) {
                    System.out.println("> " + playerArray[i].getName() +
                            "\'s turn. They guess " + playerArray[i].getGuess() + ". They win!!");
                    return;

                } else {
                    System.out.println("> " + playerArray[i].getName() +
                            "\'s turn. They guess " + playerArray[i].getGuess() + ". They got it wrong.");

                }
                curGuesses++;

            }

        }
        System.out.println("No one guessed correctly. There's no winner.");

    }

}
