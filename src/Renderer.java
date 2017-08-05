import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

import java.util.List;

class Renderer {

    void render(Vector2f player, Graphics g, Camera cam, List<Bullet> bullets, GameContainer gc) throws SlickException{
        renderPlayer(g, cam, player);
        renderBullets(g, cam, bullets);
        renderInfo(g, cam, player, gc);
    }

    private void renderPlayer(Graphics g, Camera cam, Vector2f player){
        Shape shape = new Rectangle(player.getX() - cam.getX(),player.getY() - cam.getY(), 20,20);
        g.setColor(Color.green);
        g.draw(shape);
    }

    private void renderBullets(Graphics g, Camera cam, List<Bullet> bullets) throws SlickException{
        for (Bullet bullet : bullets) {
            g.setColor(Color.magenta);
            g.fillRect(bullet.getPosition().getX() - cam.getX(), bullet.getPosition().getY() - cam.getY(), 2, 2);
        }
    }

    private void renderInfo(Graphics g, Camera cam, Vector2f player, GameContainer gc){
        g.setColor(Color.white);
        g.drawString("Camera pos:" + cam.getX() + " " + cam.getY(),10,25);
        g.drawString("Player pos:" + player.getX() + " " + player.getY(),10,40);
        g.drawString("AMouse pos:" + gc.getInput().getAbsoluteMouseX() + " " + gc.getInput().getAbsoluteMouseY(),10,55);
    }



}
