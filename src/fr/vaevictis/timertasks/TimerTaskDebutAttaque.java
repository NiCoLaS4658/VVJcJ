package fr.vaevictis.timertasks;

import java.util.TimerTask;

import fr.vaevictis.main.Ville;

public class TimerTaskDebutAttaque extends TimerTask {
	
	public TimerTaskDebutAttaque(int ville)
	{
		super();
		this.ville = ville;
	}

	@Override
	public void run()
	{
		Ville.villes[ville].setTimerDebutAttaqueTermine(true);
	}
	
	private int ville;
}
