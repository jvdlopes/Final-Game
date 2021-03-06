

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class startScreen extends BasicGameState {
    
    Background b;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
       b= new Background(0);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException { 
        Input in = gc.getInput();
        if (in.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            GameLauncher.hasRope =false;
            GameLauncher.lives =5;
            gameOver9.retry = true;
           sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
       }
       
       //if (in.isKeyDown(Input.KEY_SPACE)){}
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       b.draw(g);
    }
    
    public int getID() {
       return 0;  //this id will be different for each screen
    }

    
}