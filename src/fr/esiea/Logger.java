package fr.esiea;
import java.util.Date;


enum Level { DEBUG("DEBUG"), INFO("INFO"), ERROR("ERROR");

	private String lvl;

	private Level(String lvl) {
		this.lvl = lvl;
	}

	public String getLvl()
	{
		return lvl;
	}
	
	public String toString()
	{
		return lvl;
	}
	
	
};

public class Logger {

	Class cl;
	Level l = Level.INFO;
	Configuration cfg;
	String lvl;
	String name;
	String appendTo;
	
	public Logger(Class cl)
	{
		this.cl = cl;
	}
	
	public Logger(Class cl, String name, String lvl, String appendTo)
	{
		this.cl = cl;
		this.lvl = lvl;
		this.name = name;
		this.appendTo = appendTo;
	}
	
	public void info(String msg)
	{
		l = findLvl(lvl);
		if(l.ordinal() <= Level.INFO.ordinal())
		{
			cfg.getInstance().getCible(this).WriteMsg(this.toString(msg, Level.INFO));
		}
	}
	
	public void debug(String msg)
	{
		l = findLvl(lvl);
		if(l.ordinal() <= Level.DEBUG.ordinal())
		{
			cfg.getInstance().getCible(this).WriteMsg(this.toString(msg, Level.DEBUG));
		}
	}
	
	public void error(String msg)
	{
		l = findLvl(lvl);
		if(l.ordinal() <= Level.ERROR.ordinal())
		{
			cfg.getInstance().getCible(this).WriteMsg(this.toString(msg, Level.ERROR));
		}
	}
	
	public String toString(String msg, Level lvl)
	{
		Date now = new Date(); 
		return now.toString() + " " + "[NAME=" + name + " LEVEL=" + lvl.toString() + " MESSAGE=" + msg + "]";
	}
	
	public String getName()
	{
		return cl.getName();
	}
	
	public String getAppendTo()
	{
		return appendTo;
	}
	
	public Level findLvl(String name)
	{
		for(Level l : Level.values())
		{
			if(l.getLvl().equals(name))
			{
				return l;
			}
		}
		return null;
	}
	
}
