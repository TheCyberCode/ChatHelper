package dev.thecybercode.plugin.chathelper.code.system;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * @author TheCyberCode
 * 
 * Package: dev.thecybercode.plugin.chathelper.code.system
 * Project: ChatHelper
 *
 * TheCyberCode
 * This code is made by TheCyberCode (You may not claim any of this code as your own, you also are not allowed to distrubute any of my plugins or code or sell it!)
 */
public class ChatL {
String Colour = "&f";
	public static void Seperator(String Colour){
		dev.thecybercode.plugin.chathelper.code.system.ChatEvents.sendSep(Colour);
	}

	public static Plugin getPlugin(){
		return Bukkit.getServer().getPluginManager().getPlugin("ChatHelper");
	}

	public static List<Player> sepUser = new ArrayList<>();

	public static List<Player> sepGet(){
		return sepUser;		
	}

	public static void sepAdd(Player p){
		sepUser.add(p);		
	}

	public static void sepRemove(Player p){
		sepUser.remove(p);
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