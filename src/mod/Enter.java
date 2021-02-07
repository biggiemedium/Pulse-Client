package mod;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;
import java.awt.Desktop;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
public class Enter {

    public void StartScreen() {
        String web = "https://www.youtube.com/watch?v=DLzxrzFCyOs&ab_channel=AllKindsOfStuff";
        JFrame main = new JFrame();
        JPanel panel = new JPanel();
        JButton play = new JButton("Start");
        JButton end = new JButton("End");
        JButton roll = new JButton("Pulse Client");
        JButton bottom = new JButton("By PX");
        bottom.setBounds(0, 181, 200, 20);
        bottom.setBackground(new Color(149, 184, 209));
        bottom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String site = "https://phasmophobia.fandom.com/wiki/Main_Page";
                try {
                    final URL phaswik = new URL(site);
                    final Desktop dt = Desktop.getDesktop();
                    dt.browse(phaswik.toURI());
                }
                catch (URISyntaxException ex) {
                    Logger.getLogger(ManagementAssertion.Setting.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (IOException ex2) {
                    Logger.getLogger(ManagementAssertion.Setting.class.getName()).log(Level.SEVERE, null, ex2);
                }
            }
        });
        roll.setBounds(0, 0, 200, 26);
        roll.setBackground(new Color(149, 184, 209));
        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                String rick = "https://www.youtube.com/watch?v=dQw4w9WgXcQ&list=PLahKLy8pQdCM0SiXNn3EfGIXX19QGzUG3&ab_channel=RickAstleyVEVO";
                try {
                    final URL phaswik = new URL(rick);
                    final Desktop dt = Desktop.getDesktop();
                    dt.browse(phaswik.toURI());
                }
                catch (URISyntaxException ex) {
                    Logger.getLogger(ManagementAssertion.Setting.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (IOException ex2) {
                    Logger.getLogger(ManagementAssertion.Setting.class.getName()).log(Level.SEVERE, null, ex2);
                }
            }
        });
        play.setBounds(8, 80, 75, 26);
        play.setToolTipText("Start program");
        play.setBackground(new Color(102, 106, 134));
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                main.setVisible(false);

                Game g = new Game();
                g.OnScreen();

            }
        });
        end.setBounds(112, 80, 75, 26);
        end.setBackground(new Color(102, 106, 134));
        end.setToolTipText("End program");
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.out.println("Mod ended");
                System.exit(0);
            }
        });
        panel.add(bottom);
        panel.setLayout(null);
        panel.add(play);
        panel.add(end);
        panel.add(roll);
        panel.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        panel.setVisible(true);
        main.add(panel);
        main.setLocation(800, 300);
        main.setSize(200, 200);
        main.setUndecorated(true);
        main.setResizable(false);
        main.setBackground(new Color(51, 51, 51));
        main.setDefaultCloseOperation(3);
        main.setVisible(true);
    }

}
