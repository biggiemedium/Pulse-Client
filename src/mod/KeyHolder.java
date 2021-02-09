package mod;

import java.awt.*;

public class KeyHolder implements Runnable {
    private volatile boolean keepholding = true;
    private final int KeyCode;
    private final Robot r;


    public KeyHolder(int keyCode, Robot r) {
        this.KeyCode = keyCode;
        this.r = r;
    }

    public void startHolding() {
        keepholding = true;
        KeepHolding();
    }

    public void stopHolding() {
        keepholding = false;
        r.keyRelease(KeyCode);
    }

    private void KeepHolding() {
        while(keepholding) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r.keyPress(KeyCode);
        }
    }


    @Override
    public void run() {
        KeepHolding();

    }
}
