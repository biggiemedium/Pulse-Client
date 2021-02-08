/*
package mod;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AutoWalk implements NativeKeyListener {

    public void forward() {

        String os = System.getProperty("os.name");


        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();

            System.exit(-1);

        }

        GlobalScreen.addNativeKeyListener(new AutoWalk());


        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);

        logger.setUseParentHandlers(false);

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e)
    {

    while(true) {
        final boolean Running = false;

        if(e.getKeyCode() == NativeInputEvent.ALT_L_MASK + NativeKeyEvent.VC_W) {

            if(Running == true) {
                Robot forw = null;

                forw.delay(2000);
                forw.keyPress(KeyEvent.VK_W);
            }

        }
     }


    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    }
}

 */
