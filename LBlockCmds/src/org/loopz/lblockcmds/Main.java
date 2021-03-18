package org.loopz.lblockcmds;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new Blocked(), this);
		File file = new File(getDataFolder(), "config.yml");

		if (!file.exists()) saveDefaultConfig();
		Bukkit.getConsoleSender().sendMessage("§a[LBlockCmds] - Iniciado com sucesso.");
	}

	public void onDisable() {
		HandlerList.unregisterAll();
		Bukkit.getConsoleSender().sendMessage("§c[LBlockCmds] - Desligado com sucesso.");
	}

}
