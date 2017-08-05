import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;


class Bullet {

    private Vector2f position = new Vector2f();
    private Vector2f target = new Vector2f();
    private double deltaX;
    private double deltaY;
    private int speed;


    Bullet(Vector2f position, Vector2f target) {
        this.position = new Vector2f(position.getX(),position.getY());
        this.target = new Vector2f(target.getX(),target.getY());
        speed = 5;
        calculateDirection();
    }

    Vector2f getPosition() {
        return position;
    }

    void update() {
        move();
    }

    private void calculateDirection() {
        double rad = Math.atan2(target.getX() - position.getX(), position.getY() - target.getY());
        deltaX = Math.sin(rad) * speed;
        deltaY = -Math.cos(rad) * speed;
    }


    private void move() {
        float x = position.getX() + (float)deltaX;
        float y = position.getY() + (float)deltaY;
        position.set(x, y);
    }


}