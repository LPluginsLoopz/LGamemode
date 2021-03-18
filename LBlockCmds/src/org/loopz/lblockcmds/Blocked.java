package org.loopz.lblockcmds;

import java.util.Iterator;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Blocked implements Listener {

	
	@EventHandler(priority = EventPriority.MONITOR)
    public void onCommandProcess(PlayerCommandPreprocessEvent event) {
        if (event.getMessage().startsWith("/")) {
            String command = event.getMessage().split(" ")[0].replace("/", "");
            List<String> bCmds = Main.getPlugin(Main.class).getConfig().getStringList("Commands");

            Iterator<String> var7 = bCmds.iterator();
            while (var7.hasNext()) {
              String c = var7.next();
            
            if (command.equalsIgnoreCase(c)) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(Main.getPlugin(Main.class).getConfig().getString("Message").replace("&", "§"));
            }
            }
        }
    }
	
	
}
