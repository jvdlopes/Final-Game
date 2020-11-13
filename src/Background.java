
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;

public class Background {

    TrueTypeFont ttf = new TrueTypeFont(new java.awt.Font("Arial", 1, 14), true);
    Color BoxColor = new Color(136, 158, 50);
    private Image image;
    Rectangle textbox;
    private int id;
    private String[] maps = {"Dragon_Slayer_Longsword", "map(1)", "map(2)", "map(3)", "map(4)", "map(6)", "mistake", "map(7)", "pitfall", "game_over", "map(10)", "map(11)", "map(12)", "map(13)", "map(14)", "map(15)", "map(16)", "map(17)", "map(18)", "map(19)", "map(20)", "win","map(23)","floor","game_over","map(25)"};
    private String[][] text = {
        {"Click the mouse to start"},
        {"You stand at the base of the giant mound called Dragon Barrow.", "It is said to have a magical blade in its depths,", "one that was used to fell the adult dragon that now lays buried before you.", "After climbing to the top you notice some white rocks jutting out."},
        {"You search around the mound but aren't able to discover", "much in the ways of an entrance. Although, you are able to find an", "abnormal lumb in the ground. After digging up the lump you discover that it is some sort contraption", "similar to rope but with 4 heavy hooks on one end"},
        {"You go from rock to rock inspecting them,", "eventually you make it to a rock that seems to have an area bellow it"},
        {"You push with all your might and finally tip the rock over.", "Doing so reveals a decrepit set of stone stairs leading into", "the blackness of the underground"},
        {"You descend down the stairs with a gleam of determination in your ", "eye, once at the bottom you find yourself in a circular room with ", "two tunnels. The tunnel in front of you is dark and reeks of death and decay,", "while the tunnel to your right has three faint lights seemingly dancing around a chest"},
        {"You start down the narrow tunnel.", "As you approach the alcove, the lights seem more and more lively,", "this continues until they are almost within arms reach.", "You that the lights are not actually lights but instead Will-o'-wisps!"},
        {"You realization comes too late, as suddenly the floor beneath you", "gives way! You just fell into a pitfall trap!", "The wisps, waiting for this, lunge at you to try and finish you off.", "You must climb to save your life!"},
        {""},
        {"As the wisps shock you repeatedly, you loose your grip and fall back", "to the floor.", "With not enough energy left to try again, you lie there motionless..."},
        {"You make it the top of the trap and get onto the saftey of", "solid ground once more. You turn around to exact your revenge", "on the fae that tried to kill you, but they all disappeared."},
        {"Begrudgingly you move onwards into the small alclove.", "There doesn't seem to be much in it except for a rotting", "wooden chest set on one side"},
        {"You carefully search the room and the chest but don't find", "anything that resembles a trap"},
        {"The wood almost falls apart at your touch as you open the chest,", "but you manage to open the lid.", "inside are various gems and jewels worth 500 gold total"},
        {"Once you make it back to the circular room you turn your attention", "towards the only other tunnel."},
        {"As you travel down he tunnal the smell of death burns", "itself into your nostrils. After walking 200 meters you", "arrive in a large cave, inside there are 4 sarcophagi, two on each side,", "and a pile of bones at the far end"},
        {"The pile of bones start to vibrate at your touch, you step back in ", "horror and are ready to fight as the bones start to mend together.", "Before you now stands a skeletal horse with a saddle engraved with lady Alagondar's crest.", "Her trusty steed bows to you before galloping down the tunnel back towards the main room"},
        {"When the horse makes it into the main room,", "it goes straight to a specific patch of wall.", "With a boney hoof it taps the wall,", "a few moments later the wall crumbles away to reveal a secret passageway"},
        {"You enter the room and find yourself in a large polished cavern.", "The walls have engravings of the glorious battle between Alagondar", "and her mighty foe, a huge dragon. The horse goes straight to the sarcophagus and bows to it before crumbling away."},
        {"As you look more closely at the engravings, you realize that the white", "material they are made out of are actually bone! Following the engravings you find the a huge dragon's skull.", "you collect 5000 gold worth of dragon fangs and talons"},
        {"You open the sarcophagus and find the legendary sword you were", " searching for! As you reach for the sword the skeleton's hands move to present you the sword.", "You hear a feminene voice say \"Use it wisely. Use it for the good of my people.\""},
        {""},
        {"You open the nearest sarcophagus and a cloud of dust","comes pouring out. Some of the dust touches your skin","and it starts to burn instantly, the dust is corrosive!"},
        {""},
        {"You accidentally inhale some of the dust and start stumbling around.", "With your isides burnning you collapse on the floor..."},
        {"You dodge the dust long enough for it to settle.", "Once it does you back away from the sarcophogi"}
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
        {"Press 1 to try the climb again", "Press 2 to try from the begining"},
        {"Click to continue"},
        {"Press 1 to open the chest", "Press 2 to search the rooms for traps"},
        {"Press 1 to open the chest"},
        {"Press 1 to return back to the circular room"},
        {"Click to continue"},
        {"Press 1 to examine the sarcophogi", "Press 2 to examine the bones"},
        {"Press 1 to follow the horse"},
        {"Click to continue"},
        {"Press 1 to search the cave", "Press 2 to search the sarcophagus"},
        {"Press 1 to search sarcophagus"},
        {"Click to continue"},
        {""},
        {"Click to start dodging"},
        {""},
        {"Press 1 to try again", "Press 2 to try from the begining"},
        {"Press 1 to examine bones"}
        
    };

    public Background(int x) throws SlickException {
        id = x;
        textbox = new Rectangle(0, 500, 800, 100);
        image = new Image("images/" + maps[id] + ".png");

    }

    public void draw(Graphics g) {
        image.draw(0, 0);
        g.setColor(BoxColor);
        if(id != 23)
            g.fill(textbox);
        for (int i = 0; i < text[getId()].length; i++) {
            ttf.drawString(10, (515 + (i * 20)), text[getId()][i], new Color(56, 25, 47));
        }
        if(id ==21){
            ttf.drawString(10, (515), "You take the sword and leave the with everything you have collected:", new Color(56, 25, 47));
            ttf.drawString(10, (535), "the legendary dragonslayer sword" + toString(), new Color(55, 36, 76));
        }
        if (id == 7 && GameLauncher.hasRope == true) {
            ttf.drawString(500, (515), "Click to throw your contraption", new Color(55, 36, 76));
            ttf.drawString(500, (535), "(which you have named a grapling hook)", new Color(55, 36, 76));
            ttf.drawString(500, (555), "to try and climb up.", new Color(55, 36, 76));
        } else {
            for (int i = 0; i < options[getId()].length; i++) {
                ttf.drawString(500, (515 + (i * 20)), options[getId()][i], new Color(55, 36, 76));
            }
        }
    }

    public int getId() {
        return id;
    }

    public String toString() {
        String str = "";
        if (GameLauncher.hasRope == true) {
            str += ", a grappling hook";
        }
        str += " and " + GameLauncher.gold + " pieces of gold.";
        return str;
    }
}
