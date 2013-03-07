package fr.vaevictis.timertasks;

import java.util.TimerTask;

import org.bukkit.Bukkit;

import fr.vaevictis.events.TimerDebutAttaqueTermineEvent;
import fr.vaevictis.main.Etat;
import fr.vaevictis.main.Ville;

public class TimerTaskDebutAttaque extends TimerTask
{
	@Override
	public void run()
	{
		TimerDebutAttaqueTermineEvent event = new TimerDebutAttaqueTermineEvent();
		Bukkit.getServer().getPluginManager().callEvent(event);
	}
}
