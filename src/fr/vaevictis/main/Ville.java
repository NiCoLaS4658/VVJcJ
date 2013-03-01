package fr.vaevictis.main;

import org.bukkit.Location;

public class Ville {
	
	public Ville(String nom, boolean capitale)
	{
		this.nom = nom;
		this.capitale = capitale;
		nombreVilles++;
	}

	public void attaquer();
	{
		/** Methode utilisee attaquant la ville **/
	}
	
	
	public String getNom() {return nom;}
	public void setap(Location l)
	{
		this.ap = l;
	}
	public void seta(Location l)
	{
		this.a = l;
	}
	public void setb(Location l)
	{
		this.b = l;
	}
	public void setc(Location l)
	{
		this.c = l;
	}
	public void setpc(Location l)
	{
		this.pc = l;
	}
	private String nom;
	private Location ap;
	private Location a;
	private Location b;
	private Location c;
	private Location pc;
	private boolean capitale;
	public static Ville[] villes;
	public static int nombreVilles;
}
