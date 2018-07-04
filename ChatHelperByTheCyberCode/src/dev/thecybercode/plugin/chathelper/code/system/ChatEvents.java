package dev.thecybercode.plugin.chathelper.code.system;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.myzelyam.api.vanish.VanishAPI;

/**
 * @author TheCyberCode
 * 
 * Package: dev.thecybercode.plugin.chathelper.code.system
 * Project: ChatHelper
 *
 * TheCyberCode
 * This code is made by TheCyberCode (You may not claim any of this code as your own, you also are not allowed to distrubute any of my plugins or code or sell it!)
 */
public class ChatEvents implements Listener {

	public ChatEvents() {
		// TODO Auto-generated constructor stub
	}


	public static void sendSep(String Colour) {
		for (Player User : dev.thecybercode.plugin.chathelper.code.system.ChatL.sepGet()) {
			User.sendMessage(ChatColor.translateAlternateColorCodes('&', Colour + "-----------------------------------------------------"));
		}
	}






	@EventHandler 
	public void chatEvent(AsyncPlayerChatEvent chat) {

		if(VanishAPI.isInvisible(chat.getPlayer())){
			Bukkit.getLogger().info("[ChatHelper] " + chat.getPlayer().getName() + " is vanished so the seperator was not sent!");
			return;
		}
		if(chat.isCancelled()){
			return;
		}
		if(!chat.isCancelled()){
			sendSep("&3");
			return;
		}
	}

	@EventHandler 
	public void joinEvent(PlayerJoinEvent e) {
		if(VanishAPI.isInvisible(e.getPlayer())){
			Bukkit.getLogger().info("[ChatHelper] " + e.getPlayer().getName() + " is vanished so the seperator was not sent!");
			return;
		}
		sendSep("&3");
		return;

	}
	@EventHandler 
	public void leaveEvent(PlayerQuitEvent e) {
		if(VanishAPI.isInvisible(e.getPlayer())){
			Bukkit.getLogger().info("[ChatHelper] " + e.getPlayer().getName() + " is vanished so the seperator was not sent!");
			return;
		}
		sendSep("&3");
		return;

	}

}








/**
 * @author TheCyberCode
 * 
 * Package: dev.thecybercode.plugin.chathelper.code.system
 * Project: ChatHelper
 *
 * TheCyberCode
 * This code is made by TheCyberCode (You may not claim any of this code as your own, you also are not allowed to distrubute any of my plugins or code or sell it!)
 */