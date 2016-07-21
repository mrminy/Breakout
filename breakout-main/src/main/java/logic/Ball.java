package logic;

import utils.Position;

import static utils.Utils.*;

/**
 * Created by mikkel on 21-Jul-16.
 */
public class Ball {
    Position position;

    //First ball of the game
    public Ball() {
        position = new Position(G_WIDTH / 2, G_HEIGHT / 3);
    }

    //starting at the paddle after losing a ball
    public Ball(double x, double y) {
        position.setX(x);
        position.setY(y);
    }

    public double getX(){return position.getX();}

    public double getY(){
        return position.getY();
    }
}
