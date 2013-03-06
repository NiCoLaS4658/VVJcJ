package fr.vaevictis.timertasks;

import java.util.TimerTask;

import fr.vaevictis.main.Etat;
import fr.vaevictis.main.Ville;

public class TimerTaskPointCentral extends TimerTask {

	@Override
	public void run()
	{
		Ville.villes.get(Ville.villeAttaquee).pc.setEtat(Etat.TERMINE);
	}
}
