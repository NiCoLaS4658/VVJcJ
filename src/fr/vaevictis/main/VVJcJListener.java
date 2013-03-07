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
	}

	private VVJcJ plugin;
	
	/* giveLocationOfBlockPlacedByThePlayer */


	@EventHandler(priority = EventPriority.NORMAL)
	public void onBatailleBlockPlaced(BlockPlaceEvent event)
	{
		if (event.getBlock().getTypeId() == 162)
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
		if (Ville.villeAttaquee != -1)
		{
			if (event.getBlock().getTypeId() == 162)
			{
				if (event.getBlock().getLocation() == Ville.villes.get(Ville.villeAttaquee).ap.getLocation() && Ville.villes.get(Ville.villeAttaquee).ap.getEtat() == Etat.ACTIVE)
				{
					Ville.villes.get(Ville.villeAttaquee).ap.setEtat(Etat.INACTIVABLE);
					Bukkit.getServer().getScheduler().cancelTask(apTaskId);
					apTaskId = -1;
					Ville.villeAttaquee = -1;
				}
				if (event.getBlock().getLocation() == Ville.villes.get(Ville.villeAttaquee).a.getLocation() && Ville.villes.get(Ville.villeAttaquee).a.getEtat() == Etat.ACTIVE)
				{
					Ville.villes.get(Ville.villeAttaquee).ap.setEtat(Etat.INACTIVABLE);
					Ville.villes.get(Ville.villeAttaquee).a.setEtat(Etat.INACTIVABLE);
					Bukkit.getServer().getScheduler().cancelTask(aTaskId);
					aTaskId = -1;
					Ville.villes.get(Ville.villeAttaquee).b.setEtat(Etat.INACTIVABLE);
					Bukkit.getServer().getScheduler().cancelTask(bTaskId);
					bTaskId = -1;
					Ville.villes.get(Ville.villeAttaquee).c.setEtat(Etat.INACTIVABLE);
					Bukkit.getServer().getScheduler().cancelTask(cTaskId);
					cTaskId = -1;
					apTaskId = -1;
					Ville.villeAttaquee = -1;
				}
				if (event.getBlock().getLocation() == Ville.villes.get(Ville.villeAttaquee).b.getLocation() && Ville.villes.get(Ville.villeAttaquee).b.getEtat() == Etat.ACTIVE)
				{
					Ville.villes.get(Ville.villeAttaquee).ap.setEtat(Etat.INACTIVABLE);
					Ville.villes.get(Ville.villeAttaquee).a.setEtat(Etat.INACTIVABLE);
					Bukkit.getServer().getScheduler().cancelTask(aTaskId);
					aTaskId = -1;
					Ville.villes.get(Ville.villeAttaquee).b.setEtat(Etat.INACTIVABLE);
					Bukkit.getServer().getScheduler().cancelTask(bTaskId);
					bTaskId = -1;
					Ville.villes.get(Ville.villeAttaquee).c.setEtat(Etat.INACTIVABLE);
					Bukkit.getServer().getScheduler().cancelTask(cTaskId);
					cTaskId = -1;
					apTaskId = -1;
					Ville.villeAttaquee = -1;
				}
				if (event.getBlock().getLocation() == Ville.villes.get(Ville.villeAttaquee).c.getLocation() && Ville.villes.get(Ville.villeAttaquee).c.getEtat() == Etat.ACTIVE)
				{
					Ville.villes.get(Ville.villeAttaquee).ap.setEtat(Etat.INACTIVABLE);
					Ville.villes.get(Ville.villeAttaquee).a.setEtat(Etat.INACTIVABLE);
					Bukkit.getServer().getScheduler().cancelTask(aTaskId);
					aTaskId = -1;
					Ville.villes.get(Ville.villeAttaquee).b.setEtat(Etat.INACTIVABLE);
					Bukkit.getServer().getScheduler().cancelTask(bTaskId);
					bTaskId = -1;
					Ville.villes.get(Ville.villeAttaquee).c.setEtat(Etat.INACTIVABLE);
					Bukkit.getServer().getScheduler().cancelTask(cTaskId);
					cTaskId = -1;
					apTaskId = -1;
					Ville.villeAttaquee = -1;
				}
				if (event.getBlock().getLocation() == Ville.villes.get(Ville.villeAttaquee).pc.getLocation() && Ville.villes.get(Ville.villeAttaquee).pc.getEtat() == Etat.ACTIVE)
				{
					Ville.villes.get(Ville.villeAttaquee).ap.setEtat(Etat.INACTIVABLE);
					Ville.villes.get(Ville.villeAttaquee).a.setEtat(Etat.INACTIVABLE);
					Ville.villes.get(Ville.villeAttaquee).b.setEtat(Etat.INACTIVABLE);
					Ville.villes.get(Ville.villeAttaquee).c.setEtat(Etat.INACTIVABLE);
					Ville.villes.get(Ville.villeAttaquee).pc.setEtat(Etat.INACTIVABLE);
					Bukkit.getServer().getScheduler().cancelTask(pcTaskId);
					pcTaskId = -1;
					apTaskId = -1;
					aTaskId = -1;
					bTaskId = -1;
					cTaskId = -1;
					Ville.villeAttaquee = -1;
				}
			}
		}
		if (event.getBlock().getTypeId() == 162)
		{
			if (event.getPlayer().getItemInHand().getTypeId() != 7)
			{
				event.setCancelled(true);
			}
		}
	}
	/* cancelBreakingBatailleBlock */
	
	
	/* SetPointActivePendantBataille */
	@EventHandler(priority = EventPriority.NORMAL)
	public void SetPointActivePendantBataille(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getTypeId() == 162 && Ville.villeAttaquee != -1)
		{
			if (event.getClickedBlock().getLocation() == Ville.villes.get(Ville.villeAttaquee).ap.getLocation())
			{
				if (Ville.villes.get(Ville.villeAttaquee).ap.getEtat() == Etat.DESACTIVE)
				{
					Ville.villes.get(Ville.villeAttaquee).ap.setEtat(Etat.ACTIVE);
				}
			}
			else if (event.getClickedBlock().getLocation() == Ville.villes.get(Ville.villeAttaquee).a.getLocation())
			{
				if (Ville.villes.get(Ville.villeAttaquee).a.getEtat() == Etat.DESACTIVE)
				{
					Ville.villes.get(Ville.villeAttaquee).a.setEtat(Etat.ACTIVE);
				}
			}
			else if (event.getClickedBlock().getLocation() == Ville.villes.get(Ville.villeAttaquee).b.getLocation())
			{
				if (Ville.villes.get(Ville.villeAttaquee).b.getEtat() == Etat.DESACTIVE)
				{
					Ville.villes.get(Ville.villeAttaquee).b.setEtat(Etat.ACTIVE);
				}
			}
			else if (event.getClickedBlock().getLocation() == Ville.villes.get(Ville.villeAttaquee).c.getLocation())
			{
				if (Ville.villes.get(Ville.villeAttaquee).c.getEtat() == Etat.DESACTIVE)
				{
					Ville.villes.get(Ville.villeAttaquee).c.setEtat(Etat.ACTIVE);
				}
			}
			else if (event.getClickedBlock().getLocation() == Ville.villes.get(Ville.villeAttaquee).pc.getLocation())
			{
				if (Ville.villes.get(Ville.villeAttaquee).pc.getEtat() == Etat.DESACTIVE)
				{
					Ville.villes.get(Ville.villeAttaquee).pc.setEtat(Etat.ACTIVE);
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
				BukkitTask apTask = Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskAvantPoste(), 54000);
				apTask.getTaskId();
			}
		}
		if (event.getPoint() == Ville.villes.get(Ville.villeAttaquee).a)
		{
			if (event.getAncienEtat() == Etat.DESACTIVE && event.getNouvelEtat() == Etat.ACTIVE)
			{
				BukkitTask aTask = Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskPoints('a'), (Ville.villes.get(Ville.villeAttaquee).isCapitale()) ?  36000 : 18000);
				
			}
		}
		if (event.getPoint() == Ville.villes.get(Ville.villeAttaquee).b)
		{
			if (event.getAncienEtat() == Etat.DESACTIVE && event.getNouvelEtat() == Etat.ACTIVE)
			{
				BukkitTask bTask = Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskPoints('b'), (Ville.villes.get(Ville.villeAttaquee).isCapitale()) ?  36000 : 18000);
			}
		}
		if (event.getPoint() == Ville.villes.get(Ville.villeAttaquee).c)
		{
			if (event.getAncienEtat() == Etat.DESACTIVE && event.getNouvelEtat() == Etat.ACTIVE)
			{
				BukkitTask cTask = Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskPoints('c'), (Ville.villes.get(Ville.villeAttaquee).isCapitale()) ?  36000 : 18000);
			}
		}
		if (event.getPoint() == Ville.villes.get(Ville.villeAttaquee).pc)
		{
			if (event.getAncienEtat() == Etat.DESACTIVE && event.getNouvelEtat() == Etat.ACTIVE)
			{
				BukkitTask pcTask = Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskPointCentral(), 72000);
			}
		}
	}
	
	private int apTaskId;
	private int aTaskId;
	private int bTaskId;
	private int cTaskId;
	private int pcTaskId;
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
		if (args[0].equalsIgnoreCase("/attaquer") && (p.hasPermission("vvjcj.war") || p.hasPermission("vvjcj.*")))
		{
			event.setCancelled(true);
			if (Ville.villeAttaquee == -1)
			{
				for(int i = 0 ; i < Ville.villes.size(); i++)
				{
					if (Ville.villes.get(i).getNom().equalsIgnoreCase(args[1]))
					{
						AttaqueEvent e = new AttaqueEvent(i);
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
	/* onPlayerCommandPreprocessed */
	
	/* onAttaque */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onAttaque(AttaqueEvent event)
	{
		Ville.villeAttaquee = event.getVilleAttaquee();
		Bukkit.getServer().getScheduler().runTaskLater(this.plugin, new TimerTaskDebutAttaque(), 12000);
	}
	/* onAttaque */
	
	/* onTimerDebutAttaqueTermine */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onTimerDebutAttaqueTermine(TimerDebutAttaqueTermineEvent event)
	{
		Ville.villes.get(Ville.villeAttaquee).ap.setEtat(Etat.DESACTIVE);
	}
	/* onTimerDebutAttaqueTermine */
	
	/* onTimerAvantPosteTermine */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onTimerAvantPosteTermine(TimerAvantPosteTermineEvent event)
	{
		Ville.villes.get(Ville.villeAttaquee).a.setEtat(Etat.DESACTIVE);
		Ville.villes.get(Ville.villeAttaquee).b.setEtat(Etat.DESACTIVE);
		Ville.villes.get(Ville.villeAttaquee).c.setEtat(Etat.DESACTIVE);
	}
	/* onTimerAvantPosteTermine */
	
	/* onTimerPointsTermine */
	@EventHandler(priority = EventPriority.NORMAL)
	public void onTimerPointsTermine(TimerPointsTermineEvent event)
	{
		if (Ville.villes.get(Ville.villeAttaquee).a.getEtat() == Etat.TERMINE && Ville.villes.get(Ville.villeAttaquee).b.getEtat() == Etat.TERMINE && Ville.villes.get(Ville.villeAttaquee).c.getEtat() == Etat.TERMINE)
		{
			Ville.villes.get(Ville.villeAttaquee).pc.setEtat(Etat.DESACTIVE);
		}
	}
	/* onTimerPointsTermine */
	
}