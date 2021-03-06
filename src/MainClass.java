import java.io.IOException;
import java.io.Serializable;
import java.nio.Buffer;
import java.time.LocalDateTime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigInteger;


public class MainClass implements Serializable
{
	
	
	public static void main(String[] args) throws FileException, EccezioneFile, EccezioneDatiNonValidi
	{
		/*
		JFrame finestra= new JFrame("la mia prima bela finestra");
		finestra.setBounds(500, 500, 600, 300);
		
		finestra.setVisible(true);
		*/
		int f = 0;
		Archivio a1= new Archivio();
		Archivio a2= new Archivio();
		//Deserializzazione
		String nomeFileBinario="Archivio.bin";
		String incremento= "Incremento.txt";
		try 
		{
			a1=a1.caricaArchivio(nomeFileBinario);
		} 
		catch (IOException e1) 
		{
			System.out.println("Non � possibile caricare i dati dal file "+nomeFileBinario);
		}
		//creo le voci del menu
		String[] elencoVociMenu1= {
				"0---> Esci",
				"------------------------------------------------------",
				"1---> Aggiungi un utente",
				"------------------------------------------------------",
				"2---> Visualizza dati di un utente cercando il numero",
				"------------------------------------------------------",
				"3---> Elimina un utente",
				"------------------------------------------------------",
				"4---> Visualizza utenti di una specifica azienda",
				"------------------------------------------------------",
				"5---> Visualizza utenti in ordine alfabetico",
				"------------------------------------------------------",
				"6---> Stampa su file di testo l'elenco degli utenti in ordine alfabetico", 
				"------------------------------------------------------",};
		
		//creo il menu
		Menu menu1=new Menu("MENU SOFTWARE ISEO SERRSTURE S.P.A.     @Applicazione di AlessandroFinazzi", elencoVociMenu1);
		ConsoleInput tastiera=new ConsoleInput();
		//invoco il metodo che consente all'utente di scegliere una voce del menu
		int scelta=1;
		
		//Gestione del menu
		
		while (scelta!=0)
		{
			scelta=menu1.scelta();
			
			switch (scelta) 
			{
			case 0:
				System.out.println("L'applicazione verr� terminata.......ARRIVEDERCI");
				break;
		//-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
			case 1: //Inserimento nuovo utente
				//---------------------------------
				String nome = null;
				//---------------------------------
				String cognome= null;
				//---------------------------------
				String cdc = null;
				//---------------------------------
				String azienda= null;
				//---------------------------------
				long numTel = 0;
				//---------------------------------
				String dispositivo= null;
				String tipoDispositivo = null;
				//---------------------------------
				String opzEstero= null;
				//---------------------------------
				String opzContratto= null;
				//---------------------------------
				String statoSim = null;
				//----------------------------------
				int anno=0, mese=0, giorno=0;
				//----------------------------------
				LocalDateTime dataAssegnazione = null;
				//----------------------------------
				try 
				{
					Utente u=new Utente(a1.getNumeroUtenti()+1);
					System.out.println("Inserisci il nome");
					nome=tastiera.ReadString();
					System.out.println("Inserisci il cognome");
					cognome=tastiera.ReadString();
					System.out.println("Inserisci il  codice da 4 cifre del centro costo");
					cdc=tastiera.ReadString();
					System.out.println("Inserisci il nome dell'azienda");
					azienda=tastiera.ReadString();
					System.out.println("Inserisci il numero di telefono");
					numTel=tastiera.ReadLong();
					System.out.println("Inserire la marca del disositivo(es. iPhone, iPad, Samsung, ecc...)");
					dispositivo=tastiera.ReadString();
					//String az= "aziendale";
					//String pr= "promiscuo";
					System.out.println("Inserire la tipologia di dispositivo: aziendale o promiscuo");
					tipoDispositivo=tastiera.ReadString();
					/*	do {
						if (tipoDispositivo == az) 
							{
								tipoDispositivo= az;
								return;
							}
						else if(tipoDispositivo == pr)
							{
								tipoDispositivo = pr;
								return;
							}
						else
							{
								System.out.println("SCELTA ERRATA.....REINSERIRE");
							}
					} while (tipoDispositivo != az || tipoDispositivo != pr);
					*/
					
					
						
					System.out.println("Inserisci se � attiva l'opzione estero: si o no");
					opzEstero=tastiera.ReadString();
					System.out.println("Inserisci l'opzione del contratto(massimo 100 caratteri)");
					opzContratto=tastiera.ReadString();
					//Data del contatto
					System.out.println("Inserisci la data della registrazione: ");
					System.out.print("Anno: ");
					anno=tastiera.ReadInt();
					System.out.print("Mese(numero): ");
					mese=tastiera.ReadInt();
					System.out.print("Giorno(numero): ");
					giorno=tastiera.ReadInt();
					System.out.println("Inserisci lo stato della SIM: Attiva o chiusa");
					statoSim=tastiera.ReadString();
				}	
					
				catch (NumberFormatException e) 
				{
					System.out.println("Dato inserito non corretto");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile leggere da tastiera");
				}
				//Istanzio il nuovo partecipante
				
				try 
				{
					Utente u=new Utente(nome, cognome, cdc,azienda,numTel, dispositivo, tipoDispositivo, opzEstero, opzContratto, new Data(anno, mese, giorno), statoSim);
					a1.aggiungiUtente(u);
					a1.salvaArchivio(nomeFileBinario);  //Serializzazione
					System.out.println("Serializzazione avvenuta con successo");
				} 
				catch (EccezionePostiEsauriti e) 
				{
					System.out.println(e.toString());
				} 
				catch (IOException e) 
				{
					System.out.println("Non � stato possibile salvare la modifica sul file "+nomeFileBinario);
				}
				System.out.println("PREMI QUALSIASI TASTO PER TORNARE AL MENU");
				
		
				break;
				
			//-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
			case 2: //Visualizzazione di un utente
				System.out.println("Inserisci il numero di telefono dell'utente da cercare all'interno dell' archivio");
				long numeroCercato = 0;
				try
				{
					numeroCercato=tastiera.ReadLong();
				} 
				catch (NumberFormatException e) 
				{
					System.out.println("Dato inserito non corretto");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile leggere da tastiera");
				}
				
				Utente utenteCercato;
				try 
				{
					utenteCercato=a1.getUtente(numeroCercato);
					System.out.println(utenteCercato.toString());
				} 
				catch (EccezioneUtenteNonPresente e) 
				{
					System.out.println(e.toString());
				}
				
				
				
				break;	
				
			//-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
				
			case 3: //Eliminazione di un partecipante
				System.out.println("Inserisci il numero di telefono del partecipante da eliminare");
				numeroCercato = 0;
				try
				{
					numeroCercato=tastiera.ReadInt();
				} 
				catch (NumberFormatException e) 
				{
					System.out.println("Dato inserito non corretto");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile leggere da tastiera");
				}
				
				try 
				{
					a1.eliminaUtente(numeroCercato);
					System.out.println("Partecipante con numero di telefono "+numeroCercato+ " eliminato con successo");
					a1.salvaArchivio(nomeFileBinario);
				} 
				catch (EccezioneUtenteNonPresente e) 
				{
					System.out.println(e.toString());
				} 
				catch (IOException e) 
				{
					System.out.println("Non � stato possibile salvare la modifica sul file "+nomeFileBinario);
				}
				
				break;
				
				//////////////////////////////////////////////////////////////////////////////////////////////
				
				
				
			
			
			case 4://Visualizza elenco degli utenti per una specifica azienda
				
				String aziendaCercata = null;
				System.out.println("Inserisci il nome dell'azienda");
				try 
				{
					aziendaCercata=tastiera.ReadString();
				} 
				catch (NumberFormatException e) 
				{
					System.out.println("Dato inserito non corretto");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile leggere da tastiera");
				}
				
				System.out.println(a1.elencoUtentiAzienda(aziendaCercata));
				
				break;	
		
			case 5: //Visualizza gli utenti in ordine alfabetico
				Utente[] elenco=null;
				elenco=a1.ordineAlfabetico();
				for (int i = 0; i < elenco.length; i++) 
				{
					System.out.println("**********"+"Utente n. "+(i+1)+"**********");
					
					System.out.println(elenco[i].getNome()+'\n'+elenco[i].getCognome());
					
				}
				if (elenco.length==0)
				{
					System.out.println("Nessun utente presente nell'archivio");
				}
				
				
				break;
				
			
			case 6: //Stampa su file
				try 
				{
					a2=a2.caricaArchivio(incremento);
				} 
				catch (IOException e1) 
				{
					System.out.println("Non � possibile caricare i dati dal file "+incremento);
				}
					
				String nomeFile="ElencoUtenti"+(f)+".txt";
				try 
				{
					a1.stampaSuFile(nomeFile);
					System.out.println("Scrittura sul file "+nomeFile+" avvenuta correttamente.");
				} 
				catch (IOException e) 
				{	
					System.out.println("Impossibile scrivere sul file "+nomeFile);
				}
				f++;
				try 
				{
					f=f;
					a1.salvaArchivio(incremento);  //Serializzazione
					System.out.println("Serializzazione avvenuta con successo");
				} 
				
				catch (IOException e) 
				{
					System.out.println("Non � stato possibile salvare la modifica sul file "+nomeFileBinario);
				}
				System.out.println("PREMI QUALSIASI TASTO PER TORNARE AL MENU");
				
				break;
			default:
				System.out.println("Scelta del menu non valida........riprovare");
				break;
			}
		}	
	}
}