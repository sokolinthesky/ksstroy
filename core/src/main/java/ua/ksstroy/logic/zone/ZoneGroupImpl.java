package ua.ksstroy.logic.zone;

import java.util.List;

public class ZoneGroupImpl implements ZoneGroup 
{
	private String name;
	private String id;
	private List<ZoneGroup> groups;
	private List<Zone> zones;
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public String getId()
	{
		return this.id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public List<ZoneGroup> getGroups()
	{
		return this.groups;
	}

	public void setGroups(List<ZoneGroup> groups)
	{
		this.groups = groups;
	}
	
	public List<Zone> getZones()
	{
		return this.zones;
	}
	
	public void setZone(List<Zone> zones)
	{
		this.zones = zones;
	}
	
}
