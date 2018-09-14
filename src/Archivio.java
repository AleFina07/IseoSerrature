
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.Serializable;
	import java.io.BufferedReader;

	public class Archivio implements Serializable
	{
		
		//Attributi
		private Utente[] elencoUtenti;
		private final int NUM_MAX_CARATTERI_CONTRATTO=100;
		private final int NUM_MAX_CARATTERI_CDC=4;
		private final int NUM_MAX_CARATTERI_NOMINATIVI=50;
		private final int NUM_MAX_CARATTERI_AZIENDA=15;
		private final int NUM_MAX_UTENTI= 1000000;
		
		public Archivio()
		{
			elencoUtenti=new Utente[1000000];
		}
		
		// aggiunge un partecipante nel primo "posto libero" dell'array.
		// Se non è possibile aggiungerlo perchè non vi è più spazio nella array viene sollevata un'eccezione 
		// del tipo EccezionePostiEsauriti.
		public void aggiungiUtente(Utente utente) throws EccezionePostiEsauriti
		{
			for (int i = 0; i < NUM_MAX_UTENTI; i++) 
			{
				if (elencoUtenti[i]==null)
				{
					elencoUtenti[i]=new Utente(utente);
					return;
				}
				
			}
			throw new EccezionePostiEsauriti ("Tutti i posti per l'inserimento dei numeri sono occupati");
		}
		
		
		
		//Restituisce il partecipante con il codice specificato.
		//Se il partecipante non è presente nell'elenco viene sollevata una eccezione del tipo EccezionePartecipanteNonPresente
		public Utente getUtente(long numeroCercato) throws EccezioneUtenteNonPresente
		{
			Utente u=null;
			for (int i = 0; i < NUM_MAX_UTENTI; i++) 
			{
				if (elencoUtenti[i]!=null)
				{
					if (elencoUtenti[i].getNumTel()==numeroCercato)
					{
						u=new Utente(elencoUtenti[i]);
						return u;
					}
				}
			}
			
			throw new EccezioneUtenteNonPresente("L'utente con numero di telefono "+u.getNumTel()+" non è presente nell'archivio");		
		}
		
		
		//Elimina il partecipante con il codice specificato.
		//Se il partecipante non è presente nell'elenco viene sollevata una eccezione del tipo EccezionePartecipanteNonPresente
		public void eliminaUtente(long numeroCercato) throws EccezioneUtenteNonPresente
		{
			Utente u=null;
			for (int i = 0; i < NUM_MAX_UTENTI; i++) 
			{
				if (elencoUtenti[i]!=null)
				{
					if (elencoUtenti[i].getNumTel()==numeroCercato)
					{
						elencoUtenti[i]=null;	//eliminazione dell'utente
						return;
					}
				}
			}
			
			throw new EccezioneUtenteNonPresente("L'utente con numero di telefono "+u.getNumTel()+" non è presente nell'archivio");		
		}
		
		public int getNumeroUtenti()
		{
			int contatore=0;
			for (int i = 0; i < NUM_MAX_UTENTI; i++) 
			{
				if (elencoUtenti[i]!=null)
					contatore++;
			}
			return contatore;
		}
		
		//Restituisce una stringa che contiene codice e nome dei partecipanti con una determinata marca di auto passata come paraemtro
		public String elencoUtentiAzienda (String azienda)
		{
			String risultato="";
			for (int i = 0; i < NUM_MAX_UTENTI; i++) 
			{
				if (elencoUtenti[i]!=null)
				{
					if (elencoUtenti[i].getAzienda().compareToIgnoreCase(azienda)==0)
					{
						risultato+=elencoUtenti[i].getNumTel()+" "+elencoUtenti[i].getNome()+ "\n";
					}
					
				}
			}
			if (risultato.compareTo("")==0)
				risultato="Nessun utente con azienda: "+azienda;
			return risultato;
		}
		
		
		
		static void scambia (Utente[] array, int pos1, int pos2)
		{
			Utente s=array[pos1];
			array[pos1]=array[pos2];
			array[pos2]=s;
		}
		
		/**
		 * Metodo  che ordina una array di Partecipante in ordine alfabetico in base al nome (A-Z) utilizzando l'algoritmo 
		 * Selection Sort. L'algoritmo non è Case sansitive, quindi ordina indipndentemente dal fatto che una nome
		 * contenga lettere minuscole o maiuscole.
		 * @return Altro array di Partecipante con i valori ordinati alfabeticamente (A-Z)
		 */
		public  Utente[] ordineAlfabetico()
		{
			
			//creo una array di partecipanti, chiamata risultato, in cui siano presenti tutti i partecipanti
			//senza "posti vuoti". Poi ordinerò l'array risultato
			
			int c=0; //contatore per costruire l'array da ordinare
			int numeroUtenti=numeroUtenti();  //numeroPartecipanti è un metodo che "conta" quanti partecipanti sono presenti nell'elenco
			Utente[] risultato=new Utente[numeroUtenti]; 
			
			for (int i = 0; i < NUM_MAX_UTENTI; i++) 
			{
				if (elencoUtenti[i]!=null)
				{
					risultato[c]=new Utente(elencoUtenti[i]);
					c++;
				}		
			}
			
			for (int i = 0; i < risultato.length-1; i++) 
			{
				for (int j = i+1; j < risultato.length; j++) 
				{
					if (risultato[i].getNome().compareToIgnoreCase(risultato[j].getNome())>0)
						scambia(risultato,i,j);
				}
			}
			return risultato;
		}
		
		/**
		 * Metodo  che ordina una array di Partecipante in ordine crescente in base al tempo impiegato utilizzando l'algoritmo 
		 * Selection Sort.
		 * @return Altro array di Partecipante con i valori ordinati alfabeticamente (A-Z)
		 */
		
		
		//Restituisce il numero di partecipanti presenti nell'elenco
		public int numeroUtenti()
		{
			int contatore=0;
			for (int i = 0; i < NUM_MAX_UTENTI; i++) 
			{
				if (elencoUtenti[i]!=null)
					contatore++;
			}
			return contatore;
		}
		
		
		//metodo che stampa su file i partecipanti in ordine alfabetico
		public void stampaSuFile(String nomefile) throws IOException, FileException
		{
			String stringaUtente1;
			
			Textfile fileUtenti= new Textfile(nomefile, 'W');
			Utente[] elencoAlfabetico;
			elencoAlfabetico=ordineAlfabetico();
			for (int i = 0; i < elencoAlfabetico.length; i++) 
			{
				
				stringaUtente1=elencoAlfabetico[i].getNome()+'\r'+elencoAlfabetico[i].getCognome()+"	"+elencoAlfabetico[i].getCdc()+"	"+elencoAlfabetico[i].getAzienda()+"	"+elencoAlfabetico[i].getNumTel()+"	"+elencoAlfabetico[i].getDispositivo()+"	"+elencoAlfabetico[i].getTipoDispositivo()+"	"+elencoAlfabetico[i].getOpzContratto()+"	"+elencoAlfabetico[i].getDataAssegnazione()+"	"+elencoAlfabetico[i].getStatoSim();
				fileUtenti.tofile(stringaUtente1);
			}
			
			if (elencoAlfabetico.length==0)
				fileUtenti.tofile("Nessun utente presente");
			fileUtenti.closFile();
		}
		
		//metodo per la serializzazione dei dati di una istanza della classe Gara
		//si ricorda che per serializzare i dati è necessario che le classi Gara, Partecipante e Tempo
		//implementino l'interfaccia Serializable
		public void salvaArchivio(String nomeFile) throws IOException
		{
			
			FileOutputStream f1=new FileOutputStream(nomeFile);
			ObjectOutputStream outputStream=new ObjectOutputStream(f1);
			
			outputStream.writeObject(this);
			outputStream.flush();
			outputStream.close();
		}
		
		//metodo per la deserializzazione dei una istanza di classe Gara precedentemente serializzata
		public Archivio caricaArchivio(String nomeFile) throws IOException
		{
		
			     
			FileInputStream f1= new FileInputStream(nomeFile);
			ObjectInputStream inputStream= new ObjectInputStream(f1);
			
			Archivio archivio=null;
			
			try 
			{
				archivio=(Archivio)inputStream.readObject();
			} 
			catch (ClassNotFoundException e) 
			{
				
				e.printStackTrace();
			}
			
			inputStream.close();
			return archivio;
		}
		
		// Crea una stringa contenente tutti i partecipanti inseriti
		public String toString()
		{
			String risultato="";
			for (int i = 0; i < NUM_MAX_UTENTI; i++) 
			{
				if (elencoUtenti[i]!=null)
				{
					risultato+=elencoUtenti[i].toString()+"\n";
				}
			}
			return risultato;
		}
		
	}


