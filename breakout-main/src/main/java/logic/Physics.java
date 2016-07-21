package logic;

/**
 * Created by mikkel on 21-Jul-16.
 */
public class Physics {
	private final Paddle paddle;
	private final Board board;

	public Physics() {
		this.paddle = new Paddle();
		this.board = new Board();
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
