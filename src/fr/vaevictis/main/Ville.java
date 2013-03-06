package fr.vaevictis.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class Ville
{
	
	public Ville(String nom, boolean capitale)
	{
		this.nom = nom;
		this.capitale = capitale;
		this.numero = nombreVilles;
		nombreVilles++;
		this.timerDebutAttaqueTermine = false;
		this.ap = new Point(this.numero);
		this.a = new Point(this.numero);
		this.b = new Point(this.numero);
		this.c = new Point(this.numero);
		this.pc = new Point(this.numero);
	}

	
	public boolean attaquer()
	{
		Ville.villeAttaquee = this.numero;
		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Debut de prise de la ville " + this.getNom() + ". La bataille commence dans 10 minutes.");
		TimerDebutAttaque timerDebutAttaque = new TimerDebutAttaque();
		timerDebutAttaque.lancer();		
		while(!this.timerDebutAttaqueTermine) {}
		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Debut de la bataille. Etape : Avant-poste.");
		this.ap.setEtat(Etat.DESACTIVE);
		while(this.ap.getEtat() != Etat.TERMINE)
		{
			if (Ville.villeAttaquee == -1)
			{
				Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "La prise de la ville " + this.getNom() + " a echoue.");
				return false;
			}
		}
		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "L'avant poste a ete pris. Etape : Prise des points A, B et C.");
		this.a.setEtat(Etat.DESACTIVE);
		this.b.setEtat(Etat.DESACTIVE);
		this.c.setEtat(Etat.DESACTIVE);
		while(this.a.getEtat() != Etat.TERMINE && this.b.getEtat() != Etat.TERMINE && this.c.getEtat() != Etat.TERMINE)
		{
			if (Ville.villeAttaquee == -1)
			{
				Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "La prise de la ville " + this.getNom() + " a echoue.");
				return false;
			}
		}
		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Les trois points ont ete pris. Etape : Prise du point central.");
		this.pc.setEtat(Etat.DESACTIVE);
		while(this.pc.getEtat() != Etat.TERMINE)
		{
			if (Ville.villeAttaquee == -1)
			{
				Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "La prise de la ville " + this.getNom() + " a echoue");
				return false;
			}
		}
		Bukkit.broadcastMessage(ChatColor.DARK_RED + "Le point central de la ville a ete pris.");
		Ville.villeAttaquee = -1;
		Bukkit.broadcastMessage(ChatColor.DARK_RED + "La prise de ville a reussi.");
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
	public boolean isCapitale() {return this.capitale;}
	
	private String nom;
	private int numero;
	public Point ap;
	public Point a;
	public Point b;
	public Point c;
	public Point pc;
	private boolean capitale;
	
	
	public static Ville[] villes;
	public static int nombreVilles;
	public static int villeAttaquee;
	
	/* Utilisé pour l'attaque */
	private boolean timerDebutAttaqueTermine;
	public void setTimerDebutAttaqueTermine(boolean b) {this.timerDebutAttaqueTermine = b;}
	
	public void save(VVJcJ plugin)
	{
		FileConfiguration config = plugin.getConfig();
		String path = "villes." + String.valueOf(this.numero);
		config.set(path + ".nom", this.nom);
		config.set(path + ".capitale", this.capitale);
		config.set(path + ".ap.w", this.ap.getLocation().getWorld().getName());
		config.set(path + ".ap.x", this.ap.getLocation().getBlockX());
		config.set(path + ".ap.y", this.ap.getLocation().getBlockY());
		config.set(path + ".ap.z", this.ap.getLocation().getBlockZ());
		config.set(path + ".ap.w", this.a.getLocation().getWorld().getName());
		config.set(path + ".a.x", this.a.getLocation().getBlockX());
		config.set(path + ".a.y", this.a.getLocation().getBlockY());
		config.set(path + ".a.z", this.a.getLocation().getBlockZ());
		config.set(path + ".b.w", this.b.getLocation().getWorld().getName());
		config.set(path + ".b.x", this.b.getLocation().getBlockX());
		config.set(path + ".b.y", this.b.getLocation().getBlockY());
		config.set(path + ".b.z", this.b.getLocation().getBlockZ());
		config.set(path + ".c.w", this.c.getLocation().getWorld().getName());
		config.set(path + ".c.x", this.c.getLocation().getBlockX());
		config.set(path + ".c.y", this.c.getLocation().getBlockY());
		config.set(path + ".c.z", this.c.getLocation().getBlockZ());
		config.set(path + ".pc.w", this.pc.getLocation().getWorld().getName());
		config.set(path + ".pc.x", this.pc.getLocation().getBlockX());
		config.set(path + ".pc.y", this.pc.getLocation().getBlockY());
		config.set(path + ".pc.z", this.pc.getLocation().getBlockZ());
	}
}