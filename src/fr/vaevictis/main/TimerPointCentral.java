package fr.vaevictis.main;

import java.util.Timer;

import fr.vaevictis.timertasks.TimerTaskPointCentral;

public class TimerPointCentral extends Timer
{
	public void lancer()
	{
		schedule(new TimerTaskPointCentral(), 3600000);
	}
}
