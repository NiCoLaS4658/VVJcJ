package fr.vaevictis.main;

import org.bukkit.Location;

public class Point {
	
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
		this.etat = e;
	}
	
	private Location location;
	private Etat etat;
	private int villeCorrespondante;
}
