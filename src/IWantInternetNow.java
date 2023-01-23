import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IWantInternetNow {

    private static TrayIcon trayIcon;
    public static IWantInternet iwi = new IWantInternet();
    public static PopUp pu = new PopUp();
    private Image icon = new ImageIcon(IWantInternetNow.class.getClassLoader().getResource("assets/icon.png")).getImage();

    public static JFrame frame;

    public void startInternetWatcher() throws AWTException {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
        } else {
            setUpTrayIcon();
        }
        frame = new JFrame("I WANT INTERNET");
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

        trayIcon = new TrayIcon(icon, "I Want Internet", pu);
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Getting your internet, be patient");

        tray.add(trayIcon);
    }

    public static void notification(String caption, String text, TrayIcon.MessageType msgType) {
        trayIcon.displayMessage(caption, text, msgType);
    }

}