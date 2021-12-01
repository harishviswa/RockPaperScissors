
public abstract class GamePlayer {

public static final int ROCK = 1;
public static final int PAPER = 2;
public static final int SCISSORS = 3;
	
private String name;
private String choiceName;
private int choice;
private int wins;
	
/**
 * Creates a player with the given playerName 
 * with no wins
 * @param playerName the name of the player
 */
public GamePlayer(String playerName) {
	name = playerName;
	wins = 0;
}
	
/**
 * Returns the name of the player
 * @return the name of the player
 */
public String getName() {
	return name;
}

/**
 * Returns the player's choice of weapon for the game as an integer
 * @return the player's choice of weapon for the game as an integer
 */
public int getChoice() {
	return choice;
}

/**
 * Returns the name of the player's choice of weapon 
 * @return the name of the player's choice of weapon
 */
public String getChoiceName() {
	return choiceName;
}
	
/**
 * Sets the player's choice of weapon
 * @param playerChoice the player's choice of weapon
 */
public void setChoice(int playerChoice) {
	choice = playerChoice;
	if(choice == 1) {
		choiceName = "Rock";
	}
	if(choice == 2) {
		choiceName = "Paper";
	}
	if(choice == 3) {
		choiceName = "Scissors";
	}
}
	
/**
 * The player chooses their weapon
 */
public abstract void makeChoice();
	

/**
 * Add one to the total number of wins
 */
public void win() {
	wins++;
}
	
/**
 * Returns the number of wins
 * @return the number of wins
 */
public int getWins() {
	return wins;
}

@Override
public String toString() {	
	return getName() + " picked " + getChoiceName() + " and has won " + getWins() + " times.";
}
}
