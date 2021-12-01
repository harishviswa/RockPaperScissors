import java.util.Scanner;

public class HumanPlayer extends GamePlayer{
	/**
	 * Constructs a new HumanPlayer that represents human playing 
	 * with the given playerName
	 * @param playerName the name of the player
	 */
	public HumanPlayer(String playerName) {
		super(playerName);
	}

	@Override
	/**
	 * The player will be prompted to make a choice of weapons
	 */
	public void makeChoice() {
		System.out.println("1. Rock");
		System.out.println("2. Paper");
		System.out.println("3. Scissors");
		System.out.println("Make your choice: ");
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		setChoice(input);
	}

}
