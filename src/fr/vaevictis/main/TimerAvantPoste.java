package fr.vaevictis.main;

import java.util.Timer;

import fr.vaevictis.timertasks.TimerTaskAvantPoste;

public class TimerAvantPoste extends Timer 
{
	public void lancer()
	{
		schedule(new TimerTaskAvantPoste(), 2700000);
	}
}
