import java.io.Serializable;
import java.time.LocalDateTime;

public class Utente implements Serializable
{
	private int codice;
	private String nome;
	private String cognome;
	private String cdc;
	private String azienda;
	private long numTel;
	private String dispositivo;
	private String tipoDispositivo;
	private String opzEstero;
	private String opzContratto;
	private LocalDateTime dataAssegnazione;
	private int anno;
	private int mese;
	private int giorno;
	private String statoSim;
	
	public Utente(String nome, String cognome, String cdc, String azienda, long numTel, String dispositivo, String tipoDispositivo, String opzEstero, String opzContratto, LocalDateTime dataAssegnazione, String statoSim)
	{
		setCodice(codice);
		setNome(nome);
		setCognome(cognome);
		setCdc(cdc);							//CENTRO COSTO
		setAzienda(azienda);
		setNumTel(numTel);
		setDispositivo(dispositivo);			//esempio: iPhone,iPad, Samsung
		setTipoDispositivo(tipoDispositivo);	//AZIENDALE\PROMISCUO
		setOpzEstero(opzEstero);				//SI\NO
		setOpzContratto(opzContratto);				
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
		setStatoSim(u.getStatoSim());
		
	}
	
	public Utente(int codice) 
	{
		
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
	
	public long getNumTel() 
	{
		return numTel;
	}
	
	public void setNumTel(long numTel) 
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
	
	public String getOpzContratto() 
	{
		return opzContratto;
	}
	
	public void setOpzContratto(String opzContratto) 
	{
		this.opzContratto = opzContratto;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getMese() {
		return mese;
	}

	public void setMese(int mese) {
		this.mese = mese;
	}

	public int getGiorno() {
		return giorno;
	}

	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}


	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}
	
	public String toString()
	{
		return ("Nome ---------------> "+getNome()+'\n'+ "Cognome ------------> "+ getCognome()+'\n'+"Centro costo -------> "+getCdc()+'\n'+"Azienda ------------> "+getAzienda()+'\n'+ "Numero Telefono ----> "+getNumTel()+'\n'+"Dispositivo --------> "+ getDispositivo()+  '\n' +"Tipo Dispositivo ---> "+getTipoDispositivo()+'\n'+"Opzione contratto --> "+getOpzContratto()+'\n'+"Data Assegnazione --> "+getDataAssegnazione()+'\n'+"Stato SIM ----------> "+getStatoSim());
	}

	public String getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public String getOpzEstero() {
		return opzEstero;
	}

	public void setOpzEstero(String opzEstero) {
		this.opzEstero = opzEstero;
	}

	public String getStatoSim() {
		return statoSim;
	}

	public void setStatoSim(String statoSim) {
		this.statoSim = statoSim;
	}

	public LocalDateTime getDataAssegnazione() {
		return dataAssegnazione;
	}

	public void setDataAssegnazione(LocalDateTime dataAssegnazione) {
		this.dataAssegnazione = dataAssegnazione;
	}
	
}
