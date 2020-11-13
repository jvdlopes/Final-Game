
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

public class Game23 extends BasicGameState {

    Background b;
    int timer, timer2;
    ArrayList<Gas> dust;
    Image hero;
    Rectangle hitBox;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        b = new Background(23);
        
        Gas.setGameSize(800, 600);
        hero = new Image("images/hero.png");
        hitBox = new Rectangle(400, 300, hero.getWidth(), hero.getHeight());
        reset();
    }

    public void reset() throws SlickException {
        dust = new ArrayList();
        timer = 0;
        timer2 = 0;
        for (int i = 0; i < 10; i++) {
            int c = (int) (Math.random() * 4);
            if (c == 1) {
                int rx = (int) (Math.random() * 75 + 50);
                int ry = (int) (Math.random() * 75 + 50);
                dust.add(new Gas(rx, ry));
            } else if (c == 2) {
                int rx = (int) (Math.random() * 650 + 75);
                int ry = (int) (Math.random() * 75 + 50);
                dust.add(new Gas(rx, ry));
            } else if (c == 3) {
                int rx = (int) (Math.random() * 75 + 50);
                int ry = (int) (Math.random() * 500 + 50);
                dust.add(new Gas(rx, ry));
            } else {
                int rx = (int) (Math.random() * 650 + 75);
                int ry = (int) (Math.random() * 500 + 50);
                dust.add(new Gas(rx, ry));
            }
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if (gameOver9.retry == true) {
            reset();
            hitBox.setX(400);
            hitBox.setY(300);
            gameOver9.retry = false;
           
        }

        Input in = gc.getInput();
        int mx = gc.getInput().getMouseX();
        int my = gc.getInput().getMouseY();

        mx = mx - (hero.getWidth() / 2);
        my = my - (hero.getHeight() / 2);

        hitBox.setX(mx);
        hitBox.setY(my);

        for (Gas gas : dust) {
            gas.move();
        }

        for (Gas gas : dust) {
            if (gas.hit(hitBox)) {
                if (mx + 150 >= 750) {
                    dust.remove(gas);
                    dust.add(new Gas(mx - 150, gas.getY()));
                } else {
                    dust.remove(gas);
                    dust.add(new Gas(mx + 150, gas.getY()));
                }
                GameLauncher.lives--;
                break;
            }
        }

        if (GameLauncher.lives > 0) {
            timer2++;
            timer++;
            if (timer == 200) {
                timer = 0;
                int c = (int) (Math.random() * 4);
                if (c == 1) {
                    int rx = (int) (Math.random() * 75 + 50);
                    int ry = (int) (Math.random() * 75 + 50);
                    dust.add(new Gas(rx, ry));
                } else if (c == 2) {
                    int rx = (int) (Math.random() * 700 + 75);
                    int ry = (int) (Math.random() * 75 + 50);
                    dust.add(new Gas(rx, ry));
                } else if (c == 3) {
                    int rx = (int) (Math.random() * 75 + 50);
                    int ry = (int) (Math.random() * 400 + 50);
                    dust.add(new Gas(rx, ry));
                } else {
                    int rx = (int) (Math.random() * 700 + 75);
                    int ry = (int) (Math.random() * 400 + 50);
                    dust.add(new Gas(rx, ry));
                }
            }
        }

        if (timer2 == 1000) {
            sbg.enterState(25, new FadeOutTransition(), new FadeInTransition());
        }

        if (GameLauncher.lives <= 0) {
            sbg.enterState(24, new FadeOutTransition(), new FadeInTransition());
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        b.draw(g);
        for (Gas gas : dust) {
            gas.draw();
        }
        g.setColor(new Color(255, 255, 255));
        g.drawString("Lives: \t" + GameLauncher.lives, 10, 515);
        hero.draw(hitBox.getX(), hitBox.getY());
    }

    public int getID() {
        return 23;  //this id will be different for each screen
    }

}
