import java.util.Scanner;


public class RockPaperScissors {

	public static final int HUMAN = 1;
	public static final int COMPUTER = 2;
	public static final int ROCK_LOVER = 3;

	/** {@value #DEFAULT_WINNING_SCORE} the number of wins to win the game*/
	public static final int DEFAULT_WINNING_SCORE = 2;

	public static void main(String[] args) {

		GamePlayer player1;
		GamePlayer player2;

		player1 = choosePlayerType();
		player2 = choosePlayerType();

		int winningScore = getWinningScore();// Used in Extension 1
		
		for(int i = 0; i < winningScore; i++) {
		player1.makeChoice();
		player2.makeChoice();

		showChoices(player1, player2);

		GamePlayer winner = compareChoices(player1, player2);

		printWinner(winner);
		printRecord(player1);
		printRecord(player2);
		}

		printEndGameMessage();

	}



	/**
	 * Asks for the number of wins to win the game.  If the value is less than or equal
	 * to zero, then, by default, the winning score will be {@value #DEFAULT_WINNING_SCORE}
	 * @return the number of wins to win the game
	 */
	private static int getWinningScore() {
		System.out.println("What is the winning score?");
		Scanner s1 = new Scanner(System.in);
		int input = s1.nextInt();
		

		return input;
	}

	/**
	 * Prints the record of the given <code>Player</code>
	 * @param player the player of the game
	 */
	private static void printRecord(GamePlayer player) {
		System.out.println(player);

	}

	/**
	 * Prints the winner of the round
	 * @param winner the <code>GamePlayer</code> who is the winner of the round
	 */
	private static void printWinner(GamePlayer winner) {
		if (winner == null) {
			System.out.println("Tie");
		} else {
			System.out.println(winner.getName() + " wins!!");
		}
		System.out.println();
	}

	/**
	 * Compares and returns who wins the round.  
	 * @param player1 a <code>GamePlayer</code>
	 * @param player2 a <code>GamePlayer</code>
	 * @return returns the <code>GamePlayer</code> who wins the game, <code>null</code> if there is a tie
	 */
	private static GamePlayer compareChoices(GamePlayer player1, GamePlayer player2) {
		System.out.println(player1.getChoice());
		System.out.println(player2.getChoice());
		if(player1.getChoice() == 1 && player2.getChoice() == 2) {
			player2.win();
			return player2;
		}
		if(player1.getChoice() == 1 && player2.getChoice() == 3) {
			player1.win();
			return player1;
		}
		if(player1.getChoice() == 2 && player2.getChoice() == 1) {
			player1.win();
			return player1;
		}
		if(player1.getChoice() == 2 && player2.getChoice() == 3) {
			player2.win();
			return player2;
		}
		if(player1.getChoice() == 3 && player2.getChoice() == 1) {
			player2.win();
			return player2;
		}
		if(player1.getChoice() == 3 && player2.getChoice() == 2) {
			player1.win();
			return player1;
		}
		else {
		return null;
		}
	}

	/**
	 * Prints the choices for both players
	 * @param player1 a player
	 * @param player2 a player
	 */
	private static void showChoices(GamePlayer player1, GamePlayer player2) {

		System.out.println();
		System.out.println(player1.getName() + ": " + player1.getChoiceName() + "   vs.  " + player2.getName() + ": " + player2.getChoiceName());
		System.out.println();
	}

	/**
	 * Prompts the choices and returns the types of players to play the game
	 * @return the type of player to play the game
	 */
	private static GamePlayer choosePlayerType() {
		Scanner input = new Scanner(System.in);
		int type;
		String name = "";
		GamePlayer player;

		System.out.println();
		System.out.println("Choose a type of player:");
		System.out.println("\t1. Human");
		System.out.println("\t2. Computer");
		System.out.println("\t3. Rock Lover");
		System.out.print("Make your choice: ");

		type = input.nextInt();


		if (type == HUMAN) {
			input.nextLine();	// this line of code is needed to go to the carriage return after the integer choice is chosen above
			System.out.print("What is your name: ");
			name = input.nextLine();
			player = new HumanPlayer(name);
		} else if (type == COMPUTER ){
			player = new ComputerPlayer("Skynet");			// You may change this name
		} else {
			player = new RockLoverPlayer("Bart Simpson");	// You may change this name
		}

		return player;


	}

	/**
	 * Prints a message when the game is over.
	 */
	private static void printEndGameMessage() {
		System.out.println("Game Over!");
	}


}