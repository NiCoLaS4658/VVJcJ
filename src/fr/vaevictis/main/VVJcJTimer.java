package fr.vaevictis.main;

import java.util.Timer;
import java.util.TimerTask;

import fr.vaevictis.timertasks.TimerTaskDebutAttaque;

public class VVJcJTimer extends Timer{
	
	public void debutAttaque(int ville)
	{
		super.schedule(new TimerTaskDebutAttaque(ville), 600000);
	}
	
	

}
