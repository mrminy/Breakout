package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import logic.Game;
import model.Board;
import utils.Utils;

import java.text.DecimalFormat;

/**
 * Created by mikkel on 21-Jul-16.
 */
public class Controller {
	public Label menuTitle;
	public Canvas canvas;

	private long startTime;
	private long frameCounter;
	private double fps;
	private long frameStart;
	private double targetFps = Utils.ANIMATION_FPS;
	private double dt = 1000.0 / targetFps;
	private double accumulator = 0.0;

	private Game game;
	private boolean leftKey = false, rightKey = false;

	public void initialize() {
		final GraphicsContext gc = canvas.getGraphicsContext2D();
		game = new Game();

		addKeyHandlers();

		new AnimationTimer() {
			@Override
			public void handle(long now) {
				long currentTime = System.currentTimeMillis();
				accumulator += currentTime - frameStart;
				frameStart = currentTime;

				if (accumulator > dt) {
					// One time step in the game
					// TODO update game/logic
					game.update(leftKey, rightKey);
					accumulator -= dt;

					// Render the changes
					render(gc, game);
				}

			}
		}.start();
	}

	private void addKeyHandlers() {
		canvas.setFocusTraversable(true);
		canvas.addEventHandler(KeyEvent.KEY_PRESSED, new javafx.event.EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.LEFT) {
					leftKey = true;
				} else if (event.getCode() == KeyCode.RIGHT) {
					rightKey = true;
				} else if (event.getCode() == KeyCode.SPACE) {
					game.startStop();
				}else if(event.getCode() == KeyCode.ESCAPE){
					game.reset();
				}
			}
		});

		canvas.addEventHandler(KeyEvent.KEY_RELEASED, new javafx.event.EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.LEFT) {
					leftKey = false;
				} else if (event.getCode() == KeyCode.RIGHT) {
					rightKey = false;
				}
			}
		});
	}

	private void render(final GraphicsContext gc, final Game game) {
		gc.clearRect(0, 0, Utils.G_WIDTH, Utils.G_HEIGHT);

		gc.setFill(Color.BLACK);
		gc.fillOval(game.getBallXPos(), game.getBallYPos(), Utils.BALL_RADIUS, Utils.BALL_RADIUS);

		gc.setFill(Color.DARKCYAN);
		gc.fillRect(game.getPaddleXPos(), Utils.G_HEIGHT - Utils.PADDLE_HEIGHT * 2 - 10,
				Utils.DEFAULT_PADDLE_WIDTH, Utils.PADDLE_HEIGHT);

		gc.setFill(Color.CHOCOLATE);
		Board board = game.getBoard();
		double cellWidth = Utils.G_WIDTH / board.getCols();
		for (int r = 0; r < board.getRows(); r++) {
			for (int c = 0; c < board.getCols(); c++) {
				if (board.isCellAlive(r, c)) {
					// Draw cell
					gc.fillRect(c * cellWidth, r * Utils.DEFAULT_BOARD_CELL_HEIGHT + Utils.BOARD_TOP_MARGIN,
							cellWidth, Utils.DEFAULT_BOARD_CELL_HEIGHT);
				}
			}
		}

		// Draws fps info in top left corner
		drawFpsInfo(gc);
	}

	/**
	 * Draws the Fps information on screen
	 */
	private void drawFpsInfo(GraphicsContext gc) {
		int refreshRate = 100;
		if (frameCounter % refreshRate == 0) {
			long endTime = System.currentTimeMillis();
			fps = (1000.0 * refreshRate) / (endTime - startTime);
			startTime = endTime;
		}

		frameCounter++;

		String fpsString = "fps: " + new DecimalFormat("#").format(fps);
		gc.setFill(Color.GREEN);
		gc.fillText(fpsString, 15, 15);
	}
}
