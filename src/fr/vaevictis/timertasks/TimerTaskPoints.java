package fr.vaevictis.timertasks;

import java.util.TimerTask;

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
		}
		else if (point == 'b')
		{
			Ville.villes[Ville.villeAttaquee].b.setEtat(Etat.TERMINE);
		}
		else if (point == 'c')
		{
			Ville.villes[Ville.villeAttaquee].c.setEtat(Etat.TERMINE);
		}
	}
}
