import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class preGame22 extends BasicGameState {
    Background b;
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       b = new Background(22);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        Input in = gc.getInput();
        
        if (in.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
           sbg.enterState(23, new FadeOutTransition(), new FadeInTransition());
       }
    
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       b.draw(g);
    }
    
    public int getID() {
       return 22;  //this id will be different for each screen
    }

    
}