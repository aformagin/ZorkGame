import java.io.IOException;

////////////////////////////////////////////////////////////////////////////////
//Creation Date: 2017-02-22
//Created By: Austin Formagin
//This is the "main" class or the client class. From here is where the user will
//play the game from, and where it will be launched from the title screen.
////////////////////////////////////////////////////////////////////////////////
public class Launch {
    public static void main (String[]args) throws IOException
    {
        TitleScreen title = new TitleScreen();
        System.out.print("Hello World");//Out puts hello world when launched. Just so it does something for now
    }
}
