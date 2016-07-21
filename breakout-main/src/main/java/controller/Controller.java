package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import logic.Physics;
import utils.Utils;

import java.text.DecimalFormat;

/**
 * Created by mikkel on 21-Jul-16.
 */
public class Controller {
	public Label menuTitle;
	public Canvas canvas;

	private final Physics physics;

	private long startTime;
	private long frameCounter;
	private double fps;

	public Controller(Physics physics) {
		this.physics = physics;
	}

	public void initialize() {
		final GraphicsContext gc = canvas.getGraphicsContext2D();


		new AnimationTimer() {
			@Override
			public void handle(long now) {
				// TODO delta for specifying when the logic is going to be updated
				// TODO update physics/logic
				physics.update();


				render(gc);
			}
		}.start();
	}

	private void render(final GraphicsContext gc) {
		gc.clearRect(0, 0, Utils.G_WIDTH, Utils.G_HEIGHT);

		// TODO render graphics
		gc.setFill(Color.DARKCYAN);
		gc.fillRect(physics.getPaddleXPos(), Utils.G_HEIGHT - Utils.PADDLE_HEIGHT * 2 - 10,
				Utils.DEFAULT_PADDLE_WIDTH, Utils.PADDLE_HEIGHT);

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
