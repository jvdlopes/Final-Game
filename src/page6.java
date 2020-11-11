import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.HorizontalSplitTransition;
import org.newdawn.slick.state.transition.VerticalSplitTransition;

public class page6 extends BasicGameState {
    Background b;
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       b = new Background(6);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        Input in = gc.getInput();
        
        if (in.isMousePressed(Input.MOUSE_LEFT_BUTTON))
           sbg.enterState(7, new HorizontalSplitTransition(), new VerticalSplitTransition());
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       b.draw(g);
    }
    
    public int getID() {
       return 6;  //this id will be different for each screen
    }

    
}