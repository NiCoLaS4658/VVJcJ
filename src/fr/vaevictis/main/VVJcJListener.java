package fr.vaevictis.main;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class VVJcJListener implements Listener {
	
	public VVJcJListener(VVJcJ plugin)
	{
		this.plugin = plugin;
	}

	
	private VVJcJ plugin;
	
	/* Groupe servant à giveLocationOfBlockPlacedByThePlayer */
	public static boolean commandSetpointEnabled; // La commande /setpoint est elle en cours d'utilisation
	public static String puspc; // Nom du joueur utilisant la commande /setpoint
	public static Location locationOfBlockPlacedByThePlayer;
	public static boolean commandCanStop; // Le plugin peut-il considerer que la commande est terminee ?
	/* Groupe servant à giveLocationOfBlockPlacedByThePlayer */


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

}