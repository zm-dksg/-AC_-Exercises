public class Player {

    // PROPRIETIES ////
    private String name;
    private int guess;

    // CONSTRUCTOR ////
    public Player(String name) {
        this.name = name;
    }

    // GETTERS && SETTERS ////
    public String getName() { return this.name; }

    public void setGuess(int num) { this.guess = num; }
    public int getGuess() { return this.guess; }

}
