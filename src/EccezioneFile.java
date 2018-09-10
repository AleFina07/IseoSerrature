

public class EccezioneFile extends Exception 
{
	
	private String messaggio;
	public EccezioneFile (String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}

	
}
