
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Will_O_Wisp {
    private Image image;
    Rectangle hitbox;
    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;
    
    public Will_O_Wisp(int x, int y) throws SlickException {
        image = new Image("images/astroid.png");
        hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
        
    }
    
    public Rectangle getHitBox(){
        return hitbox;
    }
    
    public static void setGameSize(int x, int y){
        GAME_HEIGHT=y;
        GAME_WIDTH=x;
    }
    
    public boolean hit(int x, int y){
        if(hitbox.contains(x, y)) return true;
        else return false;
    }
    
    public void move(){
        hitbox.setX(hitbox.getX() + 3);
        
        //bounce when we hit a side
        if(hitbox.getX() > GAME_WIDTH + image.getWidth()){
            hitbox.setX(-1 - image.getWidth());
            hitbox.setY((int)(Math.random() * 500));
        }
    }
    
    public void draw(){
        image.draw(hitbox.getX(), hitbox.getY());
    }    
}
