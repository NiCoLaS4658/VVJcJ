package fr.vaevictis.main;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.*;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;

public class VVJcJ extends JavaPlugin
{
	private VVJcJListener listener;
	private Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable()
	{
		logger.info("VVJcJ est active.");
		listener = new VVJcJListener(this);
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(listener, this);
		Ville.nombreVilles = 0;
		Ville.villeAttaquee = -1;
		Ville.villes = new ArrayList();
		
		/* Systeme de recuperation des villes */
		FileConfiguration config = this.getConfig();
		int nombreVilles = config.getInt("nombreVilles");
		for (int i = 0 ; i < nombreVilles ; i++)
		{
			String path = "villes." + String.valueOf(i);
			if (config.get(path) != null && this.getServer().getWorld(config.getString(path + ".ap.w")) != null)
			{
				Ville.villes.add(new Ville((config.getString(path + ".nom")), (config.getBoolean(path + ".capitale"))));
				Ville.villes.get(i).setap(new Location(this.getServer().getWorld(config.getString(path + ".ap.w")) , config.getInt(path + ".ap.x"), config.getInt(path + ".ap.y"), config.getInt(path + ".ap.z")));
				Ville.villes.get(i).seta(new Location(this.getServer().getWorld(config.getString(path + ".a.w")) , config.getInt(path + ".a.x"), config.getInt(path + ".a.y"), config.getInt(path + ".a.z")));
				Ville.villes.get(i).setb(new Location(this.getServer().getWorld(config.getString(path + ".b.w")) , config.getInt(path + ".b.x"), config.getInt(path + ".b.y"), config.getInt(path + ".b.z")));
				Ville.villes.get(i).setc(new Location(this.getServer().getWorld(config.getString(path + ".c.w")) , config.getInt(path + ".c.x"), config.getInt(path + ".c.y"), config.getInt(path + ".c.z")));
				Ville.villes.get(i).setpc(new Location(this.getServer().getWorld(config.getString(path + ".pc.w")) , config.getInt(path + ".pc.x"), config.getInt(path + ".pc.y"), config.getInt(path + ".pc.z")));
				Ville.villes.get(i).setFaction(config.getString(path + ".faction"));
			}
		}
	}
	
	@Override
	public void onDisable()
	{
		/* Systeme de sauvegarde des villes */
		FileConfiguration config = this.getConfig();
		config.set("nombreVilles", Ville.nombreVilles);
		for (int i = 0 ; i < (Ville.villes.size()) ; i++)
		{
			Ville.villes.get(i).save(this);
		}
		this.saveConfig();
		Ville.villes.clear();
		logger.info("VVJcJ est desactive");
	}
	public void resetTasksIDs()
	{
		listener.resetTasksIds();
	}

	public VVJcJListener getListener() {return listener;}
}