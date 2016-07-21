package logic;

import model.Ball;
import model.Board;
import model.Paddle;

import static utils.Utils.DEFAULT_PADDLE_WIDTH;
import static utils.Utils.G_WIDTH;
import static utils.Utils.PADDLE_DEFAULT_SPEED;


/**
 * Created by mikkel on 21-Jul-16.
 */
public class Game {
	private final Paddle paddle;
	private final Board board;
	private final Ball ball;

	public Game() {
		this.paddle = new Paddle();
		this.board = new Board();
		this.ball = new Ball();
	}

	public Paddle getPaddle() {
		return paddle;
	}

	public double getPaddleXPos() {
		return paddle.getX();
	}

	public double getBallYPos() {
		return ball.getY();
	}

	public double getBallXPos() {
		return ball.getX();
	}

	public Board getBoard() {
		return board;
	}

	public void update(boolean leftKey, boolean rightKey) {
		// TODO update the state based on the left/rightKey is true
		boolean isLeftMovePossible = paddle.getX() >= PADDLE_DEFAULT_SPEED;
		boolean isRightMovePossible = paddle.getX() <= G_WIDTH - DEFAULT_PADDLE_WIDTH - PADDLE_DEFAULT_SPEED;
		if (leftKey && isLeftMovePossible) {
			paddle.move(-PADDLE_DEFAULT_SPEED);
		} else if (rightKey && isRightMovePossible) {
			paddle.move(PADDLE_DEFAULT_SPEED);
		}
	}

}
