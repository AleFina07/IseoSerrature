
public class EccezioneUtenteNonPresente extends Exception 
{

	private String messaggio;
	
	public EccezioneUtenteNonPresente(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}

