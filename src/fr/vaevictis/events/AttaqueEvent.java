package fr.vaevictis.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AttaqueEvent extends Event
{
	private int villeAttaquee;
	public static final HandlerList handlers = new HandlerList();



	public AttaqueEvent(int villeAttaquee)
	{
		super();
		this.villeAttaquee = villeAttaquee;
	}
	
	public int getVilleAttaquee() {return villeAttaquee;}
	
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
