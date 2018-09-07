
public class EccezioneDatiNonValidi extends Exception
{

	private String messaggio;
	
	public EccezioneDatiNonValidi(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}
