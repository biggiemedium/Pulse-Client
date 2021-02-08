package mod;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion;

import java.net.URL;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Game {

    public void OnScreen() throws IOException {
        JFrame frame = new JFrame();
        JPanel p = new JPanel();
        JMenuBar jmb = new JMenuBar();
        JMenu b = new JMenu("MOD");
        p.add(jmb);
        p.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        frame.add(p);
        frame.setLocation(1870, 0);
        frame.setSize(50, 30);
        frame.setBackground(Color.GRAY);
        frame.setAlwaysOnTop(true);
        frame.setUndecorated(true);
        frame.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        frame.setDefaultCloseOperation(2);
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
        toggled.setDefaultCloseOperation(3);
        toggled.setVisible(true);
        jmb.add(b);
        jmb.setBorderPainted(true);
        jmb.setBackground(Color.gray);
        JMenuItem brightness = new JMenuItem("Brightness");
        b.add(brightness);
        brightness.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread light = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        //boolean lights = false;

                        JFrame brighton = new JFrame();
                        JLabel bl = new JLabel("Brightness");
                        bl.setForeground(Color.WHITE);
                        brighton.add(bl);
                        brighton.setLocation(30, 20);
                        brighton.setUndecorated(true);
                        brighton.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
                        brighton.setSize(100, 50);
                        brighton.setDefaultCloseOperation(3);
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



                    }
                });
                light.start();
            }
        });
        JMenuItem wiki = new JMenuItem("Wiki");
        b.add(wiki);
        wiki.addActionListener(new ActionListener() {
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
        JMenuItem sprint = new JMenuItem("Sprint");
        b.add(sprint);
        sprint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                JFrame spr = new JFrame();
                JLabel tit = new JLabel("Sprint");

                tit.setForeground(Color.WHITE);
                spr.add(tit);
                spr.setLocation(30, -20);
                spr.setSize(100, 100);
                spr.setUndecorated(true);
                spr.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
                spr.setAlwaysOnTop(true);
                spr.setDefaultCloseOperation(3);
                spr.setVisible(true);
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Robot r = new Robot();
                            while (true) {
                                r.delay(2000);
                                r.keyPress(16);
                            }
                        }
                        catch (AWTException awtException) {
                            awtException.printStackTrace();
                        }
                    }
                });
                t.start();
            }
        });

        JMenuItem autowalk = new JMenuItem("Auto Walk");
        b.add(autowalk);
        autowalk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Thread runable = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Robot r = new Robot();
                            while(true) {
                                r.delay(2000);
                                r.keyPress(KeyEvent.VK_W);

                            }
                        } catch (AWTException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                runable.start();
            }
        });


        JMenuItem Presence = new JMenuItem("Discord RPC");
        b.add(Presence);
        Presence.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                RichPresence RPC = new RichPresence();
                RPC.Status();

            }
        });

        JMenuItem cancel = new JMenuItem("Remove");
        b.add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource().equals(cancel)) {
                    sprint.removeActionListener(this);
                    brightness.removeActionListener(this);
                    autowalk.removeActionListener(this);


                }

            }
        });

        JMenuItem exit = new JMenuItem("Exit");
        b.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.out.println("Mod ended");

                Robot shiftup = null;
                try {
                    shiftup = new Robot();
                } catch (AWTException awtException) {
                    awtException.printStackTrace();
                }
                shiftup.keyRelease(16);

                try {
                    Robot lightoff = new Robot();

                    lightoff.keyRelease(84);
                } catch (AWTException awtException) {
                    awtException.printStackTrace();
                }

                System.exit(0);
            }
        });



    }
}
