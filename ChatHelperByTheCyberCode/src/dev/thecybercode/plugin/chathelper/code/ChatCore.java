package dev.thecybercode.plugin.chathelper.code;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

/**
 * @author TheCyberCode
 * 
 * Package: dev.thecybercode.plugin.chathelper.code
 * Project: ChatHelper
 *
 * TheCyberCode
 * This code is made by TheCyberCode (You may not claim any of this code as your own, you also are not allowed to distribute any of my plugins or code or sell it!)
 */
public class ChatCore extends JavaPlugin implements Listener{

	public void onEnable(){
		if(Bukkit.getServer().getPluginManager().getPlugin("CyberChat")!=null) {
			Bukkit.getLogger().severe("[ChatHelper] Another version of this plugin found, shutting down.");
			Bukkit.getPluginManager().disablePlugin(this);
		}
		dev.thecybercode.plugin.chathelper.code.system.ChatL.sepUser.clear();
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l-=-=-=-=-=-=-=-=-=-=-=-=-=-"));
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l         Chat Helper"));
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&l      Made by TheCyberCode"));
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&l            Enjoy!"));
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&l-=-=-=-=-=-=-=-=-=-=-=-=-=-"));
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new dev.thecybercode.plugin.chathelper.code.system.ChatEvents(), this);
		this.getCommand("chatsep").setExecutor(new dev.thecybercode.plugin.chathelper.code.system.ChatCore());
	}
	
	public void onDisable(){
	sendSepAlert("&3", "ChatHelper by TheCyberCode has been reloaded, so your seperator has been disabled, To ReEnable it do /ChatSep");	
	dev.thecybercode.plugin.chathelper.code.system.ChatL.sepUser.clear();
	}
	
	
	public static void sendSepAlert(String Colour, String Alert) {
		for (Player User : dev.thecybercode.plugin.chathelper.code.system.ChatL.sepGet()) {
			User.sendMessage(ChatColor.translateAlternateColorCodes('&', Colour + Alert));
		}
	}
}

/**
 * @author TheCyberCode
 * 
 * Package: dev.thecybercode.plugin.chathelper.code
 * Project: ChatHelper
 *
 * TheCyberCode
 * This code is made by TheCyberCode (You may not claim any of this code as your own, you also are not allowed to distrubute any of my plugins or code or sell it!)
 */