import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;


public class Application extends BasicGame {
    private Camera cam;
    private Renderer renderer;
    private Player player;
    private List<Bullet> bullets;

    private Application(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        cam = new Camera();
        renderer = new Renderer();
        player = new Player();
        bullets = new ArrayList<>();
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        cam.update(gc);
        player.update(gc, bullets, cam);
        for (Bullet bullet : bullets) {
            bullet.update();
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        renderer.render(player.getPosition(), g, cam, bullets, gc);
    }

    public static void main(String[] args) throws SlickException {

        AppGameContainer app;
        app = new AppGameContainer(new Application("Simple Slick Game"));
        app.setDisplayMode(1024, 768, false);
        app.setTargetFrameRate(60);
        app.start();

    }
}
