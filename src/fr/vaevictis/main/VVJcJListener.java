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

public class VVJcJListener implements Listener
{
	
	public VVJcJListener(VVJcJ plugin)
	{
		this.plugin = plugin;
		this.timerAp = new TimerAvantPoste();
		this.timerA = new TimerPoints('a');
		this.timerB =  new TimerPoints('b');
		this.timerC = new TimerPoints('c');
		this.timerPc = new TimerPointCentral();
	}

	private VVJcJ plugin;
	
	/* giveLocationOfBlockPlacedByThePlayer */
	public static boolean commandSetpointEnabled; // La commande /setpoint est elle en cours d'utilisation
	public static String puspc; // Nom du joueur utilisant la commande /setpoint
	public static Location locationOfBlockPlacedByThePlayer;
	public static boolean commandCanStop; // Le plugin peut-il considerer que la commande est terminee ?


	@EventHandler(priority = EventPriority.NORMAL)
	public void giveLocationOfBlockPlacedByThePlayer(BlockPlaceEvent event)
	{
		if (this.commandSetpointEnabled)
		{
			if (event.getPlayer().getName() == puspc)
			{
				this.locationOfBlockPlacedByThePlayer = event.getBlock().getLocation();
				this.commandCanStop = true;
			}
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
				if (event.getBlock().getLocation() == Ville.villes[Ville.villeAttaquee].ap.getLocation() && Ville.villes[Ville.villeAttaquee].ap.getEtat() == Etat.ACTIVE)
				{
					Ville.villes[Ville.villeAttaquee].ap.setEtat(Etat.INACTIVABLE);
					timerAp.cancel();
					Ville.villeAttaquee = -1;
				}
				if (event.getBlock().getLocation() == Ville.villes[Ville.villeAttaquee].a.getLocation() && Ville.villes[Ville.villeAttaquee].a.getEtat() == Etat.ACTIVE)
				{
					Ville.villes[Ville.villeAttaquee].ap.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].a.setEtat(Etat.INACTIVABLE);
					timerA.cancel();
					Ville.villes[Ville.villeAttaquee].b.setEtat(Etat.INACTIVABLE);
					timerB.cancel();
					Ville.villes[Ville.villeAttaquee].c.setEtat(Etat.INACTIVABLE);
					timerC.cancel();
					Ville.villeAttaquee = -1;
				}
				if (event.getBlock().getLocation() == Ville.villes[Ville.villeAttaquee].b.getLocation() && Ville.villes[Ville.villeAttaquee].b.getEtat() == Etat.ACTIVE)
				{
					Ville.villes[Ville.villeAttaquee].ap.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].a.setEtat(Etat.INACTIVABLE);
					timerA.cancel();
					Ville.villes[Ville.villeAttaquee].b.setEtat(Etat.INACTIVABLE);
					timerB.cancel();
					Ville.villes[Ville.villeAttaquee].c.setEtat(Etat.INACTIVABLE);
					timerC.cancel();
					Ville.villeAttaquee = -1;
				}
				if (event.getBlock().getLocation() == Ville.villes[Ville.villeAttaquee].c.getLocation() && Ville.villes[Ville.villeAttaquee].c.getEtat() == Etat.ACTIVE)
				{
					Ville.villes[Ville.villeAttaquee].ap.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].a.setEtat(Etat.INACTIVABLE);
					timerA.cancel();
					Ville.villes[Ville.villeAttaquee].b.setEtat(Etat.INACTIVABLE);
					timerB.cancel();
					Ville.villes[Ville.villeAttaquee].c.setEtat(Etat.INACTIVABLE);
					timerC.cancel();
					Ville.villeAttaquee = -1;
				}
				if (event.getBlock().getLocation() == Ville.villes[Ville.villeAttaquee].pc.getLocation() && Ville.villes[Ville.villeAttaquee].pc.getEtat() == Etat.ACTIVE)
				{
					Ville.villes[Ville.villeAttaquee].ap.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].a.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].b.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].c.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].pc.setEtat(Etat.INACTIVABLE);
					timerPc.cancel();
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
			if (event.getClickedBlock().getLocation() == Ville.villes[Ville.villeAttaquee].ap.getLocation())
			{
				if (Ville.villes[Ville.villeAttaquee].ap.getEtat() == Etat.DESACTIVE)
				{
					Ville.villes[Ville.villeAttaquee].ap.setEtat(Etat.ACTIVE);
				}
			}
			else if (event.getClickedBlock().getLocation() == Ville.villes[Ville.villeAttaquee].a.getLocation())
			{
				if (Ville.villes[Ville.villeAttaquee].a.getEtat() == Etat.DESACTIVE)
				{
					Ville.villes[Ville.villeAttaquee].a.setEtat(Etat.ACTIVE);
				}
			}
			else if (event.getClickedBlock().getLocation() == Ville.villes[Ville.villeAttaquee].b.getLocation())
			{
				if (Ville.villes[Ville.villeAttaquee].b.getEtat() == Etat.DESACTIVE)
				{
					Ville.villes[Ville.villeAttaquee].b.setEtat(Etat.ACTIVE);
				}
			}
			else if (event.getClickedBlock().getLocation() == Ville.villes[Ville.villeAttaquee].c.getLocation())
			{
				if (Ville.villes[Ville.villeAttaquee].c.getEtat() == Etat.DESACTIVE)
				{
					Ville.villes[Ville.villeAttaquee].c.setEtat(Etat.ACTIVE);
				}
			}
			else if (event.getClickedBlock().getLocation() == Ville.villes[Ville.villeAttaquee].pc.getLocation())
			{
				if (Ville.villes[Ville.villeAttaquee].pc.getEtat() == Etat.DESACTIVE)
				{
					Ville.villes[Ville.villeAttaquee].pc.setEtat(Etat.ACTIVE);
				}
			}
		}
	}
	/* setPointActivePendantBataille */
	
	/* lanceCompteurChangementEtat */
	@EventHandler(priority = EventPriority.NORMAL)
	public void lanceCompteurChangementEtat(ChangementEtatEvent event)
	{
		if (event.getPoint() == Ville.villes[Ville.villeAttaquee].ap)
		{
			if (event.getAncienEtat() == Etat.DESACTIVE && event.getNouvelEtat() == Etat.ACTIVE)
			{
				this.timerAp.lancer();
			}
		}
		if (event.getPoint() == Ville.villes[Ville.villeAttaquee].a)
		{
			if (event.getAncienEtat() == Etat.DESACTIVE && event.getNouvelEtat() == Etat.ACTIVE)
			{
				this.timerA.lancer();
			}
		}
		if (event.getPoint() == Ville.villes[Ville.villeAttaquee].b)
		{
			if (event.getAncienEtat() == Etat.DESACTIVE && event.getNouvelEtat() == Etat.ACTIVE)
			{
				this.timerB.lancer();
			}
		}
		if (event.getPoint() == Ville.villes[Ville.villeAttaquee].c)
		{
			if (event.getAncienEtat() == Etat.DESACTIVE && event.getNouvelEtat() == Etat.ACTIVE)
			{
				this.timerC.lancer();
			}
		}
		if (event.getPoint() == Ville.villes[Ville.villeAttaquee].pc)
		{
			if (event.getAncienEtat() == Etat.DESACTIVE && event.getNouvelEtat() == Etat.ACTIVE)
			{
				this.timerPc.lancer();
			}
		}
	}
	public static TimerAvantPoste timerAp;
	public static TimerPoints timerA;
	public static TimerPoints timerB;
	public static TimerPoints timerC;
	public static TimerPointCentral timerPc;
	/* lanceCompteurChangementEtat */
	
	
	/* onPlayerCommandPreprocessed */
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerCommandPreprocessed(PlayerCommandPreprocessEvent event)
	{
		Player p = event.getPlayer();
		String[] args = event.getMessage().split(" ");
			if (args[0].equalsIgnoreCase("/ville") && p.hasPermission("vvjcj.settings"))
			{
				if (args.length == 3)
				{
					event.setCancelled(true);
					if (args[2].equals("1"))
					{	
						Ville.villes[Ville.nombreVilles] = new Ville(args[1], true);
						p.sendMessage(ChatColor.GREEN + "La ville " + Ville.villes[Ville.nombreVilles - 1].getNom() + " a ete cree en tant que capitale.");
					}
					else if (args[2].equals("0"))
					{
						Ville.villes[Ville.nombreVilles] = new Ville(args[1], false);
						p.sendMessage(ChatColor.GREEN + "La ville " + Ville.villes[Ville.nombreVilles - 1].getNom() + " a ete cree en tant que ville secondaire.");
					}
				}
			}
		if (args[0].equalsIgnoreCase("/setpoint") && p.hasPermission("vvjcj.settings"))
		{
			event.setCancelled(true);
			if(commandSetpointEnabled == true)
			{
				//Variables permettant au Listener d'avoir des informations sur la commande
				commandSetpointEnabled = true;
				puspc = p.getName();
				commandCanStop = false;
				for(int i = 0 ; i < Ville.villes.length || Ville.villes[i].getNom() != args[1] ; i++)
				{
					do
					{
						if (Ville.villes[i].getNom() == args[1])
						{
							// Switch ajoutant le point où est situé le bloc important
							switch(args[2])
							{
							case "ap" :
								Ville.villes[i].setap(VVJcJListener.locationOfBlockPlacedByThePlayer);
								break;
								
							case "a" :
								Ville.villes[i].seta(VVJcJListener.locationOfBlockPlacedByThePlayer);
								break;
							
							case "b" :
								Ville.villes[i].setb(VVJcJListener.locationOfBlockPlacedByThePlayer);
								break;
								
							case "c" :
								Ville.villes[i].setc(VVJcJListener.locationOfBlockPlacedByThePlayer);
								break;
								
							case "pc" :
								Ville.villes[i].setpc(VVJcJListener.locationOfBlockPlacedByThePlayer);
								break;
							
							default:
								p.sendMessage(ChatColor.RED + "Vous n'avez pas saisi un point valide");
							}
						}
					} while(!commandCanStop);
				}
			// Remise à zero des variables utilisees ici
			VVJcJListener.commandSetpointEnabled = false;
			VVJcJListener.puspc = "";
			}
		}
		if (args[0].equalsIgnoreCase("/attaquer") && p.hasPermission("vvjcj.war"))
		{
			event.setCancelled(true);
			if (Ville.villeAttaquee != -1)
			{
				for(int i = 0 ; i < Ville.villes.length || Ville.villes[i].getNom() != args[0]; i++)
				{
					if (Ville.villes[i].getNom() == args[0])
					{
					Ville.villes[i].attaquer();
					}
				}
		
			}
			else if (Ville.villeAttaquee == -1)
			{
				p.sendMessage(ChatColor.RED + "Aucune Ville Trouvée");
			}
			else
			{
				p.sendMessage(ChatColor.RED + "La ville " + Ville.villes[Ville.villeAttaquee].getNom() + " est deja attaquee.");
			}
		}
	}
	/* onPlayerCommandPreprocessed */
}