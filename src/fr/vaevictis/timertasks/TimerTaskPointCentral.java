package fr.vaevictis.timertasks;

import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.zcore.persist.PlayerEntity;

import fr.vaevictis.main.Etat;
import fr.vaevictis.main.VVJcJ;
import fr.vaevictis.main.VVJcJListener;
import fr.vaevictis.main.Ville;

public class TimerTaskPointCentral extends TimerTask {
	public TimerTaskPointCentral(VVJcJ plugin)
	{
		super();
		this.plugin = plugin;
	}
	VVJcJ plugin;

	@Override
	public void run()
	{
		Ville.villes.get(Ville.villeAttaquee).pc.setEtat(Etat.TERMINE);
		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "La ville " + Ville.villes.get(Ville.villeAttaquee).getNom() + " a ete prise.");
		Ville.villes.get(Ville.villeAttaquee).setFaction(FPlayers.i.get(Bukkit.getServer().getPlayer(plugin.getListener().playerAttaquant)).getFactionId());
		Ville.villes.get(Ville.villeAttaquee).ap.setEtat(Etat.INACTIVABLE);
		Ville.villes.get(Ville.villeAttaquee).a.setEtat(Etat.INACTIVABLE);
		Ville.villes.get(Ville.villeAttaquee).b.setEtat(Etat.INACTIVABLE);
		Ville.villes.get(Ville.villeAttaquee).c.setEtat(Etat.INACTIVABLE);
		Ville.villes.get(Ville.villeAttaquee).pc.setEtat(Etat.INACTIVABLE);
		plugin.resetTasksIDs();
		plugin.getListener().playerAttaquant = "";
		Ville.villeAttaquee = -1;
	}
}
