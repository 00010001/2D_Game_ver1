import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

import java.util.List;

class Player {

    private Vector2f position;
    private int speed;

    Vector2f getPosition() {
        return position;
    }

    Player() {
        position = new Vector2f(200,200);
        speed = 5;
    }

    void update(GameContainer gc, List<Bullet> bulletList, Camera cam) {
        updateMovement(gc);
        if(gc.getInput().isMousePressed(0)){
            Vector2f target = new Vector2f(gc.getInput().getAbsoluteMouseX()+cam.getX(),gc.getInput().getAbsoluteMouseY()+cam.getY());
            Vector2f origin = new Vector2f(position.getX()+10,position.getY()+10);
            System.out.println("Mouse: X: "+ target.getX() + "Y:" + target.getY());
            System.out.println("Player: X: "+ origin.getX() + "Y:" + origin.getY());

            bulletList.add(new Bullet(origin,target));
        }

    }
    private void updateMovement(GameContainer gc){
        if(gc.getInput().isKeyDown(Input.KEY_RIGHT)){
            position.set(position.getX()+speed,position.getY());
        }
        if(gc.getInput().isKeyDown(Input.KEY_LEFT)){
            position.set(position.getX()-speed,position.getY());
        }
        if(gc.getInput().isKeyDown(Input.KEY_UP)){
            position.set(position.getX(),position.getY()-speed);
        }
        if(gc.getInput().isKeyDown(Input.KEY_DOWN)){
            position.set(position.getX(),position.getY()+speed);
        }
    }
}
