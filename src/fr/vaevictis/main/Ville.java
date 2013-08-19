package fr.vaevictis.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import fr.vaevictis.timertasks.TimerTaskDebutAttaque;

public class Ville
{
	
	public Ville(String nom, boolean capitale)
	{
		this.nom = nom;
		this.capitale = capitale;
		this.numero = nombreVilles;
		nombreVilles++;
		this.ap = new Point(this.numero);
		this.a = new Point(this.numero);
		this.b = new Point(this.numero);
		this.c = new Point(this.numero);
		this.pc = new Point(this.numero);
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
	private String factionId;
	
	public String getFaction() {return factionId;}
	public void setFaction(String id)
	{
		this.factionId = id;
	}
	
	
	public static ArrayList<Ville> villes;
	public static int nombreVilles;
	public static int villeAttaquee;
	
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
		config.set(path + ".a.w", this.a.getLocation().getWorld().getName());
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
		config.set(path + ".faction", this.getFaction());
	}
	
	public static void annulerAttaque(VVJcJListener listener)
	{
		if (Ville.villes.get(Ville.villeAttaquee).ap.getEtat() == Etat.ACTIVE)
		{
			Bukkit.getServer().getScheduler().cancelTask(listener.apTaskId);
		}
		if (Ville.villes.get(Ville.villeAttaquee).a.getEtat() == Etat.ACTIVE)
		{
			Bukkit.getServer().getScheduler().cancelTask(listener.aTaskId);
		}
		if (Ville.villes.get(Ville.villeAttaquee).b.getEtat() == Etat.ACTIVE)
		{
			Bukkit.getServer().getScheduler().cancelTask(listener.bTaskId);
		}
		if (Ville.villes.get(Ville.villeAttaquee).c.getEtat() == Etat.ACTIVE)
		{
			Bukkit.getServer().getScheduler().cancelTask(listener.cTaskId);
		}
		if (Ville.villes.get(Ville.villeAttaquee).pc.getEtat() == Etat.ACTIVE)
		{
			Bukkit.getServer().getScheduler().cancelTask(listener.pcTaskId);
		}
		if (listener.taskIdAnnulerAttaque30 != -1)
		{
			Bukkit.getServer().getScheduler().cancelTask(listener.taskIdAnnulerAttaque30);
		}
		if (listener.taskIdAnnulerAttaque60 != -1)
		{
			Bukkit.getServer().getScheduler().cancelTask(listener.taskIdAnnulerAttaque60);
		}
		Ville.villes.get(Ville.villeAttaquee).ap.setEtat(Etat.INACTIVABLE);
		Ville.villes.get(Ville.villeAttaquee).a.setEtat(Etat.INACTIVABLE);
		Ville.villes.get(Ville.villeAttaquee).b.setEtat(Etat.INACTIVABLE);
		Ville.villes.get(Ville.villeAttaquee).c.setEtat(Etat.INACTIVABLE);
		Ville.villes.get(Ville.villeAttaquee).pc.setEtat(Etat.INACTIVABLE);
		listener.resetTasksIds();
		listener.playerAttaquant = "";
		Ville.villeAttaquee = -1;
	}
}