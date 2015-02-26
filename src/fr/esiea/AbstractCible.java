package fr.esiea;

public abstract class AbstractCible {

	String name;
	String complement = "";
	
	public AbstractCible()
	{
		
	}
	
	public abstract void WriteMsg(String msg);
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String new_name)
	{
		name = new_name;
	}
	
	public String getCompl()
	{
		return complement;
	}
	
	public void setCompl(String n_com)
	{
		complement = n_com;
	}

}
