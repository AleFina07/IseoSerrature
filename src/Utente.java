import java.io.Serializable;
import java.time.LocalDateTime;

public class Utente 
{
	private String nome;
	private String cognome;
	private String cdc;
	private String azienda;
	private int numTel;
	private String dispositivo;
	private boolean tipoDispositivo;
	private boolean opzEstero;
	private String opzContratto;
	private LocalDateTime dataAssegnazione;
	private boolean statoSim;
	
	public Utente(String nome, String cognome, String cdc, String azienda, int numTel, String dispositivo, boolean tipoDispositivo, boolean opzEstero, String opzContratto, LocalDateTime dataAssegnazione, boolean statoSim)
	{
		setNome(nome);
		setCognome(cognome);
		setCdc(cdc);							//CENTRO COSTO
		setAzienda(azienda);
		setNumTel(numTel);
		setDispositivo(dispositivo);			//esempio: iPhone,iPad, Samsung
		setTipoDispositivo(tipoDispositivo);	//AZIENDALE\PROMISCUO
		setOpzEstero(opzEstero);				//SI\NO
		setOpzContratto(opzContratto);				
		setDataAssegnazione(dataAssegnazione);
		setStatoSim(statoSim);					//ATTIVA\CHIUSA
		
	}
	
	public Utente (Utente u)
	{
		setNome(u.getNome());
		setCognome(u.getCognome());
		setCdc(u.getCdc());
		setAzienda(u.getAzienda());
		setNumTel(u.getNumTel());
		setDispositivo(u.getDispositivo());
		setTipoDispositivo(u.getTipoDispositivo());
		setOpzEstero(u.getOpzEstero());
		setOpzContratto(u.getOpzContratto());
		setDataAssegnazione(u.getDataAssegnazione());
		setStatoSim(u.getStatoSim());
		
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getCognome() 
	{
		return cognome;
	}
	
	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}
	
	public String getCdc() 
	{
		return cdc;
	}
	
	public void setCdc(String cdc) 
	{
		this.cdc = cdc;
	}
	
	public String getAzienda() 
	{
		return azienda;
	}
	
	public void setAzienda(String azienda) 
	{
		this.azienda = azienda;
	}
	
	public int getNumTel() 
	{
		return numTel;
	}
	
	public void setNumTel(int numTel) 
	{
		this.numTel = numTel;
	}
	
	public String getDispositivo() 
	{
		return dispositivo;
	}
	
	public void setDispositivo(String dispositivo) 
	{
		this.dispositivo = dispositivo;
	}
	
	public Boolean getTipoDispositivo() 
	{
		return tipoDispositivo;
	}
	
	public void setTipoDispositivo(Boolean tipoDispositivo) 
	{
		this.tipoDispositivo = tipoDispositivo;
	}
	
	public String getOpzContratto() 
	{
		return opzContratto;
	}
	
	public void setOpzContratto(String opzContratto) 
	{
		this.opzContratto = opzContratto;
	}
	
	public Boolean getOpzEstero() 
	{
		return opzEstero;
	}
	
	public void setOpzEstero(Boolean opzEstero) 
	{
		this.opzEstero = opzEstero;
	}
	
	public LocalDateTime getDataAssegnazione() 
	{
		return dataAssegnazione;
	}
	
	public void setDataAssegnazione(LocalDateTime dataAssegnazione) 
	{
		this.dataAssegnazione = dataAssegnazione;
	}
	
	public Boolean getStatoSim()
	{
		return statoSim;
	}
	
	public void setStatoSim(Boolean statoSim) 
	{
		this.statoSim = statoSim;
	}
	
	
	public String toString()
	{
		return (getNome()+" "+ getCognome()+" "+getCdc()+" "+getAzienda()+ " "+getNumTel()+" "+getTipoDispositivo()+" "+getOpzContratto()+" "+getDataAssegnazione()+" "+getStatoSim());
	}
	
	
}
