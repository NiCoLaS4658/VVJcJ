package fr.vaevictis.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Ville
{
	
	public Ville(String nom, boolean capitale)
	{
		this.nom = nom;
		this.capitale = capitale;
		this.numero = nombreVilles;
		nombreVilles++;
		this.timerDebutAttaqueTermine = false;
	}

	
	public boolean attaquer()
	{
		Ville.villeAttaquee = this.numero;
		Bukkit.getServer().broadcastMessage("Debut de prise de la ville " + this.getNom() + ". La bataille commence dans 10 minutes.");
		TimerDebutAttaque timerDebutAttaque = new TimerDebutAttaque();
		timerDebutAttaque.lancer();		
		while(!this.timerDebutAttaqueTermine) {}
		Bukkit.getServer().broadcastMessage("Debut de la bataille. Etape : Avant-poste.");
		this.ap.setEtat(Etat.DESACTIVE);
		while(this.ap.getEtat() != Etat.TERMINE)
		{
			if (Ville.villeAttaquee == -1)
			{
				Bukkit.getServer().broadcastMessage("La prise de la ville " + this.getNom() + " a echoue.");
				return false;
			}
		}
		Bukkit.getServer().broadcastMessage("L'avant poste a ete pris. Etape : Prise des points A, B et C.");
		this.a.setEtat(Etat.DESACTIVE);
		this.b.setEtat(Etat.DESACTIVE);
		this.c.setEtat(Etat.DESACTIVE);
		while(this.a.getEtat() != Etat.TERMINE && this.b.getEtat() != Etat.TERMINE && this.c.getEtat() != Etat.TERMINE)
		{
			if (Ville.villeAttaquee == -1)
			{
				Bukkit.getServer().broadcastMessage("La prise de la ville " + this.getNom() + " a echoue.");
				return false;
			}
		}
		Bukkit.getServer().broadcastMessage("Les trois points ont ete pris. Etape : Prise du point central.");
		this.pc.setEtat(Etat.DESACTIVE);
		while(this.pc.getEtat() != Etat.TERMINE)
		{
			if (Ville.villeAttaquee == -1)
			{
				Bukkit.getServer().broadcastMessage("La prise de la ville " + this.getNom() + " a echoue");
				return false;
			}
		}
		Bukkit.broadcastMessage("Le point central de la ville a ete pris.");
		Ville.villeAttaquee = -1;
		Bukkit.broadcastMessage("La prise de ville a reussi.");
		this.timerDebutAttaqueTermine = false;
		return true;
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
	public boolean isCapitale() {return capitale;}
	private String nom;
	private int numero;
	public Point ap = new Point(this.numero);
	public Point a = new Point(this.numero);
	public Point b = new Point(this.numero);
	public Point c = new Point(this.numero);
	public Point pc = new Point(this.numero);
	private boolean capitale;
	
	
	public static Ville[] villes;
	public static int nombreVilles;
	public static int villeAttaquee;
	
	/* Utilisé pour l'attaque */
	private boolean timerDebutAttaqueTermine;
	public void setTimerDebutAttaqueTermine(boolean b) {this.timerDebutAttaqueTermine = b;}
}
