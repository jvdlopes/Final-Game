
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
    
    public boolean hit(Rectangle x){
        if(hitbox.intersects(x)) return true;
        else return false;
    }
    
    public void move(){
        hitbox.setX(hitbox.getX() + 5);
        
        //when we hit a side
        if(hitbox.getX() > GAME_WIDTH + image.getWidth()){
            hitbox.setX((int)(Math.random() * 100 - 25));
            hitbox.setY((int)(Math.random() * 500));
        }
    }
    
    public int getY(){
        return (int)hitbox.getY();
    }
    
    public int getX(){
        return (int)hitbox.getX();
    }
    
    public void draw(){
        image.draw(hitbox.getX(), hitbox.getY());
    }    
}
