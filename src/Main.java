//Klassen startar upp spelet FU

        import com.googlecode.lanterna.TerminalFacade;
        import com.googlecode.lanterna.terminal.Terminal;
        import java.nio.charset.Charset;



public class Main {

    static Terminal terminal;

    public static void main(String[] args) throws InterruptedException {

        terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);

        RunGame run = new RunGame();

        run.rungame();

    }
}