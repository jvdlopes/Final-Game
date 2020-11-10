import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;



public class Game extends BasicGameState {
    Background b;
    ArrayList<Will_O_Wisp> enemies;
    int lives =5;
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       b = new Background(5);
       enemies = new ArrayList();
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       b.draw(g);
    }
    
    public int getID() {
       return 6;  //this id will be different for each screen
    }

    
}