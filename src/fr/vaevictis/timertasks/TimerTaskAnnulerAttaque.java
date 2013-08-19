package fr.vaevictis.timertasks;

import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import fr.vaevictis.main.VVJcJListener;
import fr.vaevictis.main.Ville;

public class TimerTaskAnnulerAttaque extends TimerTask
{
	private VVJcJListener listener;

	public TimerTaskAnnulerAttaque(VVJcJListener listener)
	{
		super();
		this.listener = listener;
	}

	@Override
	public void run()
	{
		Ville.annulerAttaque(listener);
		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "L'attaque a échoué car le point n'a pas été activé à temps !");
	}
	
	
}
