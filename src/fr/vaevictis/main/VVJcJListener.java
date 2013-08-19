package fr.vaevictis.main;

import javax.swing.JTable.PrintMode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.scheduler.BukkitTask;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Factions;
import com.massivecraft.factions.listeners.FactionsPlayerListener;
import com.massivecraft.factions.struct.Rel;

import fr.vaevictis.events.AttaqueEvent;
import fr.vaevictis.events.ChangementEtatEvent;
import fr.vaevictis.events.TimerAvantPosteTermineEvent;
import fr.vaevictis.events.TimerDebutAttaqueTermineEvent;
import fr.vaevictis.events.TimerPointsTermineEvent;
import fr.vaevictis.timertasks.*;

public class VVJcJListener implements Listener
{
	
	public VVJcJListener(VVJcJ plugin)
	{
		this.plugin = plugin;
		this.apTaskId = -1;
		this.aTaskId = -1;
		this.bTaskId = -1;
		this.cTaskId = -1;
		this.pcTaskId = -1;
		this.taskIdAnnulerAttaque30 = -1;
		this.taskIdAnnulerAttaque60 = -1;
		this.playerAttaquant = "";
	}

	private VVJcJ plugin;
	
	/* giveLocationOfBlockPlacedByThePlayer */


	@EventHandler(priority = EventPriority.NORMAL)
	public void onBatailleBlockPlaced(BlockPlaceEvent event)
	{
		if (event.getBlock().getTypeId() == 232)
		{
			event.getPlayer().sendMessage("Position du bloc :");
			event.getPlayer().sendMessage("X : " + event.getBlock().getLocation().getBlockX());
			event.getPlayer().sendMessage("Y : " + event.getBlock().getLocation().getBlockY());
			event.getPlayer().sendMessage("Z : " + event.getBlock().getLocation().getBlockZ());
			event.getPlayer().sendMessage("Monde : " + event.getBlock().getLocation().getWorld().getName());
		}
	}
	/* giveLocationOfBlockPlacedByThePlayer */
	
	/* cancelBreakingBatailleBlock */
	@EventHandler(priority = EventPriority.NORMAL)
	public void cancelBreakingBatailleBlock(BlockBreakEvent event)
	{
		if (event.getBlock().getTypeId() == 232)
		{
			if (event.getPlayer().getItemInHand().getTypeId() != 7)
			{
				event.setCancelled(true);
			}
		}
		if (Ville.villeAttaquee != -1)
		{
			if (event.getBlock().getTypeId() == 232)
			{
				if(Factions.i.get(Ville.villes.get(Ville.villeAttaquee).getFaction()).getOnlinePlayers().contains(event.getPlayer()) || Factions.i.get(Ville.villes.get(Ville.villeAttaquee).getFaction()).getRelationTo(FPlayers.i.get(event.getPlayer()).getFaction()).equals(Rel.ALLY))
				{
					if (event.getBlock().getLocation().getBlockX() == Ville.villes.get(Ville.villeAttaquee).ap.getLocation().getBlockX() && event.getBlock().getLocation().getBlockY() == Ville.villes.get(Ville.villeAttaquee).ap.getLocation().getBlockY() && event.getBlock().getLocation().getBlockZ() == Ville.villes.get(Ville.villeAttaquee).ap.getLocation().getBlockZ() && event.getBlock().getLocation().getWorld().getName() == Ville.villes.get(Ville.villeAttaquee).ap.getLocation().getWorld().getName() && Ville.villes.get(Ville.villeAttaquee).ap.getEtat() == Etat.ACTIVE)
					{
						Ville.annulerAttaque(this);
						Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "La prise de ville a echoue.");
					}
					if (event.getBlock().getLocation().getBlockX() == Ville.villes.get(Ville.villeAttaquee).a.getLocation().getBlockX() && event.getBlock().getLocation().getBlockY() == Ville.villes.get(Ville.villeAttaquee).a.getLocation().getBlockY() && event.getBlock().getLocation().getBlockZ() == Ville.villes.get(Ville.villeAttaquee).a.getLocation().getBlockZ() && event.getBlock().getLocation().getWorld().getName() == Ville.villes.get(Ville.villeAttaquee).a.getLocation().getWorld().getName() && Ville.villes.get(Ville.villeAttaquee).a.getEtat() == Etat.ACTIVE)
					{
						Ville.annulerAttaque(this);
						Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "La prise de ville a echoue.");
					}
					if (event.getBlock().getLocation().getBlockX() == Ville.villes.get(Ville.villeAttaquee).b.getLocation().getBlockX() && event.getBlock().getLocation().getBlockY() == Ville.villes.get(Ville.villeAttaquee).b.getLocation().getBlockY() && event.getBlock().getLocation().getBlockZ() == Ville.villes.get(Ville.villeAttaquee).b.getLocation().getBlockZ() && event.getBlock().getLocation().getWorld().getName() == Ville.villes.get(Ville.villeAttaquee).b.getLocation().getWorld().getName() && Ville.villes.get(Ville.villeAttaquee).b.getEtat() == Etat.ACTIVE)
					{
						Ville.annulerAttaque(this);
						Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "La prise de ville a echoue.");
					}
					if (event.getBlock().getLocation().getBlockX() == Ville.villes.get(Ville.villeAttaquee).c.getLocation().getBlockX() && event.getBlock().getLocation().getBlockY() == Ville.villes.get(Ville.villeAttaquee).c.getLocation().getBlockY() && event.getBlock().getLocation().getBlockZ() == Ville.villes.get(Ville.villeAttaquee).c.getLocation().getBlockZ() && event.getBlock().getLocation().getWorld().getName() == Ville.villes.get(Ville.villeAttaquee).c.getLocation().getWorld().getName() && Ville.villes.get(Ville.villeAttaquee).c.getEtat() == Etat.ACTIVE)
					{
						Ville.annulerAttaque(this);
						Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "La prise de ville a echoue.");
					}
					if (event.getBlock().getLocation().getBlockX() == Ville.villes.get(Ville.villeAttaquee).pc.getLocation().getBlockX() && event.getBlock().getLocation().getBlockY() == Ville.villes.get(Ville.villeAttaquee).pc.getLocation().getBlockY() && event.getBlock().getLocation().getBlockZ() == Ville.villes.get(Ville.villeAttaquee).pc.getLocation().getBlockZ() && event.getBlock().getLocation().getWorld().getName() == Ville.villes.get(Ville.villeAttaquee).pc.getLocation().getWorld().getName() && Ville.villes.get(Ville.villeAttaquee).pc.getEtat() == Etat.ACTIVE)
					{
						Ville.annulerAttaque(this);
						Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "La prise de ville a echoue.");
					}
				}
			}
		}
	}
	/* cancelBreakingBatailleBlock */
	
	
	/* SetPointActivePendantBataille */
	@EventHandler(priority = EventPriority.LOWEST)
	public void SetPointActivePendantBataille(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getTypeId() == 232 && Ville.villeAttaquee != -1)
		{
			if (Factions.i.get(Ville.villes.get(Ville.villeAttaquee).getFaction()).getRelationTo(FPlayers.i.get(event.getPlayer()).getFaction()).equals(Rel.ENEMY))
			{
				if (event.getClickedBlock().getLocation().getBlockX() == Ville.villes.get(Ville.villeAttaquee).ap.getLocation().getBlockX() && event.getClickedBlock().getLocation().getBlockY() == Ville.villes.get(Ville.villeAttaquee).ap.getLocation().getBlockY() && event.getClickedBlock().getLocation().getBlockZ() == Ville.villes.get(Ville.villeAttaquee).ap.getLocation().getBlockZ() && event.getClickedBlock().getWorld().getName() == Ville.villes.get(Ville.villeAttaquee).ap.getLocation().getWorld().getName())
				{
					if (Ville.villes.get(Ville.villeAttaquee).ap.getEtat() == Etat.DESACTIVE)
					{
						Ville.villes.get(Ville.villeAttaquee).ap.setEtat(Etat.ACTIVE);
					}
				}
				else if (event.getClickedBlock().getLocation().getBlockX() == Ville.villes.get(Ville.villeAttaquee).a.getLocation().getBlockX() && event.getClickedBlock().getLocation().getBlockY() == Ville.villes.get(Ville.villeAttaquee).a.getLocation().getBlockY() && event.getClickedBlock().getLocation().getBlockZ() == Ville.villes.get(Ville.villeAttaquee).a.getLocation().getBlockZ() && event.getClickedBlock().getWorld().getName() == Ville.villes.get(Ville.villeAttaquee).a.getLocation().getWorld().getName())
				{
					if (Ville.villes.get(Ville.villeAttaquee).a.getEtat() == Etat.DESACTIVE)
					{
						Ville.villes.get(Ville.villeAttaquee).a.setEtat(Etat.ACTIVE);
					}
				}
				else if (event.getClickedBlock().getLocation().getBlockX() == Ville.villes.get(Ville.villeAttaquee).b.getLocation().getBlockX() && event.getClickedBlock().getLocation().getBlockY() == Ville.villes.get(Ville.villeAttaquee).b.getLocation().getBlockY() && event.getClickedBlock().getLocation().getBlockZ() == Ville.villes.get(Ville.villeAttaquee).b.getLocation().getBlockZ() && event.getClickedBlock().getWorld().getName() == Ville.villes.get(Ville.villeAttaquee).b.getLocation().getWorld().getName())
				{
					if (Ville.villes.get(Ville.villeAttaquee).b.getEtat() == Etat.DESACTIVE)
					{
						Ville.villes.get(Ville.villeAttaquee).b.setEtat(Etat.ACTIVE);
					}
				}
				else if (event.getClickedBlock().getLocation().getBlockX() == Ville.villes.get(Ville.villeAttaquee).c.getLocation().getBlockX() && event.getClickedBlock().getLocation().getBlockY() == Ville.villes.get(Ville.villeAttaquee).c.getLocation().getBlockY() && event.getClickedBlock().getLocation().getBlockZ() == Ville.villes.get(Ville.villeAttaquee).c.getLocation().getBlockZ() && event.getClickedBlock().getWorld().getName() == Ville.villes.get(Ville.villeAttaquee).c.getLocation().getWorld().getName())
				{
					if (Ville.villes.get(Ville.villeAttaquee).c.getEtat() == Etat.DESACTIVE)
					{
						Ville.villes.get(Ville.villeAttaquee).c.setEtat(Etat.ACTIVE);
					}
				}
				else if (event.getClickedBlock().getLocation().getBlockX() == Ville.villes.get(Ville.villeAttaquee).pc.getLocation().getBlockX() && event.getClickedBlock().getLocation().getBlockY() == Ville.villes.get(Ville.villeAttaquee).pc.getLocation().getBlockY() && event.getClickedBlock().getLocation().getBlockZ() == Ville.villes.get(Ville.villeAttaquee).pc.getLocation().getBlockZ() && event.getClickedBlock().getWorld().getName() == Ville.villes.get(Ville.villeAttaquee).pc.getLocation().getWorld().getName())
				{
					if (Ville.villes.get(Ville.villeAttaquee).pc.getEtat() == Etat.DESACTIVE)
					{
						Ville.villes.get(Ville.villeAttaquee).pc.setEtat(Etat.ACTIVE);
					}
				}
			}
		}
	}
	/* setPointActivePendantBataille */
	
	/* lanceCompteurChangementEtat */
	@EventHandler(priority = EventPriority.NORMAL)
	public void lanceCompteurChangementEtat(ChangementEtatEvent event)
	{
		if (event.getPoint() == Ville.villes.get(Ville.villeAttaquee).ap)
		{
			if (event.getAncienEtat() == Etat.DESACTIVE && event.getNouvelEtat() == Etat.ACTIVE)
			{
				Bukkit.getScheduler().cancelTask(taskIdAnnulerAttaque30);
				this.taskIdAnnulerAttaque30 = -1;
				BukkitTask apTask = Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskAvantPoste(), 54000);
				this.apTaskId = apTask.getTaskId();
				Bukkit.broadcastMessage(ChatColor.DARK_RED + "Le compteur de l'avant-poste a ete active.");
			}
		}
		if (event.getPoint() == Ville.villes.get(Ville.villeAttaquee).a)
		{
			if (event.getAncienEtat() == Etat.DESACTIVE && event.getNouvelEtat() == Etat.ACTIVE)
			{
				if(Ville.villes.get(Ville.villeAttaquee).b.getEtat() == Etat.DESACTIVE && Ville.villes.get(Ville.villeAttaquee).c.getEtat() == Etat.DESACTIVE)
				{
					Bukkit.getScheduler().cancelTask(taskIdAnnulerAttaque60);
					this.taskIdAnnulerAttaque60 = -1;
				}
				else
				{
					Bukkit.getScheduler().cancelTask(taskIdAnnulerAttaque30);
					this.taskIdAnnulerAttaque30 = -1;
				}
				BukkitTask aTask = Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskPoints('a'), (Ville.villes.get(Ville.villeAttaquee).isCapitale()) ?  36000 : 18000);
				this.aTaskId = aTask.getTaskId();
				Bukkit.broadcastMessage(ChatColor.DARK_RED + "Le compteur du point A a ete active.");
			}
		}
		if (event.getPoint() == Ville.villes.get(Ville.villeAttaquee).b)
		{
			if (event.getAncienEtat() == Etat.DESACTIVE && event.getNouvelEtat() == Etat.ACTIVE)
			{
				if(Ville.villes.get(Ville.villeAttaquee).a.getEtat() == Etat.DESACTIVE && Ville.villes.get(Ville.villeAttaquee).c.getEtat() == Etat.DESACTIVE)
				{
					Bukkit.getScheduler().cancelTask(taskIdAnnulerAttaque60);
					this.taskIdAnnulerAttaque60 = -1;
				}
				else
				{
					Bukkit.getScheduler().cancelTask(taskIdAnnulerAttaque30);
					this.taskIdAnnulerAttaque30 = -1;
				}
				BukkitTask bTask = Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskPoints('b'), (Ville.villes.get(Ville.villeAttaquee).isCapitale()) ?  36000 : 18000);
				this.bTaskId = bTask.getTaskId();
				Bukkit.broadcastMessage(ChatColor.DARK_RED + "Le compteur du point B a ete active.");
			}
		}
		if (event.getPoint() == Ville.villes.get(Ville.villeAttaquee).c)
		{
			if (event.getAncienEtat() == Etat.DESACTIVE && event.getNouvelEtat() == Etat.ACTIVE)
			{
				if(Ville.villes.get(Ville.villeAttaquee).b.getEtat() == Etat.DESACTIVE && Ville.villes.get(Ville.villeAttaquee).a.getEtat() == Etat.DESACTIVE)
				{
					Bukkit.getScheduler().cancelTask(taskIdAnnulerAttaque60);
					this.taskIdAnnulerAttaque60 = -1;
				}
				else
				{
					Bukkit.getScheduler().cancelTask(taskIdAnnulerAttaque30);
					this.taskIdAnnulerAttaque30 = -1;
				}
				BukkitTask cTask = Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskPoints('c'), (Ville.villes.get(Ville.villeAttaquee).isCapitale()) ?  36000 : 18000);
				this.pcTaskId = cTask.getTaskId();
				Bukkit.broadcastMessage(ChatColor.DARK_RED + "Le compteur du point C a ete active.");
			}
		}
		if (event.getPoint() == Ville.villes.get(Ville.villeAttaquee).pc)
		{
			if (event.getAncienEtat() == Etat.DESACTIVE && event.getNouvelEtat() == Etat.ACTIVE)
			{
				Bukkit.getServer().getScheduler().cancelTask(taskIdAnnulerAttaque60);
				this.taskIdAnnulerAttaque60 = -1;
				BukkitTask pcTask = Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskPointCentral(plugin), (Ville.villes.get(Ville.villeAttaquee).isCapitale()) ? 144000 : 72000);
				this.pcTaskId = pcTask.getTaskId();
				Bukkit.broadcastMessage(ChatColor.DARK_RED + "Le compteur du point central a ete active.");
			}
		}
	}
	
	public int apTaskId;
	public int aTaskId;
	public int bTaskId;
	public int cTaskId;
	public int pcTaskId;
	public void resetTasksIds()
	{
		this.apTaskId = -1;
		this.aTaskId = -1;
		this.bTaskId = -1;
		this.cTaskId = -1;
		this.pcTaskId = -1;
		this.taskIdAnnulerAttaque30 = -1;
		this.taskIdAnnulerAttaque60 = -1;
	}
	/* lanceCompteurChangementEtat */
	
	
	/* onPlayerCommandPreprocessed */
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerCommandPreprocessed(PlayerCommandPreprocessEvent event)
	{
		Player p = event.getPlayer();
		String[] args = event.getMessage().split(" ");
		if (args[0].equalsIgnoreCase("/ville") && (p.hasPermission("vvjcj.settings") || p.hasPermission("vvjcj.*")))
			{
				if (args.length == 3)
				{
					event.setCancelled(true);
					if (args[2].equals("1"))
					{	
						Ville.villes.add(new Ville(args[1], true));
						p.sendMessage(ChatColor.GREEN + "La ville " + Ville.villes.get(Ville.nombreVilles - 1).getNom() + " a ete cree en tant que capitale.");
					}
					else if (args[2].equals("0"))
					{
						Ville.villes.add(new Ville(args[1], false));
						p.sendMessage(ChatColor.GREEN + "La ville " + Ville.villes.get(Ville.nombreVilles - 1).getNom() + " a ete cree en tant que ville secondaire.");
					}
				}
			}
		if (args[0].equalsIgnoreCase("/setpoint") && (p.hasPermission("vvjcj.settings") || p.hasPermission("vvjcj.*")))
		{
			if (args.length == 7)
			{
				event.setCancelled(true);
				for (int i = 0 ; i < Ville.villes.size() ; i++)
				{
					if (Ville.villes.get(i).getNom().equalsIgnoreCase(args[1]))
					{
						switch (args[2])
						{
							case "ap":
								Ville.villes.get(i).setap(new Location(plugin.getServer().getWorld(args[6]), Integer.valueOf(args[3]), Integer.valueOf(args[4]), Integer.valueOf(args[5])));
								p.sendMessage("Le point AP a été défini.");
								break;
							case "a":
								Ville.villes.get(i).seta(new Location(plugin.getServer().getWorld(args[6]), Integer.valueOf(args[3]), Integer.valueOf(args[4]), Integer.valueOf(args[5])));
								p.sendMessage("Le point A a été défini.");
								break;
							case "b":
								Ville.villes.get(i).setb(new Location(plugin.getServer().getWorld(args[6]), Integer.valueOf(args[3]), Integer.valueOf(args[4]), Integer.valueOf(args[5])));
								p.sendMessage("Le point B a été défini.");
								break;
							case "c":
								Ville.villes.get(i).setc(new Location(plugin.getServer().getWorld(args[6]), Integer.valueOf(args[3]), Integer.valueOf(args[4]), Integer.valueOf(args[5])));
								p.sendMessage("Le point C a été défini.");
								break;
							case "pc":
								Ville.villes.get(i).setpc(new Location(plugin.getServer().getWorld(args[6]), Integer.valueOf(args[3]), Integer.valueOf(args[4]), Integer.valueOf(args[5])));
								p.sendMessage("Le point PC a été défini.");
								break;
							default:
								p.sendMessage("Vous n'avez pas saisi une valeur de point valide");
						}
					}
				}
			}
		}
		if (args[0].equalsIgnoreCase("/setfaction") && (p.hasPermission("vvjcj.settings") || p.hasPermission("vvjcj.*")))
		{
			event.setCancelled(true);
			if (args.length == 3)
			{
				for(int i = 0 ; i < Ville.villes.size() ; i++)
				{
					if (Ville.villes.get(i).getNom().equalsIgnoreCase(args[1]))
					{
						Ville.villes.get(i).setFaction(Factions.i.getBestTagMatch(args[2]).getId());
						p.sendMessage(ChatColor.GREEN + "Vous avez mis " + Factions.i.get(Ville.villes.get(i).getFaction()).getTag() + " comme faction de la ville " + Ville.villes.get(i).getNom());
					}
				}
			}
		}
		if (args[0].equalsIgnoreCase("/attaquer") && (p.hasPermission("vvjcj.war") || p.hasPermission("vvjcj.*")))
		{
			event.setCancelled(true);
			if (args.length == 2)
			{
				if (Ville.villeAttaquee == -1)
				{
					for(int i = 0 ; i < Ville.villes.size(); i++)
					{
						if (Ville.villes.get(i).getNom().equalsIgnoreCase(args[1]))
						{
							AttaqueEvent e = new AttaqueEvent(i, p);
							Bukkit.getServer().getPluginManager().callEvent(e);
						}
					}
				}
				else if (Ville.villeAttaquee != -1)
				{
					p.sendMessage(ChatColor.RED + "Une ville est deja attaquee.");
				}
			}
		}
		if(args[0].equalsIgnoreCase("/annuler") && Ville.villeAttaquee != -1 && (p.hasPermission("vvjcj.war") || p.hasPermission("vvjcj.*")))
		{
			if (args.length == 1)
			{
				if (playerAttaquant == p.getName())
				{
					Ville.annulerAttaque(this);
					Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "La prise de ville a été annulée par " + p.getName() + " !");
				}
			}
		}
	}
	/* onPlayerCommandPreprocessed */
	
	/* onAttaque */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onAttaque(AttaqueEvent event)
	{
		this.playerAttaquant = event.getPlayer().getName();
		Ville.villeAttaquee = event.getVilleAttaquee();
		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "La ville " + Ville.villes.get(Ville.villeAttaquee).getNom() + " est attaquee. Debut de la bataille dans 10 minutes.");
		Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskDebutAttaque(), 12000);
	}
	/* onAttaque */
	public String playerAttaquant;
	
	/* onTimerDebutAttaqueTermine */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onTimerDebutAttaqueTermine(TimerDebutAttaqueTermineEvent event)
	{
		Ville.villes.get(Ville.villeAttaquee).ap.setEtat(Etat.DESACTIVE);
		BukkitTask bt = Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskAnnulerAttaque(this), 36000);
		this.taskIdAnnulerAttaque30 = bt.getTaskId();
	}
	public int taskIdAnnulerAttaque30;
	/* onTimerDebutAttaqueTermine */
	
	/* onTimerAvantPosteTermine */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onTimerAvantPosteTermine(TimerAvantPosteTermineEvent event)
	{
		Ville.villes.get(Ville.villeAttaquee).a.setEtat(Etat.DESACTIVE);
		Ville.villes.get(Ville.villeAttaquee).b.setEtat(Etat.DESACTIVE);
		Ville.villes.get(Ville.villeAttaquee).c.setEtat(Etat.DESACTIVE);
		BukkitTask bt = Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskAnnulerAttaque(this), 72000);
		this.taskIdAnnulerAttaque60 = bt.getTaskId();
	}
	public int taskIdAnnulerAttaque60;
	/* onTimerAvantPosteTermine */
	
	/* onTimerPointsTermine */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onTimerPointsTermine(TimerPointsTermineEvent event)
	{
		if (Ville.villes.get(Ville.villeAttaquee).a.getEtat() == Etat.TERMINE && Ville.villes.get(Ville.villeAttaquee).b.getEtat() == Etat.TERMINE && Ville.villes.get(Ville.villeAttaquee).c.getEtat() == Etat.TERMINE)
		{
			Ville.villes.get(Ville.villeAttaquee).pc.setEtat(Etat.DESACTIVE);
			Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Les trois points ont ete pris. Maintenant vous pouvez attaquer le point central.");
			BukkitTask bt = Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskAnnulerAttaque(this), 72000);
			this.taskIdAnnulerAttaque60 = bt.getTaskId();
		}
		else
		{
			BukkitTask bt = Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskAnnulerAttaque(this), 36000);
			this.taskIdAnnulerAttaque30 = bt.getTaskId();
		}
	}
	/* onTimerPointsTermine */
}