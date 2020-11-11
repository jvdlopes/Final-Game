

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class page1 extends BasicGameState {

    Background b;
    
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       b= new Background(1);
        System.out.println(GameLauncher.hasRope);
    }
    

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        Input in = gc.getInput();

       if (in.isKeyDown(Input.KEY_1)){sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());}
       if (in.isKeyDown(Input.KEY_2)){sbg.enterState(3, new FadeOutTransition(), new FadeInTransition());}
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       b.draw(g);
    }
    
    public int getID() {
       return 1;  //this id will be different for each screen
    }

    
}