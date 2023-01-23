import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IWantInternet {
    private JTextField txtDestiny;
    private JList lstLogs;
    private JCheckBox chkNotif;
    private JButton startPingingButton;
    private JPanel pnlPanel;
    private JScrollPane sclScroll;
    private boolean pingStatus = false;
    boolean notif = true;
    private long pingCount = 1;
    private static final ArrayList<String> logs = new ArrayList<>();

    public IWantInternet() {

        sclScroll.getHorizontalScrollBar().setPreferredSize(new Dimension(10, 0));
        sclScroll.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));

        startPingingButton.addActionListener(e -> doClick());
        chkNotif.addActionListener(e -> {
            notif = chkNotif.isSelected();
            IWantInternetNow.pu.setNotify(chkNotif.isSelected());
        });
    }

    public void doClick() {
        if (pingStatus) {
            startPingingButton.setText("Start pinging");
            IWantInternetNow.pu.setText("Start pinging");
            printLog("[ Stopped pinging... ]");
            pingStatus = false;
        } else {
            startPingingButton.setText("Stop pinging");
            IWantInternetNow.pu.setText("Stop pinging");
            printLog("[ Started pinging... ]");
            pingStatus = true;
            Pinger pinger = new Pinger();
            pinger.start();
        }
    }

    public void stop() {
        doClick();
    }

    public JPanel getPanel() {
        return pnlPanel;
    }

    public String getDestiny() {
        return txtDestiny.getText();
    }

    public boolean getPingStatus() {
        return pingStatus;
    }

    public boolean getNotif() {
        return notif;
    }

    public long getIndex() {
        return pingCount;
    }

    public void setIndex(long num) {
        pingCount = num;
    }

    public void printLog(String log) {
        logs.add(log);
        lstLogs.setListData(logs.toArray());
        lstLogs.ensureIndexIsVisible(logs.size()-1);
    }

    public void setNotify(boolean notif) {
        chkNotif.setSelected(notif);
    }
}
