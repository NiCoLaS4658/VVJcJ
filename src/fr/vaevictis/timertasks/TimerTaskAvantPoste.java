package fr.vaevictis.timertasks;

import java.util.TimerTask;

import fr.vaevictis.main.Etat;
import fr.vaevictis.main.VVJcJListener;
import fr.vaevictis.main.Ville;

public class TimerTaskAvantPoste extends TimerTask
{
	public TimerTaskAvantPoste()
	{
		super();
	}

	@Override
	public void run() 
	{
		Ville.villes[Ville.villeAttaquee].ap.setEtat(Etat.TERMINE);
	}	
}
