package fr.vaevictis.timertasks;

import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Event;

import fr.vaevictis.events.TimerPointsTermineEvent;
import fr.vaevictis.main.Etat;
import fr.vaevictis.main.Ville;

public class TimerTaskPoints extends TimerTask
{
	private char point;

	public TimerTaskPoints(char point)
	{
		super();
		this.point = point;
	}

	@Override
	public void run() 
	{
		if (this.point == 'a')
		{
			Ville.villes.get(Ville.villeAttaquee).a.setEtat(Etat.TERMINE);
			Bukkit.broadcastMessage(ChatColor.DARK_RED + "Le point A a ete pris.");
			TimerPointsTermineEvent event = new TimerPointsTermineEvent();
			Bukkit.getServer().getPluginManager().callEvent(event);
		}
		else if (this.point == 'b')
		{
			Ville.villes.get(Ville.villeAttaquee).b.setEtat(Etat.TERMINE);
			Bukkit.broadcastMessage(ChatColor.DARK_RED + "Le point B a ete pris.");
			TimerPointsTermineEvent event = new TimerPointsTermineEvent();
			Bukkit.getServer().getPluginManager().callEvent(event);
		}
		else if (this.point == 'c')
		{
			Ville.villes.get(Ville.villeAttaquee).c.setEtat(Etat.TERMINE);
			Bukkit.broadcastMessage(ChatColor.DARK_RED + "Le point C a ete pris.");
			TimerPointsTermineEvent event = new TimerPointsTermineEvent();
			Bukkit.getServer().getPluginManager().callEvent(event);
		}
	}
}
