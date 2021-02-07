package mod;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class RichPresence {

    public void Status() {

        DiscordRPC lib = DiscordRPC.INSTANCE;
        DiscordRichPresence presence = new DiscordRichPresence();
        String applicationId = "788856432778018866";
        String steamId       = "";

        DiscordEventHandlers handlers = new DiscordEventHandlers();


        lib.Discord_Initialize(applicationId, handlers, true, steamId);

        presence.startTimestamp = System.currentTimeMillis() / 1000;
        presence.largeImageKey = "nightsky1";
        presence.details   = "Getting Spooked";
        presence.state     = "Pulse Client by PX";
        lib.Discord_UpdatePresence(presence);

        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    lib.Discord_Shutdown();
                    break;
                }
            }
        }, "RPC-Callback-Handler");
        t.start();

    }
}


