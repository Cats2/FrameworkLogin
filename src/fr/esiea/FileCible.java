package fr.esiea;


public class FileCible extends AbstractCible{
	
	private String path;
	private String name;

	public FileCible(String path, String name)
	{
		this.path = path;
		this.name = name;
	}
	
	public FileCible()
	{
	}
	
	@Override
	public void WriteMsg(String msg) {
		// TODO Auto-generated method stub
		write(msg);
	}
	
	public void write(String msg)
	{
		//ouvrir le fichier ou le creer, ecrire une ligne
	}

	@Override
	public void ReadCibleproperties() {
		// TODO Auto-generated method stub
		
	}

}
