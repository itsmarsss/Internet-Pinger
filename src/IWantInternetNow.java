import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IWantInternetNow {

    private static TrayIcon trayIcon;
    public static IWantInternet iwi= new IWantInternet();
    private Image icon = new ImageIcon(IWantInternetNow.class.getClassLoader().getResource("assets/icon.png")).getImage();

    public void startInternetWatcher() throws AWTException {
        setUpTrayIcon();
        JFrame frame = new JFrame("I WANT INTERNET");
        frame.add(iwi.getPanel());
        frame.setIconImage(icon);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        trayIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frame.setAlwaysOnTop(true);
                frame.setAlwaysOnTop(false);
            }
        });
        //notification("HI", "Yo", TrayIcon.MessageType.ERROR);
    }

    private void setUpTrayIcon() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();

        trayIcon = new TrayIcon(icon, "I Want Internet" /*PASS IN POPIN HERE*/);
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Getting your internet, be patient");

        tray.add(trayIcon);
    }

    public static void notification(String caption, String text, TrayIcon.MessageType msgType) {
        trayIcon.displayMessage(caption, text, msgType);
    }

}