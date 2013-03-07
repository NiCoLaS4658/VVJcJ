package fr.vaevictis.timertasks;

import java.util.TimerTask;

import org.bukkit.Bukkit;

import fr.vaevictis.events.TimerAvantPosteTermineEvent;
import fr.vaevictis.main.Etat;
import fr.vaevictis.main.VVJcJListener;
import fr.vaevictis.main.Ville;

public class TimerTaskAvantPoste extends TimerTask
{
	@Override
	public void run() 
	{
		Ville.villes.get(Ville.villeAttaquee).ap.setEtat(Etat.TERMINE);
		TimerAvantPosteTermineEvent event = new TimerAvantPosteTermineEvent();
		Bukkit.getServer().getPluginManager().callEvent(event);
	}	
}
