package fr.vaevictis.main;

import javax.swing.JTable.PrintMode;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class VVJcJListener implements Listener
{
	
	public VVJcJListener(VVJcJ plugin)
	{
		this.plugin = plugin;
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
					Ville.villeAttaquee = -1;
				}
				if (event.getBlock().getLocation() == Ville.villes[Ville.villeAttaquee].a.getLocation() && Ville.villes[Ville.villeAttaquee].a.getEtat() == Etat.ACTIVE)
				{
					Ville.villes[Ville.villeAttaquee].ap.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].a.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].b.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].c.setEtat(Etat.INACTIVABLE);
					Ville.villeAttaquee = -1;
				}
				if (event.getBlock().getLocation() == Ville.villes[Ville.villeAttaquee].b.getLocation() && Ville.villes[Ville.villeAttaquee].b.getEtat() == Etat.ACTIVE)
				{
					Ville.villes[Ville.villeAttaquee].ap.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].a.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].b.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].c.setEtat(Etat.INACTIVABLE);
					Ville.villeAttaquee = -1;
				}
				if (event.getBlock().getLocation() == Ville.villes[Ville.villeAttaquee].c.getLocation() && Ville.villes[Ville.villeAttaquee].c.getEtat() == Etat.ACTIVE)
				{
					Ville.villes[Ville.villeAttaquee].ap.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].a.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].b.setEtat(Etat.INACTIVABLE);
					Ville.villes[Ville.villeAttaquee].c.setEtat(Etat.INACTIVABLE);
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
	}
	public static TimerAvantPoste timerAp = new TimerAvantPoste();
	public static TimerPoints timerA = new TimerPoints('a');
	public static TimerPoints timerB = new TimerPoints('b');
	public static TimerPoints timerC = new TimerPoints('c');
	/* lanceCompteurChangementEtat */
}