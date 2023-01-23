import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String args[]) throws AWTException {
        setLooksAndFeels();
        IWantInternetNow iwin = new IWantInternetNow();
        iwin.startInternetWatcher();
    }

    private static void setLooksAndFeels() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
            JFrame.setDefaultLookAndFeelDecorated(true);
        }
    }
}
