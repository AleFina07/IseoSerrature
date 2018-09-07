
public class EccezionePostiEsauriti extends Exception 
{

private String messaggio;
	
	public EccezionePostiEsauriti(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}
