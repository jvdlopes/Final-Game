
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class GameLauncher extends StateBasedGame {

    public static boolean hasRope= false;
    public static int lives = 5;
    public static int gold= 0;
    //if (GameLauncher.hasRope ==false) {GameLauncher.hasRope =true}
    public GameLauncher(String title) {
        super(title);
    }
    
    public void initStatesList(GameContainer gc) throws SlickException {
       this.addState(new startScreen());
       this.addState(new page1());
       this.addState(new page2());
       this.addState(new page3());
       this.addState(new page4());
       this.addState(new page5());
       this.addState(new page6());
       this.addState(new preGame7());
       this.addState(new Game8());
       this.addState(new gameOver9());
       this.addState(new gameWin10());
       this.addState(new page11());
       this.addState(new page12());
       this.addState(new page13());
       this.addState(new page14());
       this.addState(new page15());
       this.addState(new page16());
       this.addState(new page17());
       this.addState(new page18());
       this.addState(new page19());
       this.addState(new page20());
       this.addState(new page21());
    }

    public static void main(String args[]) throws SlickException {
        GameLauncher game = new GameLauncher("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(800, 600, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}