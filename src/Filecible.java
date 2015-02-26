
public class FileCible extends AbstractCible{
	
	private String path;

	public FileCible(String path)
	{
		this.path = path;
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

}
