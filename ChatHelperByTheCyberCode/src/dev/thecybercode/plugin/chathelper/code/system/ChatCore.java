package dev.thecybercode.plugin.chathelper.code.system;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;
import de.myzelyam.api.vanish.VanishAPI;
import de.myzelyam.api.vanish.PlayerHideEvent;

/**
 * @author TheCyberCode
 * 
 * Package: dev.thecybercode.plugin.chathelper.code.system
 * Project: ChatHelper
 *
 * TheCyberCode
 * This code is made by TheCyberCode (You may not claim any of this code as your own, you also are not allowed to distribute any of my plugins or code or sell it!)
 */
@SuppressWarnings("unused")
public class ChatCore implements CommandExecutor {
	ChatL chatH;
	@Override
	public boolean onCommand(CommandSender Sender, Command cmd, String label, String[] args) {
		if(!(Sender instanceof Player)){
			Sender.sendMessage("Only players can use this command");
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("chatsep")){
			Player p = (Player) Sender;
			if(args.length != 1){
				Bukkit.dispatchCommand(Sender, "chatsep " + Sender.getName());
				return true;
			}


			if(args[0].equalsIgnoreCase("list")) {
				if(Sender.isOp() || Sender.hasPermission("ChatHelper.Admin")) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6List: &3" +  ChatL.sepGet().toString().replace("CraftPlayer{name=", "").replace("}", "").replace("{","").replace("[", "").replace("]", "")));
					return true;
				}
				if(!Sender.hasPermission("ChatHelper.Admin") && (!Sender.isOp())) {
					Sender.sendMessage(ChatColor.RED + "You must be an admin or higher to use this command!");
					return true;
				}
				return true;
			}
			if(args[0].equalsIgnoreCase("help")) {
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3&l=-=-=-=-=-=-=-=-=-ChatHelper-=-=-=-=-=-=-=-=-="));
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3&l                      By &6&lTheCyberCode                 "));
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3"));
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3&l                         &nCommands:&r            "));
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3"));
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/ChatSeperator &3- Toggles the line seperators"));
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/ChatSeperator List &3- Brings up the list of players."));
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/ChatSeperator <Player> &3- Toggles line seperators for other players."));
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3"));
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3&l                         &nPermissions:&r         "));
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3"));
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/ChatSeperator &3- ChatHelper.Basic"));
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/ChatSeperator List &3- ChatHelper.Admin or OP"));
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/ChatSeperator <Player> &3- ChatHelper.Admin or OP"));
					Sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3&l=-=-=-=-=-=-=-=-=-ChatHelper-=-=-=-=-=-=-=-=-="));
				return true;
			}

			if(args.length == 1){

				if(Bukkit.getServer().getPlayer(args[0]) == null){
					p.sendMessage(ChatColor.RED + args[0] + " is not online");
					return true;
				}
				Player user = (Player) Sender;
				if(!user.hasPermission("ChatHelper.Basic")){
					user.sendMessage(ChatColor.DARK_AQUA + "You do not have access to this feature!");
					return true;
				}

				Player t = Bukkit.getServer().getPlayer(args[0]);
				
				
				if(VanishAPI.isInvisible(t)){
					p.sendMessage(ChatColor.RED + args[0] + " is not online");
					return true;
				}

				if(!(Sender == t)) {
					if(Sender.hasPermission("ChatHelper.Admin")) {
						user.sendMessage(ChatColor.DARK_AQUA + "Admin override Activated!");
					}
					if(!Sender.hasPermission("ChatHelper.Admin")) {
						Sender.sendMessage(ChatColor.RED + "You must be an admin or higher to use this command!");
						return true;
					}

					if(!t.hasPermission("ChatHelper.Admin")) {
						if(!(p == t)) {
							p.sendMessage(ChatColor.DARK_AQUA + "[Admin Only] You are not authorised to enable chat helper mode for  " + t.getDisplayName() + "!");	
							return true;
						}

					}
				}

				if(t.isOp()){
					if(!(p == t)) {
						p.sendMessage(ChatColor.DARK_AQUA + "[Player is opped] You are not authorised to enable chat helper mode for  " + t.getDisplayName() + "!");		
						return true;
					}

				}

				if(ChatL.sepGet().contains(t)){
					ChatL.sepRemove(t);
					t.sendMessage(ChatColor.DARK_AQUA + "Your Chat Seperator was disabled!");
					if(!(p == t)) {
						p.sendMessage(ChatColor.DARK_AQUA + "You have disabled chat seperator for:  " + t.getDisplayName());
					}
					return true;
				}else{
					ChatL.sepAdd(t);
					t.sendMessage(ChatColor.DARK_AQUA + "Your Chat Seperator was enabled!");
					if(!(p == t)) {
						p.sendMessage(ChatColor.DARK_AQUA + "Chat Seperator Enabled for:  " + t.getDisplayName());
					}
					return true;

				}
			}
		}
		return false;
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