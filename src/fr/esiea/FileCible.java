package fr.esiea;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


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
		try { //ouvrir le fichier ou le creer
			 
			  File file = new File(path);
			  boolean success = file.createNewFile();
			 }
			 catch (IOException e){}
			 
			 try{//ecrire une ligne dans le fichier
			 
			 BufferedWriter outfile = new BufferedWriter(new FileWriter(path));
			 outfile.write(msg);
			 outfile.close();
			 }
			 catch (IOException e){}
	}


}
