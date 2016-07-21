package logic;

import model.Board;
import model.Paddle;
import utils.Utils;

/**
 * Created by mikkel on 21-Jul-16.
 */
public class Game {
	private final Paddle paddle;
	private final Board board;

	public Game() {
		this.paddle = new Paddle();
		this.board = new Board();
	}

	public Paddle getPaddle() {
		return paddle;
	}

	public double getPaddleXPos() {
		return paddle.getX();
	}

	public double getPaddleYPos() {
		return paddle.getY();
	}

	public Board getBoard() {
		return board;
	}

	public void update(boolean leftKey, boolean rightKey) {
		// TODO update the state based on the left/rightKey is true
		if(leftKey){
			paddle.move(-Utils.PADDLE_DEFAULT_SPEED);
		}else if(rightKey){
			paddle.move(Utils.PADDLE_DEFAULT_SPEED);
		}
	}
}
