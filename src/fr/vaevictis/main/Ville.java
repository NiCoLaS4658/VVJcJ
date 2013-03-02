package fr.vaevictis.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Ville {
	
	public Ville(String nom, boolean capitale)
	{
		this.nom = nom;
		this.capitale = capitale;
		nombreVilles++;
	}

	
	public void attaquer()
	{
		Bukkit.broadcastMessage("Début de prise de la ville " + this.getNom());
		
	}
	
	
	public String getNom() {return nom;}
	public void setap(Location l)
	{
		this.ap.setLocation(l);
	}
	public void seta(Location l)
	{
		this.a.setLocation(l);
	}
	public void setb(Location l)
	{
		this.b.setLocation(l);
	}
	public void setc(Location l)
	{
		this.c.setLocation(l);
	}
	public void setpc(Location l)
	{
		this.pc.setLocation(l);
	}
	private String nom;
	private Point ap = new Point(this);
	private Point a = new Point(this);
	private Point b = new Point(this);
	private Point c = new Point(this);
	private Point pc = new Point(this);
	private boolean capitale;
	
	
	public static Ville[] villes;
	public static int nombreVilles;
}
