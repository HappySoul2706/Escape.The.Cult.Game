import java.util.Scanner;
import java.util.Objects;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        //Initializing starting components, Scanner, Room Select Function, Room key list, key booleans and main game running boolean.
        Scanner INPUT = new Scanner(System.in);

        String RoomSelect;

        String KeyA = "small cramped hole";
        String KeyB = "main cell door";
        String Key2A = "corridor branch off";
        String Key2B = "collapsed tunnel";
        String Key3A = "Long corridor";
        String Key4A = "Mess hall";
        String Key4B = "kitchen";
        String Key3B = "Summoning room";
        String Key4C = "Hallway";
        String Key3C = "Sacrificial room";
        String Key5A = "Cultist Barracks";
        String Key5B = "Closet";
        String KeyLoveCraft = "Obelisk";

        //dude I dunno what way I could meaningfully use an array ¯\_(ツ)_/¯
        String[] TxTColor = new String[4];
        TxTColor[0] = "\u001B[0m";
        TxTColor[1] = "\u001B[93m";
        TxTColor[2] = "\u001B[31m";
        TxTColor[3] = "\u001B[35m";

        boolean GOLDKey = false;
        boolean CYANKey = false;
        boolean MAGENTAKey = false;
        boolean running = false;

        //Begin sequence
        System.out.println("""
                gibbering words echo around you, it's dark and wet. Your mind hurts and you can't feel your body. You 
                feel like you're both falling and yet are weightless. You wake up with vertigo, the world spins around 
                you a torch lies on the ground smoldering, the darkness begins to
                 close in once more.
                """);
        System.out.println("Press type Start to begin!\n");
        String StartGame = INPUT.nextLine();



        Game:
        //First room prison cell - 1A
        System.out.println("bed - I just woke up, I don't want to go back to bed\n");
        System.out.println("""
                Note - I’m sorry I need to leave you here I didn’t want to, always remember the keys are your friend, they can lead you away from this place, you need to escape at all\s
                costs. Just know this is not hell, it's worse. \s
                Sincerely, yourself\s""");
        while(true) {
            System.out.println("\nall directions are blocked except to the East which has a " + ANSI_LIGHT_YELLOW+
                    "small cramped hole" + ANSI_RESET + " in the wall.");
            RoomSelect = INPUT.nextLine();
            //Hole in wall
            if (stringParse(RoomSelect,KeyA)) {
                System.out.println("you climb through the jagged hole filled with splintered wood and sharp stone, it looks " +
                        "like a mouth.\n");
                break;
            }
            System.out.println(ANSI_RED+"\nPlease enter a correct path\n"+ANSI_RESET);
        }

        //Prison Chamber - 1B
        if (stringParse(RoomSelect,KeyA)){
            System.out.println("Empty cells - all the cells are empty of living prisoners, the only thing left are skeletons " +
                    "slumped over given up.");
            System.out.println("Collapsed path - The hole you climbed through begins to collapse behind you, chunks of rock and" +
                    " slivers of wood crumble down, dust flies out into the room.\n");
            while (true) {
                System.out.println("all directions are blocked except to the East where the " + ANSI_LIGHT_YELLOW + "main cell" +
                        " door" + ANSI_RESET + " is wide open.");
                RoomSelect = INPUT.nextLine();
                //South passage
                if (stringParse(RoomSelect,KeyB)) {
                    System.out.println("the cell door is open ajar, slightly pushing it made it create a loud grinding " +
                            "noise. The door opens just enough to let you out but you cannot return\n");
                    break;
                }
                System.out.println(ANSI_RED+"\nPlease enter a correct path\n"+ANSI_RESET);
            }
        }

        //Prison corridor - 1C
        if (stringParse(RoomSelect,KeyB)){
            System.out.println("Other prison cells - three more identical cells doors line the hall, one in front of you " +
                    "and two more across from each other further down the corridor.");
            while (true) {
                System.out.println("all directions are blocked except South where there's a " + ANSI_LIGHT_YELLOW +
                        "corridor branch off." + ANSI_RESET);
                RoomSelect = INPUT.nextLine();
                //South passage
                if (stringParse(RoomSelect,Key2A)) {
                    System.out.println("the corridor has sconces lining the wall, they grow dimmer as the smoke flies in" +
                            " all directions, confused.\n");
                    break;
                }
                System.out.println(ANSI_RED+"\nPlease enter a correct path\n"+ANSI_RESET);
            }
        }

        //Four way split - 2A
        if (stringParse(RoomSelect,Key2A)){
            System.out.println("Four way - from where you stand there is four passages all around you.\n");
            System.out.println("The door standing before you has a sign in unknown script but for some reason it makes " +
                    "sense to you, it reads: Mess hall.\n");
            System.out.println("cave in - To the north down the prison corridor, the loud rumbling and groaning causes " +
                    "the roof to collapse making large boulders and support beams tumble down blocking the path back" +
                    " a tidal wave of dust and refuse is flung out making you cough.");
            while (true) {
                System.out.println("To  the West there is a " + ANSI_LIGHT_YELLOW + "Collapsed tunnel" + ANSI_RESET+ "" +
                        ", to the East there is a " + ANSI_LIGHT_YELLOW + "Long corridor" + ANSI_RESET +
                        "leading to a Magenta door, to the South there is a GOLD door leading to the " +
                        ANSI_LIGHT_YELLOW + "Mess hall" + ANSI_RESET);
                RoomSelect = INPUT.nextLine();
                //West passage
                if (stringParse(RoomSelect,Key2B)) {
                    System.out.println("\nthe cracks line the wall and dust flutters down towards you.\n");
                    break;
                }
                //East passage
                if (stringParse(RoomSelect,Key3A)) {
                    System.out.println("a large ornate stone door, on other side a shimmer of brilliant " + ANSI_MAGENTA + "Magenta"
                            + ANSI_RESET + " light is seen. A heavy pressure builds in your chest and head it begins to hurt.");
                    break;
                }
                //South passage
                if (stringParse(RoomSelect,Key4A)) {
                    System.out.println("\na heavy wooden door, it has gold trimmings and cloth draped over it.\n");
                    break;
                }
                System.out.println(ANSI_RED+"\nPlease enter a correct path\n"+ANSI_RESET);
            }
        }

        //Collapsed tunnel  - 2B
        if (stringParse(RoomSelect,Key2B)){
            System.out.println("Collapsed tunnel - a pile of rocks seem to have crashed down from the roof");
            System.out.println("Dead cultist - a figure wearing a robe with sigils lies buried beneath the rocks, he’s" +
                    " dead. In his hand a GOLD key is being clutched.");
            System.out.println("You take the GOLD key from the cultists hand.\n");
            GOLDKey = true;
            while (true) {
                System.out.println("all directions are blocked except East to the "+ ANSI_LIGHT_YELLOW + "corridor branch off.\n" + ANSI_RESET);
                RoomSelect = INPUT.nextLine();
                // West passage
                if (stringParse(RoomSelect,Key2A)) {
                    System.out.println("the cracks line the wall and dust flutters down towards you.");
                    break;
                }
                System.out.println(ANSI_RED+"\nPlease enter a correct path\n"+ANSI_RESET);
            }
        }

        //Locked Magenta door - 2C (Boolean buffer, not a location)

        //Obelisk one  - 3A
        if (MAGENTAKey) {
            if (stringParse(RoomSelect,Key3A)){
                System.out.println("Magenta door - the door behind you slams shut.");
                System.out.println("Courtyard - Singing begins to unnerve you as the voices switch between a shrill" +
                        " unrecognizable sound to a beautiful angelic like choir.");
                System.out.println("Statues - surrounding the Obelisk are large statues depicting various beings in armor.");
                System.out.println("Mummified cultists - cultists sit praying aligned around the obelisk, incredibly still," +
                        " they chant in tongues but don't speak, they are silently praying to the obelisk.");
                while (true) {
                    System.out.println("all directions are blocked except North to the " + ANSI_MAGENTA + "Obelisk" +
                            ANSI_RESET + ".");
                    RoomSelect = INPUT.nextLine();
                    //Obelisk
                    if (stringParse(RoomSelect,KeyLoveCraft)) {
                        System.out.println("Final message\n");
                        System.exit(0);
                    }
                    System.out.println("There is only one way out of a nightmare of your own making.");
                }
            }
        } else {
            System.out.println("you do not have the " + ANSI_MAGENTA + "Magenta key" + ANSI_RESET + ".");
            if (stringParse(RoomSelect,Key3A)){
                while (true) {
                    System.out.println("all directions are blocked except West back to the " + ANSI_LIGHT_YELLOW +
                            "corridor branch off"+ ANSI_RESET + ".");
                    RoomSelect = INPUT.nextLine();
                    //corridor branch off
                    if (stringParse(RoomSelect,Key2A)) {
                        System.out.println("you leave the area and it feels like the pressure has been lifted your body" +
                                " and mind still hurt.");
                        break;
                    }
                    System.out.println(ANSI_RED+ "\nPlease enter a correct path\n" + ANSI_RESET);
                }
            }
        }


        //Locked GOLD door  - 5B (Boolean buffer, not a location)

        //Mess hall - 4A
        if (GOLDKey) {
            if (stringParse(RoomSelect,Key4A)){
                System.out.println("Large tables - large wood tables with many seats, some seats are flipped and bowls of " +
                        "mold and maggots appear to be flung, everyone left in a rush. The silence reverberates through your " +
                        "hollow body.");
                System.out.println("Kitchen counter - a flat counter with a shattered mug, a horrid choking stench emanates" +
                        "from the back of the kitchen.");
                while (true) {
                    System.out.println("to the West there is the " + ANSI_LIGHT_YELLOW + "kitchen" + ANSI_RESET + ", to the" +
                            " East there is a CYAN door with the inscription in the same unknown familiar language: " +
                            ANSI_LIGHT_YELLOW + "Summoning room" + ANSI_RESET + ", to the South there is a " +
                            ANSI_LIGHT_YELLOW + "hallway." + ANSI_RESET);
                    RoomSelect = INPUT.nextLine();
                    //Cyan door
                    if (stringParse(RoomSelect,Key3B)) {
                        System.out.println("a large metallic double door stands before you, CYAN gems line ornate symbols " +
                                "on it.");
                        break;
                    }
                    //Kitchen
                    if (stringParse(RoomSelect,Key4B)) {
                        System.out.println("you hop over the counter slicing your hand on the mug. Oddly no blood flows from " +
                                "your hand.");
                        break;
                    }
                    //Hallway
                    if (stringParse(RoomSelect,Key4C)) {
                        System.out.println("the floor is littered with food, debris and blood mixed with other unknown " +
                                "liquids. ");
                        break;
                    }
                    System.out.println(ANSI_RED+"\nPlease enter a correct path\n"+ANSI_RESET);
                }
            }
        } else {
            System.out.println("you do not have the " + ANSI_YELLOW + "Gold key" + ANSI_RESET + ".");
            if (stringParse(RoomSelect,Key3A)){
                while (true) {
                    System.out.println("all directions are blocked except North back to the " + ANSI_LIGHT_YELLOW +
                            "corridor branch off"+ ANSI_RESET + ".\n");
                    RoomSelect = INPUT.nextLine();
                    //corridor branch off
                    if (stringParse(RoomSelect,Key2A)) {
                        System.out.println("you walk back to the corridor branch off\n");
                        break;
                    }
                    System.out.println(ANSI_RED+ "\nPlease enter a correct path\n" + ANSI_RESET);
                }
            }
        }

        //CYAN door - 5C (Boolean buffer, not a location)

        //Summoning room - 3B
        if (CYANKey){
            if (stringParse(RoomSelect,Key3B)){
                System.out.println("""
                    "Magenta orb - the color emitted is a brilliant shade but you can't name the color it feels as if\040
                    your skin is burning but it feels to good to bask in it light to look away, you tear the orb from\040
                    its socket in the air.
                    """);
                System.out.println("Mummified cultists - cultists hymn together praying to the large orb in the center.");
                System.out.println("Statues -statues reaching the ceiling depicting large bizarre creatures in robes.");
                MAGENTAKey = true;
                while (true) {
                    System.out.println("all directions are blocked except West back to the " + ANSI_LIGHT_YELLOW +
                            "Mess Hall" + ANSI_RESET);
                    RoomSelect = INPUT.nextLine();
                    //West passage
                    if (stringParse(RoomSelect,Key4A)) {
                        System.out.println("You walk back to the Mess hall, the horrid stench hits you again making you gag.");
                        break;
                    }
                    System.out.println(ANSI_RED+"\nPlease enter a correct path\n"+ANSI_RESET);
                }
            }
        } else {
            System.out.println("you do not have the " + ANSI_CYAN + "Cyan key" + ANSI_RESET + ".");
            if (stringParse(RoomSelect,Key3B)){
                while (true) {
                    System.out.println("all directions are blocked except West back to the " + ANSI_LIGHT_YELLOW +
                            "Mess hall" + ANSI_RESET + ".\n");
                    RoomSelect = INPUT.nextLine();
                    //Mess hall
                    if (stringParse(RoomSelect,Key4A)) {
                        System.out.println("you walk back to the mess hall\n");
                        break;
                    }
                    System.out.println(ANSI_RED+ "\nPlease enter a correct path\n" + ANSI_RESET);
                }
            }
        }

        //Kitchen - 4B
        if (stringParse(RoomSelect,Key4B)){
            System.out.println("""
                    Rot pile - A large mound of black tar like filth sits at the other end of the kitchen; the stench\040
                    from it is only worsened by the mice and maggots crawling over it, discarded remains of old food and
                     other things jut out of the mound. You can vaguely see the outcrop of human remains, you look away\040
                     sick to your stomach and refuse to look back.
                    """);
            System.out.println("""
                    Broken cupboards - many cupboards are missing doors, shelves and handles. The cupboards next to the
                     mound are warped, not moved out of the way, they appear to bend and twist towards the mound.
                    """);
            while (true) {
                System.out.println("all directions are blocked except East back over the counter to the " +
                        ANSI_LIGHT_YELLOW + "Mess hall." + ANSI_RESET);
                RoomSelect = INPUT.nextLine();
                //East passage
                if (stringParse(RoomSelect,Key4A)) {
                    System.out.println("you hop back over the counter, glad the stench is toned down slightly.");
                    break;
                }
                System.out.println(ANSI_RED+"\nPlease enter a correct path\n"+ANSI_RESET);
            }
        }

        //Hallway - 4C
        if (stringParse(RoomSelect,Key4C)){
            System.out.println("Corridor - you walk down the hallway, the roof drips with water and the walls crumble" +
                    " around you, the sounds of flies buzzing echoes distantly. \n");
            while (true) {
                System.out.println("to the South there is door, and to the West there is another door.");
                RoomSelect = INPUT.nextLine();
                //West passage
                if (stringParse(RoomSelect,Key5A)) {
                    System.out.println("you clutch the door handle and terrible visions fill your mind, a hatchet being " +
                            "raised in the air held sternly by a hand, people rushing away from a snarling writhing mass" +
                            "that drags people towards it, the sight alone snaps you away from the memory and a new boiling" +
                            " torrent of fear washes over you.\n");
                    break;
                }
                //South passage
                if (stringParse(RoomSelect,Key3C)) {
                    System.out.println("The scent of rotting meat wafts from the door, and the soft buzzing of flies " +
                            "grows to a deafening roar\n");
                    break;
                }
                //North passage
                if (stringParse(RoomSelect,Key4A)) {
                    System.out.println("you go back to the " + ANSI_LIGHT_YELLOW + "mess hall" + ANSI_RESET);
                    break;
                }
                System.out.println(ANSI_RED+"\nPlease enter a correct path\n"+ANSI_RESET);
            }
        }

        //Cultist Barracks - 5A
        if (stringParse(RoomSelect,Key4C)){
            System.out.println("Beds - many wooden beds lay empty sheets torn and laying scattered, some have red ooze" +
                    " seeping from a lump beneath the covers, you decide to not investigate further.");
            System.out.println("Closet - a voice from behind a small door catches your attention.\n");
            while (true) {
                System.out.println("to the east there is the door you came from, and to the south there is another door" +
                        "leading to the closet.\n");
                RoomSelect = INPUT.nextLine();
                //South passage
                if (stringParse(RoomSelect,Key5A)) {
                    System.out.println("you clutch the door handle and terrible visions fill your mind, a hatchet being " +
                            "raised in the air held sternly by a hand, people rushing away from a snarling writhing mass" +
                            "that drags people towards it, the sight alone snaps you away from the memory and a new boiling" +
                            " torrent of fear washes over you.\n");
                    break;
                }
                //East passage
                if (stringParse(RoomSelect,Key3C)) {
                    System.out.println("The scent of rotting meat wafts from the door, and the soft buzzing of flies " +
                            "grows to a deafening roar\n");
                    break;
                }
                System.out.println(ANSI_RED+"\nPlease enter a correct path\n"+ANSI_RESET);
            }
        }

        //Closet - 5B
        if (stringParse(RoomSelect,Key5B)){
            System.out.println("Tape recorder - The tape recorder on the shield breaks the silence occasionally saying," +
                    " “Wake up, you have to wake up, You must wake up.”");
            System.out.println("Dead cultist - You look at the man slouched over on the ground, a wave of familiarity " +
                    "washes over you, there is no blood, just a man who laid down and didn't get up.\n");
            while (true) {
                System.out.println("all exits are blocked except north through the closest door back to the " +
                        ANSI_LIGHT_YELLOW + "Cultist barracks.\n" + ANSI_RESET);
                RoomSelect = INPUT.nextLine();
                //North passage
                if (stringParse(RoomSelect,Key5A)) {
                    System.out.println("You walk back into the barracks and are consumed by fear, dread, anger and disgust. \n");
                    break;
                }
                System.out.println(ANSI_RED+"\nPlease enter a correct path\n"+ANSI_RESET);
            }
        }

        //Sacrificial room - 3C
        if (stringParse(RoomSelect,Key3C)){
            System.out.println("Body sacks - chains rattle as large sacks dripping with a crimson liquid sway slightly.");
            System.out.println("Dead Cultist - a cultist slumped over in the corner, holds a CYAN key in one hand and a " +
                    "single shot handgun in the other, there is a single bullet shell lying on the ground.\n");
            CYANKey = true;
            while (true) {
                System.out.println("the only exit is North, back to the " + ANSI_LIGHT_YELLOW + "hallway.\n" + ANSI_RESET);
                RoomSelect = INPUT.nextLine();
                //North passage
                if (stringParse(RoomSelect,Key5A)) {
                    System.out.println("the sound of flies begins to subside and water dripping fades in.\n");
                    break;
                }
                System.out.println(ANSI_RED+"\nPlease enter a correct path\n"+ANSI_RESET);
            }
        }


    }

    public static boolean stringParse(String phrase, String Key) {

        //loop through the letters of the phrase
        for (int i = 0; i <phrase.length(); i++) {
            boolean FoundIt = true;
            //loop through the letters of the key word
            for (int j = 0; j < Key.length(); j++) {
                //check if the letters are the same
                if( phrase.charAt(i+j) == Key.charAt(j) ){
                }
                else{
                    //if they are different, break the loop
                    FoundIt = false;
                    break;
                }
                //End loop
            }
            //if the loop finishes without breaking: return true
            if(FoundIt){
                return true;
            }
            //End loop
        }
        //you didn't find it, return false.
        return false;
       }


       //Colored text functions and reset function.
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_LIGHT_YELLOW = "\u001B[93m";

    public static final String ANSI_RED = "\u001B[31m";

    public static final String ANSI_MAGENTA = "\u001B[35m";

    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_CYAN = "\u001B[36m";
}