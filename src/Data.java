import java.io.Serializable;

public class Data implements Serializable
{
//Attributi
	private int anno;
	private int mese;
	private int giorno;

	public  Data(int anno, int mese, int giorno) throws EccezioneDatiNonValidi
	{
		setAnno(anno);
		setMese(mese);
		setGiorno(giorno);
	}
	
	public Data(Data d) throws EccezioneDatiNonValidi
	{
		setAnno(d.getAnno());
		setMese(d.getMese());
		setGiorno(d.getMese());
	}
	
/*	public Tempo()
	{
		setOre(0);
		setMinuti(0);
		setSecondi(0);
	}
*/	
	public int getAnno()
	{
		return anno;
	}
	
	//se parametro è al di fuori dei limiti previsti (0-23) viene sollevata una eccezione di tipo 
	//EccezioneDatiNonValidi
	public void setAnno(int anno) throws EccezioneDatiNonValidi
	{
		if (anno<2000 || anno >5000)
			throw new EccezioneDatiNonValidi("Anno non valide");
		else
			this.anno = anno;
	}
	public int getMese() 
	{
		return mese;
	}
	
	//se parametro minuti è al di fuori dei limiti previsti (0-59) viene sollevata una eccezione di tipo 
	//EccezioneDatiNonValidi
	public void setMese(int mese) throws EccezioneDatiNonValidi 
	{
		if (mese<0 || mese>12)
			throw new EccezioneDatiNonValidi("Minuti inseriti non validi");
		else
			this.mese = mese;
	}
	public int getGiorno() 
	{
		
		return giorno;
	}
	
	//se parametro secondi è al di fuori dei limiti previsti (0-59) viene sollevata una eccezione di tipo 
	//EccezioneDatiNonValidi
	public void setGiorno(int giorno) throws EccezioneDatiNonValidi
	{
		
		if (giorno<0 || giorno>31)
			throw new EccezioneDatiNonValidi("Secondi inseriti non validi");
		else
			this.giorno=giorno;
	}
	/*
	private int tuttoInSecondi(Tempo t)
	{
		return (t.getOre()*3600+t.getMinuti()*60+t.getSecondi());
	}
	*/
	/*
	public int compareTo(Data d)
	{
		int thisGiorno=tuttoInSecondi(this);
		int tSecondi=tuttoInSecondi(t);
		if (thisSecondi==tSecondi)
			return 0;
		else if (tSecondi>thisSecondi)
			return 1;
		else
			return-1;
	}*/
	
	public String toString()
	{
		return(getAnno()+":"+getMese()+":"+getGiorno());
	}
}
