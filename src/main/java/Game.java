import java.util.ArrayList;
import java.util.List;

public class Game {

	private final List<Integer> gameState = new ArrayList<>();

	private static final int EMPTY_VALUE = 0;
	private static final int X = 1;
	private static final int O = 2;
	private static final int REQUIRED_BOARD_SIZE = 9;

	private final int x0y0;
	private final int x0y1;
	private final int x0y2;
	private final int x1y0;
	private final int x1y1;
	private final int x1y2;
	private final int x2y0;
	private final int x2y1;
	private final int x2y2;

	public Game(int[][] newGameDetails) {
		this.x0y0 = newGameDetails[0][0];
		this.x0y1 = newGameDetails[0][1];
		this.x0y2 = newGameDetails[0][2];
		this.x1y0 = newGameDetails[1][0];
		this.x1y1 = newGameDetails[1][1];
		this.x1y2 = newGameDetails[1][2];
		this.x2y0 = newGameDetails[2][0];
		this.x2y1 = newGameDetails[2][1];
		this.x2y2 = newGameDetails[2][2];
	}

	public String verifyGameState() {
		setup();
		if(validateGameState()) {
			if(findWinner() != EMPTY_VALUE) {
				if(findWinner() == X) {
					return "The Winner is X";
				}else if(findWinner() == O) {
					return "The Winner is O";
				}
			}
			if (checkGameComplete()) {
				return "No Winner - Game Complete";
			}else {
				return "No Winner Yet - Game Incomplete";
			}
		}else return "Invalid Values";
	}

	private void setup() {
		gameState.add(x0y0);
		gameState.add(x0y1);
		gameState.add(x0y2);
		gameState.add(x1y0);
		gameState.add(x1y1);
		gameState.add(x1y2);
		gameState.add(x2y0);
		gameState.add(x2y1);
		gameState.add(x2y2);
	}

	private boolean validateGameState() {
		return validateBoardSize();
	}

	private boolean validateBoardSize() {
		return gameState.size() == REQUIRED_BOARD_SIZE;
	}

	private int findWinner() {
		if(findWinnerHorizontal(X)) {
			return X;
		} else if(findWinnerHorizontal(O)) {
			return O;
		} else if(findWinnerVertical(X)) {
			return X;
		} else if(findWinnerVertical(O)) {
			return O;
		} else if(findWinnerDiagonal(X)) {
			return X;
		} else if(findWinnerDiagonal(O)) {
			return O;
		} else return EMPTY_VALUE;
	}

	private boolean findWinnerHorizontal(int xOrO) {
		return ((xOrO == x0y0 && x0y0 == x0y1 && x0y1  == x0y2)||
				(xOrO == x1y0 && x1y0 == x1y1 && x1y1  == x1y2)||
				(xOrO == x2y0 && x2y0 == x2y1 && x2y1  == x2y2));
	}

	private boolean findWinnerVertical(int xOrO) {
		return ((xOrO == x0y0 && x0y0 == x1y0 && x1y0  == x2y0)||
				(xOrO == x0y1 && x0y1 == x1y1 && x1y1  == x2y1)||
				(xOrO == x0y2 && x0y2 == x1y2 && x1y2  == x2y2));
	}

	private boolean findWinnerDiagonal(int xOrO) {
		return ((xOrO == x0y0 && x0y0 == x1y1 && x1y1  == x2y2)||
				(xOrO == x2y0 && x2y0 == x1y1 && x1y1  == x0y2));
	}

	private boolean checkGameComplete() {
		return gameState.stream()
				.noneMatch(currentGameMark -> currentGameMark.equals(EMPTY_VALUE));
	}
}

