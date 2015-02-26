
// la classe nous permet de config le fonctionnement du log pour tout le projet
public class Configuration {
	
	// level par defaut
	Level lvl = Level.INFO;
	AbstractCible cib;
	
	// on utilise un singleton
	Configuration INSTANCE = new Configuration();
	
	public Configuration()
	{
		FileProperties();
	}
	
	// On cherche si un fichier properties existe et on le lit
	public void FileProperties()
	{
		String filename = "properties.txt";
	}
	
	// lvl qu'on va utiliser
	public void setLevel(Level lvl)
	{
		this.lvl = lvl;
	}
	
	public Level getLevel()
	{
		return lvl;
	}
	
	public void setLayout()
	{
		
	}
	
	public void setCible(AbstractCible cib)
	{
		this.cib = cib;
	}
	
	public AbstractCible getCible()
	{
		return cib;
	}
	
	public Configuration getInstance()
	{
		return INSTANCE;
	}

}
