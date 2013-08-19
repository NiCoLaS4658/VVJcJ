package fr.vaevictis.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AttaqueEvent extends Event
{
	private Player player;
	private int villeAttaquee;
	public static final HandlerList handlers = new HandlerList();


	public AttaqueEvent(int villeAttaquee, Player p)
	{
		super();
		this.villeAttaquee = villeAttaquee;
		this.player = p;
	}
	
	public int getVilleAttaquee() {return villeAttaquee;}
	public Player getPlayer() {return player;}
	
	@Override
	public HandlerList getHandlers()
	{
		return handlers;
	}
	public static HandlerList getHandlerList()
	{
		return handlers;
	}
	

}
