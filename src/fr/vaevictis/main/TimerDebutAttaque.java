package fr.vaevictis.main;

import java.util.Timer;
import java.util.TimerTask;

import fr.vaevictis.timertasks.TimerTaskAvantPoste;
import fr.vaevictis.timertasks.TimerTaskDebutAttaque;

public class TimerDebutAttaque extends Timer
{	
	public void lancer()
	{
		schedule(new TimerTaskDebutAttaque(), 600000);
	}
}
