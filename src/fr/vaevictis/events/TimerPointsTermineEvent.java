package fr.vaevictis.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TimerPointsTermineEvent extends Event
{
	public TimerPointsTermineEvent()
	{
		super();
	}	
	public static final HandlerList handlers = new HandlerList();
	
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
