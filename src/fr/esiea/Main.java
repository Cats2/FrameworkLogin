package fr.esiea;


public class Main {
	

	public static void main(String [ ] args)
	{
		Logger log = Configuration.getInstance().getLogger(Main.class);
		log.error("Why not");
	}
}
