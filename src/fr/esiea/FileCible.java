package fr.esiea;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;


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
		try {
            //Whatever the file path is.
            File filename = new File(path);
            FileOutputStream fileoutputstream = new FileOutputStream(filename);
            OutputStreamWriter ouputstreamwriter = new OutputStreamWriter(fileoutputstream);    
            Writer w = new BufferedWriter(ouputstreamwriter);
            w.write(msg);
            w.close();
        } catch (IOException e) {
            System.err.println("On ne peux pas écrire dans ce fichier");
        }
    }
}
