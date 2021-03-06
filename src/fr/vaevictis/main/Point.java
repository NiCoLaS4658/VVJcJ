package fr.vaevictis.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import fr.vaevictis.events.ChangementEtatEvent;

public class Point
{
	
	public Point(int villeCorrespondante) 
	{
		this.etat = Etat.INACTIVABLE;
		this.villeCorrespondante = villeCorrespondante;
	}
	
	public Location getLocation() {return this.location;}
	public Etat getEtat() {return this.etat;}
	
	public void setLocation(Location l)
	{
		this.location = l;
	}
	public void setEtat(Etat e)
	{
		Etat e1 = etat;
		this.etat = e;
		ChangementEtatEvent event = new ChangementEtatEvent(e, e1, this.location, this.villeCorrespondante);
		Bukkit.getServer().getPluginManager().callEvent(event);
	}
	
	private Location location;
	private Etat etat;
	private int villeCorrespondante;
}
