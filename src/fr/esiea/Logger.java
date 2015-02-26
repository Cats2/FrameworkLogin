package fr.esiea;
import java.util.Date;


enum Level { DEBUG("DEBUG"), INFO("INFO"), ERROR("ERROR"), WARNING("WARNING");

	private String lvl;

	private Level(String lvl) {
		this.lvl = lvl;
	}

	public String getLvl()
	{
		return lvl;
	}
};

public class Logger {

	Class cl;
	Configuration cfg;
	
	public Logger(Class cl)
	{
		this.cl = cl;
	}
	
	public void info(String msg)
	{
		if(cfg.getLevel().ordinal() >= Level.INFO.ordinal())
		{
			cfg.getInstance().getCible().WriteMsg(this.toString(msg, Level.INFO));
		}
	}
	
	public void debug(String msg)
	{
		if(cfg.getLevel().ordinal() >= Level.DEBUG.ordinal())
		{
			cfg.getInstance().getCible().WriteMsg(this.toString(msg, Level.DEBUG));
		}
	}
	
	public void error(String msg)
	{
		if(cfg.getLevel().ordinal() >= Level.ERROR.ordinal())
		{
			cfg.getInstance().getCible().WriteMsg(this.toString(msg, Level.ERROR));
		}
	}
	
	public void warn(String msg)
	{
		cfg.getInstance().getCible().WriteMsg(this.toString(msg, Level.WARNING));
	}
	
	public String toString(String msg, Level lvl)
	{
		Date now = new Date(); 
		return now.toString() + " " + "[NAME = ? LEVEL=" + lvl.toString() + " MESSAGE=" + msg + "]";
	}
	
}
