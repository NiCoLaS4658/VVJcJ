package fr.vaevictis.timertasks;

import java.util.TimerTask;

import fr.vaevictis.main.Ville;

public class TimerTaskDebutAttaque extends TimerTask
{
	@Override
	public void run()
	{
		Ville.villes[Ville.villeAttaquee].setTimerDebutAttaqueTermine(true);
	}
}
