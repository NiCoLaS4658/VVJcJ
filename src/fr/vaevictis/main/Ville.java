package fr.vaevictis.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Ville {
	
	public Ville(String nom, boolean capitale)
	{
		this.nom = nom;
		this.capitale = capitale;
		this.numero = nombreVilles;
		nombreVilles++;
		this.timerDebutAttaqueTermine = false;
	}

	
	public void attaquer()
	{
		Bukkit.broadcastMessage("Début de prise de la ville " + this.getNom() + ". La bataille commence dans 10 minutes.");
		while(!this.timerDebutAttaqueTermine) {}
		Bukkit.broadcastMessage("Début de la bataille. Etape : Avant-poste.");
		/** Continuer le systeme de prise de ville **/
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
	private int numero;
	private Point ap = new Point(this.numero);
	private Point a = new Point(this.numero);
	private Point b = new Point(this.numero);
	private Point c = new Point(this.numero);
	private Point pc = new Point(this.numero);
	private boolean capitale;
	
	
	public static Ville[] villes;
	public static int nombreVilles;
	
	/* Utilisé pour l'attaque */
	private boolean timerDebutAttaqueTermine;
	public void setTimerDebutAttaqueTermine(boolean b) {this.timerDebutAttaqueTermine = b;}
}
