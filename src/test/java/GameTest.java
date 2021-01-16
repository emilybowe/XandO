import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
	private Game game;

	@Test
	public void completeGameWithWinner_shouldReturnWinnerX() {
		//given
		int[][] completeGameWithWinner = {{1, 1, 1},
				{1, 2, 2},
				{2, 2, 1}};
		//when
		game = new Game(completeGameWithWinner);
		//then
		Assertions.assertEquals("The Winner is X", game.verifyGameState());
	}

	@Test
	public void completeGameWithNoWinner_shouldReturnNoWinner() {
		//given
		int[][] completeGameWithNoWinner = {{2, 1, 1},
				{1, 1, 2},
				{2, 2, 1}};
		//when
		game = new Game(completeGameWithNoWinner);
		//then
		Assertions.assertEquals("No Winner - Game Complete", game.verifyGameState());
	}

	@Test
	public void incompleteGameWithWinner_shouldReturnWinnerX() {
		//given
		int[][] incompleteGameWithWinner = {{1, 2, 0},
				{0, 1, 2},
				{0, 0, 1}};
		//when
		game = new Game(incompleteGameWithWinner);
		//then
		Assertions.assertEquals("The Winner is X", game.verifyGameState());
	}

	@Test
	public void incompleteGameWithNoWinnerYet_shouldReturnNoWinnerYet() {
		//given
		int[][] incompleteGameWithNoWinnerYet = {{1, 2, 0},
				{0, 1, 0},
				{0, 2, 0}};
		//when
		game = new Game(incompleteGameWithNoWinnerYet);
		//then
		Assertions.assertEquals("No Winner Yet - Game Incomplete", game.verifyGameState());
	}
}
