import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

class Camera {
    private int x;
    private int y;
    private int speed;

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    Camera(){
        x = 0;
        y = 0;
        speed = 10;
    }
    void update(GameContainer gc){
        if(gc.getInput().isKeyDown(Input.KEY_D)){
            x += speed;
        }
        if(gc.getInput().isKeyDown(Input.KEY_A)){
            x -= speed;
        }
        if(gc.getInput().isKeyDown(Input.KEY_W)){
            y -= speed;
        }
        if(gc.getInput().isKeyDown(Input.KEY_S)){
            y += speed;
        }
    }
}
