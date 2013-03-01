package fr.vaevictis.main;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.*;

public class VVJcJ extends JavaPlugin
{
	
	@Override
	public void onEnable()
	{
		getLogger().info("VVJcJ est activ�");
		
		VVJcJListener.commandSetpointEnabled = false;
		VVJcJListener.puspc = null;
		Ville.nombreVilles = 0;
		
		/** A faire : Ajouter le systeme de recuperation de villes depuis un fichier YAML vers Ville.villes[] **/

		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new VVJcJListener(this), this);
		

	}
	
	@Override
	public void onDisable()
	{
		/** A faire : Ajouter le syst�me d'enregistrement des villes depuis Ville.villes[] avec tous leurs attributs **/
		
		getLogger().info("VVJcJ est d�sactiv�");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("ville"))
		{
			boolean bool = (args[1] == "1");
			Ville.villes[Ville.nombreVilles] = new Ville(args[0], bool);
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("setpoint"))
		{
			//Variables permettant au Listener d'avoir des informations sur la commande
			VVJcJListener.commandSetpointEnabled = true;
			VVJcJListener.puspc = sender.getName();
			VVJcJListener.commandCanStop = false;
			for(int i = 0 ; i < Ville.villes.length ; i++)
			{
				do
				{
					if (Ville.villes[i].getNom() == args[0])
					{
						// Switch ajoutant le point o� est situ� le bloc important
						switch(args[1])
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
							sender.sendMessage("Vous n\'avez pas saisi un point valide");
						}
					}
				} while(!VVJcJListener.commandCanStop);
			}
			// Remise � zero des variables utilisees ici
			VVJcJListener.commandSetpointEnabled = false;
			VVJcJListener.puspc = "";
		}
		if(cmd.getName().equalsIgnoreCase("attaquer"))
		{
			for(int i = 0 ; i < Ville.villes.length ; i++)
			{
				if (Ville.villes[i].getNom() == args[0])
				{
					Ville.villes[i].attaquer();
				}
			}
		}
		return false;
	}
}