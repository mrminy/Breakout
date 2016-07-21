package logic;

/**
 * Created by mikkel on 21-Jul-16.
 */
public class Physics {
	private final Paddle paddle;
	private final Board board;

	public Physics(Paddle paddle, Board board) {
		this.paddle = paddle;
		this.board = board;
	}

	public Paddle getPaddle() {
		return paddle;
	}

	public double getPaddleXPos(){
		return paddle.getX();
	}

	public double getPaddleYPos(){
		return paddle.getY();
	}

	public Board getBoard() {
		return board;
	}

	public void update(){

	}
}
