package fr.vaevictis.main;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class VVJcJListener implements Listener {
	
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


	@EventHandler(priority = EventPriority.LOWEST)
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
	

	public void cancelBreakingBatailleBlock(BlockBreakEvent event)
	{
		if (event.getBlock().getTypeId() == 162)
		{
			if (event.getPlayer().getItemInHand().getTypeId() != 7)
			{
				event.setCancelled(true);
			}
		}
	}
	
	public void SetPointActivePendantBataille()
	{
		
	}

}