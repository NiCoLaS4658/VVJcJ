package fr.vaevictis.timertasks;

import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import fr.vaevictis.main.Etat;
import fr.vaevictis.main.Ville;

public class TimerTaskPointCentral extends TimerTask {

	@Override
	public void run()
	{
		Ville.villes.get(Ville.villeAttaquee).pc.setEtat(Etat.TERMINE);
		Bukkit.getServer().broadcastMessage(ChatColor.RED + "La ville " + Ville.villes.get(Ville.villeAttaquee).getNom() + " a ete prise.");
		Ville.villeAttaquee = -1;
	}
}
