import java.awt.*;

public class PopUp extends PopupMenu {

    private final CheckboxMenuItem notifyItem;
    private final MenuItem pingItem;
    public PopUp() {
        MenuItem openItem = new MenuItem("Open");
        MenuItem exitItem = new MenuItem("Exit");
        this.add(openItem);
        this.add(exitItem);
        this.addSeparator();
        pingItem = new MenuItem("Start Ping");
        this.add(pingItem);
        this.addSeparator();
        notifyItem = new CheckboxMenuItem("Notify Me");
        notifyItem.setState(true);
        this.add(notifyItem);

        openItem.addActionListener(e -> {
            IWantInternetNow.frame.setVisible(true);
            IWantInternetNow.frame.setAlwaysOnTop(true);
            IWantInternetNow.frame.setAlwaysOnTop(false);
        });

        exitItem.addActionListener(e -> System.exit(0));


        pingItem.addActionListener(e -> IWantInternetNow.iwi.doClick());


        notifyItem.addItemListener(e -> {
            IWantInternetNow.iwi.notif = notifyItem.getState();
            IWantInternetNow.iwi.setNotify(notifyItem.getState());
        });
    }

    public void setNotify(boolean notify) {
        notifyItem.setState(notify);
    }

    public void setText(String text) {
        pingItem.setLabel(text);
    }
}
