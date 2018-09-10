import java.io.IOException;
import java.io.Serializable;
import java.nio.Buffer;
import java.time.LocalDateTime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainClass implements Serializable
{
	
	
	public static void main(String[] args) throws FileException, EccezioneFile
	{

		Archivio a1= new Archivio();
		//Deserializzazione
		String nomeFileBinario="Archivio.bin";
		try 
		{
			a1=a1.caricaArchivio(nomeFileBinario);
		} 
		catch (IOException e1) 
		{
			System.out.println("Non è possibile caricare i dati dal file "+nomeFileBinario);
		}
		
		//creo le voci del menu
		String[] elencoVociMenu1= {
				"0---> Esci",
				"1---> Aggiungi un utente",
				"2---> Visualizza dati di un utente cercando il numero",
				"3---> Elimina un utente",
				"4---> Visualizza utenti di una specifica azienda",
				"5---> Visualizza utenti in ordine alfabetico",
				"6---> Stampa su file di testo l'elenco degli utenti in ordine alfabetico", };
		
		//creo il menu
		Menu menu1=new Menu("MENU SOFTWARE ISEO SERRSTURE S.P.A.     @AlessandroFinazzi", elencoVociMenu1);
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
				System.out.println("L'applicazione verrà terminata.......ARRIVEDERCI");
				break;
				//-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
			case 1: //Inserimento nuovo utente
				int codice = 0;
				//---------------------------------
				String nome = null;
				//---------------------------------
				String cognome= null;
				//---------------------------------
				String cdc = null;
				//---------------------------------
				String azienda= null;
				//---------------------------------
				int numTel = 0;
				//---------------------------------
				String dispositivo= null;
				String tipoDispositivo = null;
				//---------------------------------
				boolean ok;
				//---------------------------------
				String opzEstero= null;
				//---------------------------------
				String opzContratto= null;
				LocalDateTime dataAssegnazione = null;
				//---------------------------------
				String statoSim= null;
				//----------------------------------
				int anno=0, mese=0, giorno=0;
				//----------------------------------
				
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
					numTel=tastiera.ReadInt();
					System.out.println("Inserire la marca del dispositivo(es. iPhone,iPad,Samsung, ecc...)");
					dispositivo=tastiera.ReadString();
					System.out.println("Inserire la tipologia di dispositivo: aziendale o promiscuo");
					tipoDispositivo=tastiera.ReadString();
					/*String promiscuo = "promiscuo";
					String aziendale = "aziendale";
	
					
					
						if (inserimento== "aziendale") 
						{
							tipoDispositivo= inserimento;
							ok=true;
						}
						else if(inserimento== "promiscuo")
						{
							tipoDispositivo = inserimento;
							ok=true;
						}
						else
						{
							System.out.println("Inserimento non corretto, riprovare ");
							ok=false;
						}
	
					} while (ok=true);
					
					*/
					System.out.println("Inserisci se è attiva l'opzione estero: si o no");
					opzEstero=tastiera.ReadString();
					
					/*	
						if (opz== "si") 
						{
							opzEstero= "promiscuo";
							ok=true;
						}
						else if(opz== "no")
						{
							opzEstero = "no";
							ok=true;
						}
						else
						{
							System.out.println("Inserimento non corretto, riprovare ");
							ok=false;
						}
	
					} while (ok=true);
					*/
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
					dataAssegnazione=LocalDateTime.now();
					
					System.out.println("Inserisci lo stato della SIM: Attiva o chiusa");
					statoSim=tastiera.ReadString();
				}	
					/*stato=tastiera.ReadString();
					
						
						if (stato== "attiva") 
						{
							statoSim= "attiva";
							ok=true;
						}
						else if(stato== "chiusa")
						{
							tipoDispositivo = "chiusa";
							ok=true;
						}
						else
						{
							System.out.println("Inserimento non corretto, riprovare ");
							ok=false;
						}
	
					} while (ok=false);
					
					*/
					
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
					Utente u=new Utente(nome, cognome, cdc,azienda,numTel, dispositivo, tipoDispositivo, opzEstero, opzContratto,dataAssegnazione, statoSim);
					a1.aggiungiUtente(u);
					a1.salvaArchivio(nomeFileBinario);  //Serializzazione
				} 
				catch (EccezionePostiEsauriti e) 
				{
					System.out.println(e.toString());
				} 
				catch (IOException e) 
				{
					System.out.println("Non è stato possibile salvare la modifica sul file "+nomeFileBinario);
				}
				break;
			//-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
			case 2: //Visualizzazione di un utente
				System.out.println("Inserisci il numero di telefono dell'utente da cercare all'interno dell' archivio");
				int numeroCercato = 0;
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
					System.out.println("Partecipante con codice "+numeroCercato+ " eliminato con successo");
					a1.salvaArchivio(nomeFileBinario);
				} 
				catch (EccezioneUtenteNonPresente e) 
				{
					System.out.println(e.toString());
				} 
				catch (IOException e) 
				{
					System.out.println("Non è stato possibile salvare la modifica sul file "+nomeFileBinario);
				}
				
				
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
					System.out.println("-----------"+i+"------------");
					System.out.println(elenco[i].toString()+'\n');
					
				}
				if (elenco.length==0)
				{
					System.out.println("Nessun utente presente nell'archivio");
				}
				System.out.println();
				break;
				
			case 6: //Stampa su file
				String nomeFile="ElencoUtenti.txt";
				try 
				{
					a1.stampaSuFile(nomeFile);
					System.out.println("Scrittura sul file "+nomeFile+" avvenuta correttamente.");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile scrivere sul file "+nomeFile);
				}
				break;
			default:
				System.out.println("Scelta del menu non valida........riprovare");
				break;
			}
		}	
	}	
}