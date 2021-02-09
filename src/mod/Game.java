package mod;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;

import java.net.URL;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Game {

    private final Map<ActionListener, JMenuItem> menuItems = new HashMap<>();
    private final JFrame frame = new JFrame();
    private final JPanel p = new JPanel();
    private final JMenuBar jmb = new JMenuBar();
    private final JMenu b = new JMenu("MOD");

    public void OnScreen() throws AWTException {

        p.add(jmb);
        p.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        frame.add(p);
        frame.setLocation(1870, 0);
        frame.setSize(50, 30);
        frame.setBackground(Color.GRAY);
        frame.setAlwaysOnTop(true);
        frame.setUndecorated(true);
        frame.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        JFrame toggled = new JFrame();
        JPanel screen = new JPanel();
        JLabel on = new JLabel("Toggled: ");
        screen.add(on);
        screen.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        on.setForeground(Color.WHITE);
        toggled.add(screen);
        toggled.setSize(200, 300);
        toggled.setLocation(-50, 0);
        toggled.setUndecorated(true);
        toggled.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        toggled.setAlwaysOnTop(true);
        toggled.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        toggled.setVisible(true);
        jmb.add(b);
        jmb.setBorderPainted(true);
        jmb.setBackground(Color.gray);
        JMenuItem brightness = new JMenuItem("Brightness");


        ActionListener brightnessfunc = e -> {
            Thread light = new Thread(() -> {

                //boolean lights = false;

                JFrame brighton = new JFrame();
                JLabel bl = new JLabel("Brightness");
                bl.setForeground(Color.WHITE);
                brighton.add(bl);
                brighton.setLocation(30, 20);
                brighton.setUndecorated(true);
                brighton.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
                brighton.setSize(100, 50);
                brighton.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                brighton.setVisible(true);
                final Random rd = new Random();
                try {
                    final Robot ro = new Robot();
                    final int Randomnum = rd.nextInt(451) + 50;
                    while (true) {
                        ro.delay(Randomnum);
                        ro.keyPress(84);
                        ro.keyRelease(84);
                    }
                }
                catch (AWTException awtException) {
                    awtException.printStackTrace();
                }



            });
            light.start();
        };
        setupJComponent(brightness, brightnessfunc);

        JMenuItem wiki = new JMenuItem("Wiki");
        wiki.addActionListener(e -> {
            final String site = "https://phasmophobia.fandom.com/wiki/Main_Page";
            try {
                final URL phaswik = new URL(site);
                final Desktop dt = Desktop.getDesktop();
                dt.browse(phaswik.toURI());
            }
            catch (URISyntaxException | IOException ex) {
                Logger.getLogger(ManagementAssertion.Setting.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        AtomicBoolean isCancelled = new AtomicBoolean(false);
        final Robot r = new Robot();
        final ExecutorService scheduler = Executors.newFixedThreadPool(2);
        final KeyHolder[] vkshift = new KeyHolder[1];
        final KeyHolder[] vkw = new KeyHolder[1];
        vkshift[0] = new KeyHolder(KeyEvent.VK_SHIFT, r);
        vkw[0] = new KeyHolder(KeyEvent.VK_W, r);


        JMenuItem sprint = new JMenuItem("Sprint");
        ActionListener sprintlistener = e -> {
            JFrame spr = new JFrame();
            JLabel tit = new JLabel("Sprint");

            tit.setForeground(Color.WHITE);
            spr.add(tit);
            spr.setLocation(30, -20);
            spr.setSize(100, 100);
            spr.setUndecorated(true);
            spr.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
            spr.setAlwaysOnTop(true);
            spr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            spr.setVisible(true);

            scheduler.execute(vkshift[0]);
            //16


        };
        setupJComponent(sprint, sprintlistener);

        JMenuItem autowalk = new JMenuItem("Auto Walk");
        ActionListener autowalklistener = e -> {

           //vk_w
            scheduler.execute(vkw[0]);


        };
        setupJComponent(autowalk, autowalklistener);


        JMenuItem Presence = new JMenuItem("Discord RPC");
        ActionListener DiscordRPC = e -> {

            RichPresence RPC = new RichPresence();
            RPC.Status();

        };
        setupJComponent(Presence, DiscordRPC);

        JMenuItem cancel = new JMenuItem("Remove");
        b.add(cancel);
        cancel.addActionListener(e -> {

            if(!isCancelled.get()) {
                menuItems.keySet().forEach(actionListener -> menuItems.get(actionListener).removeActionListener(actionListener));
                vkshift[0].stopHolding();
                vkw[0].stopHolding();
                isCancelled.set(true);
            } else {
                menuItems.keySet().forEach(actionListener -> menuItems.get(actionListener).addActionListener(actionListener));
                vkshift[0] = new KeyHolder(KeyEvent.VK_SHIFT, r);
                vkw[0] = new KeyHolder(KeyEvent.VK_W, r);
                scheduler.execute(vkshift[0]);
                isCancelled.set(false);
            }


        });

        JMenuItem exit = new JMenuItem("Exit");
        b.add(exit);
        exit.addActionListener(e -> {
            System.out.println("Mod ended");


            try {
                vkshift[0].stopHolding();
                Robot lightoff = new Robot();

                lightoff.keyRelease(84);



            } catch (AWTException awtException) {
                awtException.printStackTrace();
            }


            System.exit(0);

        });


    }

    private void setupJComponent(JMenuItem jMenuItem, ActionListener actionListener) {
        menuItems.put(actionListener, jMenuItem);
        b.add(jMenuItem);
        jMenuItem.addActionListener(actionListener);



    }

}
