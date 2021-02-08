import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loading {

    public void Loading() throws InterruptedException {

        JFrame f = new JFrame("Loading");
        JPanel panel = new JPanel(null);
        JLabel loading = new JLabel("Loading... ");
        JProgressBar progressBar = new JProgressBar();


        panel.add(progressBar);
        panel.add(loading);

        loading.setBounds(70, 10, 80, 100);

        progressBar.setMinimum(0);
        progressBar.setMaximum(100);



            progressBar.setSize(150, 30);
            progressBar.setLocation(25, 100);

            f.add(panel);
            f.setLocation(800, 300);
            f.setBackground(Color.white);
            f.setUndecorated(true);
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.setSize(200, 200);
            f.setVisible(true);

            long start = System.currentTimeMillis();
            Thread.sleep(2000);

            progressBar.setValue(100);


            f.setVisible(false);
            progressBar.setVisible(false);


    }
}

