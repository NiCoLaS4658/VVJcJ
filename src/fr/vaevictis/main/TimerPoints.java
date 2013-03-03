package fr.vaevictis.main;

import java.util.Timer;

import fr.vaevictis.timertasks.TimerTaskPoints;

public class TimerPoints extends Timer
{
	public TimerPoints(char point)
	{
		this.point = point;
	}
	public void lancer()
	{
		long time = (Ville.villes[Ville.villeAttaquee].isCapitale()) ? 1800000 : 900000;
		schedule(new TimerTaskPoints(point), time);
	}
	private char point;
}
