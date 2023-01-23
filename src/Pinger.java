import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Pinger extends Thread {

    @Override
    public void run() {
        while (IWantInternetNow.iwi.getPingStatus()) {
            pingAddress(IWantInternetNow.iwi.getDestiny());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
        IWantInternetNow.iwi.setIndex(1);
        this.interrupt();
        this.stop();
    }


    public void pingAddress(String webAddress) {
        boolean reachable = false;
        try {
            InetAddress address = InetAddress.getByName(webAddress);
            reachable = address.isReachable(1000);

            URL url = new URL(webAddress);
            URLConnection connection = url.openConnection();
            connection.connect();

            reachable = true;
        } catch (Exception e) {
        }
        if (reachable) {
            System.out.println("Connected");
            IWantInternetNow.iwi.printLog("Connection Found!!!");
            IWantInternetNow.iwi.stop();
            if (IWantInternetNow.iwi.getNotif()) {
                IWantInternetNow.notification("INTERNET YAY", "GET ONLINE NOW HAHA", TrayIcon.MessageType.INFO);
            }
        } else {
            System.out.println("Not Connected");
            IWantInternetNow.iwi.printLog(IWantInternetNow.iwi.getIndex() + " ~ No response from: " + webAddress);
        }
        IWantInternetNow.iwi.setIndex(IWantInternetNow.iwi.getIndex() + 1);
    }

}
