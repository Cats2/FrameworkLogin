package fr.esiea;


public class ConsoleCible extends AbstractCible{

	String name;
	public ConsoleCible(String name)
	{
		this.name = name;
	}
	
	public ConsoleCible()
	{
		
	}

	@Override
	public void WriteMsg(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}

}
