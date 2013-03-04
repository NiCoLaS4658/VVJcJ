package fr.vaevictis.timertasks;

import java.util.TimerTask;

import org.bukkit.Bukkit;

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
		if (point == 'a')
		{
			Ville.villes[Ville.villeAttaquee].a.setEtat(Etat.TERMINE);
			Bukkit.broadcastMessage("Le point A a ete pris.");
		}
		else if (point == 'b')
		{
			Ville.villes[Ville.villeAttaquee].b.setEtat(Etat.TERMINE);
			Bukkit.broadcastMessage("Le point B a ete pris.");
		}
		else if (point == 'c')
		{
			Ville.villes[Ville.villeAttaquee].c.setEtat(Etat.TERMINE);
			Bukkit.broadcastMessage("Le point C a ete pris.");
		}
	}
}
