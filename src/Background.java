
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;

public class Background {

    TrueTypeFont ttf = new TrueTypeFont(new java.awt.Font("Arial", 1, 14), true);
    Color BoxColor = new Color(136,158,50);
    private Image image;
    Rectangle textbox;
    private int id;
    private String[] maps = {"Dragon_Slayer_Longsword", "map(1)", "map(1)", "map(1)","map(1)","map(1)"};//,"","","","",""};
    private String[][] text = {
        {"Click the mouse to start"},
        {"You stand at the base of the giant mound called Dragon Barrow.","It is said to have a magical blade in its depths,","one that was used to fell the adult dragon that now lays buried before you.","After climbing to the top you notice some white rocks jutting out."},
        {"You search around the mound but aren't able to discover much."},
        {"You go from rock to rock inspecting them,", "eventually you make it to a rock that seems to have an area bellow it"},
        {"You have fallen in a ptifall trap! Get to the top in order to survive"}, 
        {""},
        {""},
        {""},
        {""},
        {""},
        {""}
    };
    private String[][] options = {
        {""},
        {"Press 1 to investigate the surroding area", "Press 2 to investigate the white rocks"},
        {"Press 1 to go back"},
        {"Press 1 to try and topple the rock", "Press 2 to go back"},
        {"click to start your climb."},
        {""},
        {""},
        {""},
        {""},
        {""},
        {""}
    };

    public Background(int x) throws SlickException {
        id = x;
        textbox = new Rectangle(0, 500,800, 100);
        image = new Image("images/" + maps[id] + ".png");
       
    }

    public void draw(Graphics g) {
        image.draw(0, 0);
        g.setColor(BoxColor);
        g.fill(textbox);
        for (int i = 0; i < text[getId()].length; i++) {
            ttf.drawString(10,(515 + (i * 20)),text[getId()][i],new Color(56, 25, 47));
        }
        
        for (int i = 0; i < options[getId()].length; i++) {
            ttf.drawString(500,(515 + (i * 20)),options[getId()][i],new Color(55, 36, 76));
        }
    }
    
    public int getId(){
        return id;
    }
}
