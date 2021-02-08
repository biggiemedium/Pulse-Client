import com.sun.jna.Platform;
import mod.Enter;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Loading load = new Loading();
        load.Loading();

        Thread t = null;
        t.sleep(100);

            String os = System.getProperty("os.name");
            String line;
            String pidInfo = "";


            if (os.contains("mac")) {
                String macos = "Pulse is not compatible with Mac OS";
                JOptionPane.showMessageDialog(null, macos, "Error", JOptionPane.ERROR_MESSAGE);

                System.exit(0);
            }
            if (Platform.isLinux()) {
                String linuxos = "Pulse is not compatible with Linux";
                JOptionPane.showMessageDialog(null, linuxos, "Error", JOptionPane.ERROR_MESSAGE);

                System.exit(0);
            }

            Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((line = input.readLine()) != null) {
                pidInfo += line;
            }

            input.close();
            t.interrupted();

            if (pidInfo.contains("Phasmophobia")) {
                System.out.println("Phasmophobia is running");

                Enter e = new Enter();
                e.StartScreen();

            } else {

                try {
                    SystemTray tray = SystemTray.getSystemTray();

                    Image image = Toolkit.getDefaultToolkit().createImage(new URL("https://styles.redditmedia.com/t5_35rwtp/styles/communityIcon_qt455yfqyep51.png?width=256&s=c9297f54a4f2e7af71f71564c2592b45f4c73875"));

                    TrayIcon trayIcon = new TrayIcon(image, "Pulse");
                    trayIcon.setImageAutoSize(true);
                    trayIcon.setToolTip("test");

                    tray.add(trayIcon);

                    trayIcon.displayMessage("Pulse Client", "Phasmophobia.exe is not running!", TrayIcon.MessageType.ERROR);

                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                System.exit(0);
            }

        }

}


