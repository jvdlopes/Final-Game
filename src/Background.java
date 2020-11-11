
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
    private String[] maps = {"Dragon_Slayer_Longsword", "map(1)", "map(1)", "map(1)","Astroid","Astroid","Astroid","Astroid","Astroid","Astroid","Astroid","grass","grass","grass","grass"};
    private String[][] text = {
        {"Click the mouse to start"},
        {"You stand at the base of the giant mound called Dragon Barrow.","It is said to have a magical blade in its depths,","one that was used to fell the adult dragon that now lays buried before you.","After climbing to the top you notice some white rocks jutting out."},
        {"You search around the mound but aren't able to discover","much in the ways of an entrance. Although, you are able to find an", "abnormal lumb in the ground. After digging up the lump you discover that it is some sort contraption","similar to rope but with 4 heavy hooks on one end"},
        {"You go from rock to rock inspecting them,", "eventually you make it to a rock that seems to have an area bellow it"},
        {"You push with all your might and finally tip the rock over.", "Doing so reveals a decrepit set of stone stairs leading into", "the blackness of the underground"}, 
        {"You descend down the stairs with a gleam of determination in your ", "eye, once at the bottom you find yourself in a circular room with ", "two tunnels. The tunnel in front of you is dark and reeks of death and decay,", "while the tunnel to your right has three faint lights seemingly dancing around a chest"},
        {"You start down the narrow tunnel.", "As you approach the alcove, the lights seem more and more lively,", "this continues until they are almost within arms reach.", "You that the lights are not actually lights but instead Will-o'-wisps!"},
        {"You realization comes too late, as suddenly the floor beneath you", "gives way! You just fell into a pitfall trap!","The wisps, waiting for this, lunge at you to try and finish you off.", "You must climb to save your life!"},
        {""},
        {"As the wisps shock you repeatedly, you loose your grip and fall back","to the floor.","With not enough energy left to try again, you lie there motionless..."},
        {"You make it the top of the trap and get onto the saftey of","solid ground once more. You turn around to exact your revenge", "on the fae that tried to kill you, but they all disappeared."},
        {"Begrudgingly you move onwards into the small alclove.","There doesn't seem to be much in it except for a rotting", "wooden chest set on one side"},
        {"You carefully search the room and the chest but don't find", "anything that resembles a chest"},
        {""},
        {""},
    };
    private String[][] options = {
        {""},
        {"Press 1 to investigate the surroding area", "Press 2 to investigate the white rocks"},
        {"Press 1 to pick up the contraption", "press 2 to leave it"},
        {"Press 1 to try and topple the rock", "Press 2 to go back"},
        {"Click to continue"},
        {"Press 1 to investigate the front tunnel", "Press 2 to investigate the dancing lights"},
        {"Click to continue"},
        {"Click to start your climb."},
        {""},
        {"Press 1 to try the climb again","Press 2 to try from the begining"},
        {"Click to continue"},
        {"Press 1 to open the chest","Press 2 to search the rooms for traps"},
        {"Press 1 to open the chest"},
        {""},
        {""},
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
        if(id ==7 && GameLauncher.hasRope==true){
            ttf.drawString(500,(515),"Click to throw your contraption",new Color(55, 36, 76));
            ttf.drawString(500,(535),"(which you have named a grapling hook)",new Color(55, 36, 76));
            ttf.drawString(500,(555),"to try and climb up.",new Color(55, 36, 76));
        }
        else
            for (int i = 0; i < options[getId()].length; i++) {
                ttf.drawString(500,(515 + (i * 20)),options[getId()][i],new Color(55, 36, 76));
            }
    }
    
    public int getId(){
        return id;
    }
}
