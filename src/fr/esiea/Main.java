package fr.esiea;


public class Main {
	

	public static void main(String [ ] args)
	{
		Configuration cfg = null;
		cfg = Configuration.getInstance();
		cfg.ReadFile();
	}
}
