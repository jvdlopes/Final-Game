
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Game8 extends BasicGameState {

    Background b;
    ArrayList<Will_O_Wisp> enemies;
    Image hero;
    Rectangle hitBox;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        b = new Background(8);
        enemies = new ArrayList();
        Will_O_Wisp.setGameSize(800, 600);

        for (int i = 0; i < 10; i++) {
            int ry = (int) (Math.random() * 500);
            int rx = (int) (Math.random() * 50 - 50);
            enemies.add(new Will_O_Wisp(rx, ry));
        }

        hero = new Image("images/astroid.png");
        hitBox = new Rectangle(400, 550, hero.getWidth(), hero.getHeight());
        

    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if(gameOver9.retry ==true){
            hitBox.setX(400);
            hitBox.setY(550);
            gameOver9.retry =false;
        }
        
        Input in = gc.getInput();
        int mx = gc.getInput().getMouseX();
        int my = gc.getInput().getMouseY();
        if (GameLauncher.hasRope ==true) {
            if (in.isKeyDown(Input.KEY_RIGHT)) {
                hitBox.setX(hitBox.getX() + 3);
            }
            if (in.isKeyDown(Input.KEY_LEFT)) {
                hitBox.setX(hitBox.getX() - 3);
            }
            if (in.isKeyDown(Input.KEY_UP)) {
                hitBox.setY(hitBox.getY() - 3);
            }
            if (in.isKeyDown(Input.KEY_DOWN)) {
                hitBox.setY(hitBox.getY() + 3);
            }
        } else {
            if (in.isKeyDown(Input.KEY_RIGHT)) {
                hitBox.setX(hitBox.getX() + 1);
            }
            if (in.isKeyDown(Input.KEY_LEFT)) {
                hitBox.setX(hitBox.getX() - 1);
            }
            if (in.isKeyDown(Input.KEY_UP)) {
                hitBox.setY(hitBox.getY() - 1);
            }
            if (in.isKeyDown(Input.KEY_DOWN)) {
                hitBox.setY(hitBox.getY() + 1);
            }
        }

        for (Will_O_Wisp a : enemies) {
            a.move();
        }

        for (Will_O_Wisp a : enemies) {
            if (a.hit(hitBox)) {
                enemies.remove(a);
                enemies.add(new Will_O_Wisp(a.getX() + 150, a.getY()));
                GameLauncher.lives--;
                break;
            }
        }

        if(hitBox.getY() <=0){
            sbg.enterState(10, new FadeOutTransition(), new FadeInTransition());
        }
        
        if (GameLauncher.lives <= 0) {
            /*for (Will_O_Wisp a : enemies) {
                enemies.remove(a);
            }*/
            sbg.enterState(9, new FadeOutTransition(), new FadeInTransition());
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        b.draw(g);
        hero.draw(hitBox.getX(), hitBox.getY());
        for (Will_O_Wisp enemy : enemies) {
            enemy.draw();
        }
        g.setColor(new Color(56, 25, 47));
        g.drawString("Lives: \t" + GameLauncher.lives, 10, 515);
    }

    public int getID() {
        return 8;  //this id will be different for each screen
    }

}
