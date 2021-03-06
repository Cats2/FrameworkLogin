package fr.esiea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.text.Document;


// la classe nous permet de config le fonctionnement du log pour tout le projet
public class Configuration {
	
	// level par defaut
	Level lvl = Level.INFO;
	AbstractCible cib;
	ArrayList<AbstractCible> cibles = new ArrayList<AbstractCible>();
	ArrayList<Logger> loggers = new ArrayList<Logger>();
	
	// on utilise un singleton
	static Configuration INSTANCE;
	
	public Configuration()
	{
		File f = new File("D:\\Users\\sobernar\\Documents\\GitHub\\FrameworkLogin\\src\\properties.txt");
		if(f.exists())
		{
			ReadFile();
		}
		
	}
	
	// On cherche si un fichier properties existe et on le lit
	public void FileProperties()
	{
		
	}
	
	public void ReadFile()
	{
		System.out.println("ReadFile");
		String chaine="";
		String fichier = "D:\\Users\\sobernar\\Documents\\GitHub\\FrameworkLogin\\src\\properties.txt" ;
		
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				chaine = ligne;
				if (chaine.contains("cible"))
				{
					String type = "";
					String file = "";
					String name = "";
					String delims = " ";
					String[] tokens = chaine.split(delims);
					for( String t : tokens)
					{
						if(t.contains("type"))
						{
							String delims2 = "=";
							String[] tokens2 = t.split(delims2);
							type = tokens2[1];
						}
						if(t.contains("path"))
						{
							String delims2 = "=";
							String[] tokens2 = t.split(delims2);
							file = tokens2[1];
						}
						if(t.contains("name"))
						{
							String delims2 = "=";
							String[] tokens2 = t.split(delims2);
							name = tokens2[1];
						}
					}
					Class cl = Class.forName(type);
					Object obj = cl.newInstance();
					AbstractCible as = (AbstractCible)obj;
					as.setName(name);
					as.setCompl(file);
					cibles.add(as);
				}
				if (chaine.contains("logger"))
				{
					String level = "";
					String appendTo = "";
					String name = "";
					String format = "";
					String delims = " ";
					String[] tokens = chaine.split(delims);
					for( String t : tokens)
					{
						if(t.contains("name"))
						{
							String delims2 = "=";
							String[] tokens2 = t.split(delims2);
							name = tokens2[1];
						}
						else if(t.contains("level"))
						{
							String delims2 = "=";
							String[] tokens2 = t.split(delims2);
							level = tokens2[1];
						}
						else if(t.contains("appendTo"))
						{
							String delims2 = "=";
							String[] tokens2 = t.split(delims2);
							appendTo = tokens2[1];
						}
					}
					String delims2 = "\"";
				    String[] tokens2 = chaine.split(delims2);
					format = tokens2[1];
					Class cl = Class.forName(name);
					loggers.add(new Logger(cl, name, level, appendTo ,new Formatter(format)));
				}
			}
			br.close(); 
			System.out.println("fichier lu");
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	
	}
	
	// ex param : Boitier.class.getName()
	public Logger getLogger(Class cl)
	{
		for(Logger l : loggers)
		{
			if(l.getName() == cl.getName())
			{
				return l;
			}
		}
		return null;
	}
	
	public void WriteLog()
	{
		
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
	
	public AbstractCible getCible(Logger l)
	{
		for( AbstractCible c : cibles)
		{
			System.out.println(c.getName());
			if(c.getName().equals(l.getAppendTo()))
			{
				return c;
			}
		}
		return null;
	}
	
	public static Configuration getInstance()
	{
		System.out.println("inst");
		if (INSTANCE == null)
		{
			INSTANCE = new Configuration();
		}
		return INSTANCE;
	}
	
	public void addLogger(Class cl, String name, String level, String appentTo, Formatter form)
	{
		Logger l = new Logger(cl, name, level, appentTo, form);
		loggers.add(l);
	}
	
	public void addCible(String name, String type, String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		Class cl = Class.forName(type);
		Object obj = cl.newInstance();
		AbstractCible as = (AbstractCible)obj;
		as.setName(name);
		as.setCompl(path);
		cibles.add(as);
	}

}
