package fr.vaevictis.main;

import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ChangementEtatEvent extends Event
{
	
	private static final HandlerList handlers = new HandlerList();
	private Etat nouvelEtat;
	private Etat ancienEtat;
	private Location pointLocation;
	private int villeCorrespondante;
	
	public ChangementEtatEvent(Etat nouvelEtat)
	{
		this.nouvelEtat = nouvelEtat;
	}
	public ChangementEtatEvent(Etat nouvelEtat, Etat ancienEtat)
	{
		this.nouvelEtat = nouvelEtat;
		this.ancienEtat = ancienEtat;
	}
	public ChangementEtatEvent(Etat nouvelEtat, Etat ancienEtat, Location pointLocation, int villeCorrespondante)
	{
		this.nouvelEtat = nouvelEtat;
		this.ancienEtat = ancienEtat;
		this.pointLocation = pointLocation;
		this.villeCorrespondante = villeCorrespondante;
	}
	public Etat getNouvelEtat() {return this.nouvelEtat;}
	public Etat getAncienEtat() {return this.ancienEtat;}
	public Point getPoint() 
	{
		if (Ville.villes.get(villeCorrespondante).ap.getLocation() == this.pointLocation)
		{
			return Ville.villes.get(villeCorrespondante).ap;
		}
		else if (Ville.villes.get(villeCorrespondante).a.getLocation() == this.pointLocation)
		{
			return Ville.villes.get(villeCorrespondante).a;
		}
		else if (Ville.villes.get(villeCorrespondante).b.getLocation() == this.pointLocation)
		{
			return Ville.villes.get(villeCorrespondante).b;
		}
		else if (Ville.villes.get(villeCorrespondante).c.getLocation() == this.pointLocation)
		{
			return Ville.villes.get(villeCorrespondante).c;
		}
		else if (Ville.villes.get(villeCorrespondante).pc.getLocation() == this.pointLocation)
		{
			return Ville.villes.get(villeCorrespondante).pc;
		}
		else 
		{
			return null;
		}
	}
	
	public int getVille() {return this.villeCorrespondante;}
	public Location getLocation() {return this.pointLocation;}
	public HandlerList getHandlers()
	{
		return handlers;
	}
	public static HandlerList getHandlerList()
	{
		return handlers;
	}
}
