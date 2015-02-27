package fr.esiea;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {
	
	String formatDate;

	public Formatter(String formatDate)
	{
		this.formatDate = formatDate;
	}
	
	public String toString()
	{
		Date now = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat(formatDate);
		return dateFormatter.format(now);
	}
}
