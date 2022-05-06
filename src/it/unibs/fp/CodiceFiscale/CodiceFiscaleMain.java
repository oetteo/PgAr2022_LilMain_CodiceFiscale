package it.unibs.fp.CodiceFiscale;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;


/**
 * Il main ha la finalita' di leggere 3 documenti xml contenenti dati su delle persone, codici fiscali e comuni con relativi codici.
 * Lo scopo del programma e' fornire in output un documento xml che accoppia i codici fiscali alle persone, trovandone in caso
 * di spaiati, assenti o non validi.
 * @author Lil Main
 *
 */
public class CodiceFiscaleMain {

	
	public static void main(String[] args) {
			
		
		String nomePersona = null; 
		String cognomePersona = null;
		String sessoPersona = null;
		String comunePersona = null;
		String dataPersona = null;
		String annoS = null ;
		String meseS = null;
		String giornoS = null;
		String nomeComune = null;
		String codiceComune = null;
		int anno = 0 ;
		int mese = 0;
		int giorno = 0;
		String tipo = null;
	
		
	//lettura inputPersone.xml
		ArrayList<Persona> persone = new ArrayList<Persona>();
		ArrayList<Persona> personeCFAssente = new ArrayList<Persona>(); //persone senza CF
		
			XMLInputFactory xmlif = null;
			XMLStreamReader xmlr = null;
			try {
			 xmlif = XMLInputFactory.newInstance();
			 xmlr = xmlif.createXMLStreamReader("inputPersone.xml", new FileInputStream("inputPersone.xml"));
			} catch (Exception e) {
			 System.out.println("Errore nell'inizializzazione del reader:");
			 System.out.println(e.getMessage());
			}

			
			try {
				while (xmlr.hasNext()) { 
			
					
					switch (xmlr.getEventType()) { 
					 case XMLStreamConstants.START_DOCUMENT:
					 break;
					 
					 case XMLStreamConstants.START_ELEMENT: 
					 
					 
					 tipo = xmlr.getLocalName(); 
					 break;
					 
					 
					 case XMLStreamConstants.END_ELEMENT: 
					 break;
					 
					 case XMLStreamConstants.COMMENT:
					  break; 
					 
					 case XMLStreamConstants.CHARACTERS: 						
		//per capire se sta leggendo un nome o un cognome o una data...
						 switch(tipo) { 
						 case "nome": 
						 {	
							 if(!xmlr.getText().equals("\n        ")) {
								 nomePersona = xmlr.getText();
							 	}
							 
							 break;
							 
						 } 
						 case "cognome":
						 {
							 if(!xmlr.getText().equals("\n        ")) {
								 cognomePersona = xmlr.getText();
							 }
							 break;
						 }  
						 
						 case "sesso":
						 {
							 if(!xmlr.getText().equals("\n        ")) {
								 sessoPersona = xmlr.getText();
							 }
							 break;
						 }  
						 
						 case "comune_nascita":
						 {
							 if(!xmlr.getText().equals("\n        ")) {
								 comunePersona = xmlr.getText();
							 }
							 break;
						 }  
						
						 case "data_nascita": //qua dentro si crea direttamente la persona in quanto è l'ultimo attributo
						 {
							 if(!xmlr.getText().equals("\n        ")) {
								 dataPersona = xmlr.getText(); //per convertire la data e "spezzarla"
								 //se non funziona rimettere fuori dall'if
								 char[] annoC = new char[4];
								 for(int j = 0 ; j < 4 ; j++)
									 annoC[j]=dataPersona.charAt(j);
								  annoS = String.copyValueOf(annoC) ;
								  
								 char[] meseC = new char[2];
								  meseC[0]=dataPersona.charAt(5);
								  meseC[1]=dataPersona.charAt(6);
								  meseS = String.copyValueOf(meseC) ;
								  
								 char[] giornoC = new char[2];
								  giornoC[0]=dataPersona.charAt(8);
								  giornoC[1]=dataPersona.charAt(9);
								  giornoS = String.copyValueOf(giornoC) ;
								  
								  anno = Integer.parseInt(annoS);
								  mese = Integer.parseInt(meseS);
								  giorno = Integer.parseInt(giornoS);
								
								  
								  Persona persona = new Persona(cognomePersona, nomePersona, sessoPersona, comunePersona, giorno, mese, anno); 
									persone.add(persona);
							  
							 }
							 
							 tipo = "niente";
							
							break;
						 }  
										 
						 }
					
						 break;
					 }
					 xmlr.next();
				}
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}
	//fine lettura inputPersone.xml
			
			
	//lettura comuni.xml
			//....
			ArrayList<Comune> listaComuni = new ArrayList<>() ;
			
			XMLInputFactory xmlif2 = null;
			XMLStreamReader xmlr2 = null;
			try {
			 xmlif2 = XMLInputFactory.newInstance();
			 xmlr2 = xmlif2.createXMLStreamReader("comuni.xml", new FileInputStream("comuni.xml"));
			} catch (Exception e) {
			 System.out.println("Errore nell'inizializzazione del reader:");
			 System.out.println(e.getMessage());
			}
			
			
			try {
				while (xmlr2.hasNext()) { 
					
					switch (xmlr2.getEventType()) {
					 case XMLStreamConstants.START_DOCUMENT:  break;
					 
					 case XMLStreamConstants.START_ELEMENT: 
					 tipo = xmlr2.getLocalName(); 
					 break;

					 case XMLStreamConstants.CHARACTERS: 				
						 switch(tipo) { 
						 case "nome": 
						 	
							 if(!xmlr2.getText().equals("\n        ")) 
								 nomeComune = xmlr2.getText();
							 break;
							  
						 case "codice":
						 
							 if(!xmlr2.getText().equals("\n        ")) {
								 codiceComune = xmlr2.getText();
								//se non funziona rimettere fuori dall'if 
								 Comune comune = new Comune(nomeComune, codiceComune); 

								 for(int i = 0 ; i < persone.size() ; i++) {
									 if(persone.get(i).getComuneNascita().equals(nomeComune))
										 persone.get(i).setComune(comune);
								
									listaComuni.add(comune);
							 }
							 break;
						 }  
						 }
						 tipo = "niente";
						 
						 break;
					 }
					 xmlr2.next();
				}
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}
			
	//lettura codiciFiscali.xml
		//....
			ArrayList<String> listaCF = new ArrayList<>() ;
			ArrayList<String> listaCFSpaiati = new ArrayList<>() ;
			ArrayList<String> listaCFSbagliato = new ArrayList<>() ;
			String CFDaInput = null ;	
			
			XMLInputFactory xmlif3 = null;
			XMLStreamReader xmlr3 = null;
			try {
			 xmlif3 = XMLInputFactory.newInstance();
			 xmlr3 = xmlif3.createXMLStreamReader("codiciFiscali.xml", new FileInputStream("codiciFiscali.xml"));
			} catch (Exception e) {
			 System.out.println("Errore nell'inizializzazione del reader:");
			 System.out.println(e.getMessage());
			}
			
			
			try {
				while (xmlr3.hasNext()) { 
					
					switch (xmlr3.getEventType()) {
					 case XMLStreamConstants.START_DOCUMENT: 
						 break;
										 
					 case XMLStreamConstants.START_ELEMENT: 					 
					 tipo = xmlr3.getLocalName(); 
					 	break;
					 
					 
					 case XMLStreamConstants.END_ELEMENT: 
					 break;
					 
					 case XMLStreamConstants.COMMENT:
					break; 
					 
					 case XMLStreamConstants.CHARACTERS: 
					//per capire se sta leggendo un nome o un cognome o una data...
						 switch(tipo) { 
						 
						 case "codice":
						 {
							 if(!xmlr3.getText().equals("\n        ")) {
								 CFDaInput = xmlr3.getText();
								 if(CodiciFiscali.controlloCF(CFDaInput) ) //se il CF è corretto lo aggiunge alla lista, altrimenti lo aggiunge a quelli sbagliati
								 	listaCF.add(CFDaInput);
								 else  listaCFSbagliato.add(CFDaInput);
							 }
				
							 break;
						 }  
						 		 
						 }
						
						 tipo = "niente";
						 
						 break;
					 }
					 xmlr3.next();
				}
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}
			
		      
	
			
	//creazione CF e verifica corrispondenza con lista CF
		//....
			
			for(int i = 0; i < persone.size() ; i++) {
				persone.get(i).generaCF();
							
				for(int j = 0 ; j < listaCF.size() ; j++) {
					if(persone.get(i).getCF().equals(listaCF.get(j)))
						persone.get(i).setCheckCF(true);
				}
				
				if(!persone.get(i).isCheckCF()) 
					personeCFAssente.add(persone.get(i)); //aggiunge la persona se non ha il CF
				
			}
			
			boolean checkCFSpaiato;
			
			for(int i = 0; i < listaCF.size() ; i++) {
				
				checkCFSpaiato = true;

				for(int j = 0 ; j < persone.size() ; j++) {
					
					if(listaCF.get(i).equals(persone.get(j).getCF())) {
						checkCFSpaiato = false;
					break;
					}
						
				}
				
				if(checkCFSpaiato) 
					listaCFSpaiati.add(listaCF.get(i));
				
			}		
			
			
			XMLOutputFactory xmlof = null;
			XMLStreamWriter xmlw = null;
			try {
			 xmlof = XMLOutputFactory.newInstance();
			 xmlw = xmlof.createXMLStreamWriter(new FileOutputStream("codiciPersone.xml"), "utf-8");
			 xmlw.writeStartDocument("utf-8", "1.0");
			} catch (Exception e) {
			 System.out.println("Errore nell'inizializzazione del writer:");
			 System.out.println(e.getMessage());
			}
			
			
		//scrittura xml sezione persone
			try { // blocco try per raccogliere eccezioni
			 xmlw.writeStartElement("output"); // scrittura del tag radice <programmaArnaldo>
			 xmlw.writeStartElement("persone");
			 xmlw.writeAttribute("numero", Integer.toString(persone.size()));
			 for (int i = 0; i < persone.size(); i++) {
				 xmlw.writeStartElement("persona");
				 xmlw.writeAttribute("id", Integer.toString(i));
				 xmlw.writeStartElement("nome");
				 xmlw.writeCharacters(persone.get(i).getNome());
				 xmlw.writeEndElement();
				 xmlw.writeStartElement("cognome");
				 xmlw.writeCharacters(persone.get(i).getCognome());
				 xmlw.writeEndElement();
				 xmlw.writeStartElement("sesso");
				 xmlw.writeCharacters(persone.get(i).getSesso());
				 xmlw.writeEndElement();
				 xmlw.writeStartElement("comune_nascita");
				 xmlw.writeCharacters(persone.get(i).getComuneNascita());
				 xmlw.writeEndElement();
				 xmlw.writeStartElement("data_nascita");
				 xmlw.writeCharacters(persone.get(i).getAnno() + "-" + persone.get(i).getMese() + "-" + persone.get(i).getGiorno());
				 xmlw.writeEndElement();
				 xmlw.writeStartElement("codice_fiscale");
				 if(persone.get(i).isCheckCF()) xmlw.writeCharacters(persone.get(i).getCF());
				 else  xmlw.writeCharacters("ASSENTE");				 
				 xmlw.writeEndElement();
				 xmlw.writeEndElement();
				 
			 }
			 	xmlw.writeEndElement();
			 
		//scrittura xml sezione codici 
			
				 xmlw.writeStartElement("codici");
				 xmlw.writeStartElement("invalidi");
				 xmlw.writeAttribute("numero", Integer.toString(listaCFSbagliato.size()));
				 for (int i = 0; i < listaCFSbagliato.size(); i++) {
					 xmlw.writeStartElement("codice");
					 xmlw.writeCharacters(listaCFSbagliato.get(i));
					 xmlw.writeEndElement();
				  }
				 xmlw.writeEndElement();
				 
				 xmlw.writeStartElement("spaiati");
				 xmlw.writeAttribute("numero", Integer.toString(listaCFSpaiati.size()));
				 for (int i = 0; i < listaCFSpaiati.size(); i++) {
					 xmlw.writeStartElement("codice");
					 xmlw.writeCharacters(listaCFSpaiati.get(i));
					 xmlw.writeEndElement();
				  }
				 xmlw.writeEndElement();
			
			 xmlw.writeEndElement();
			 xmlw.writeEndElement(); // chiusura di output
			 xmlw.writeEndDocument();
			 xmlw.flush(); 
			 xmlw.close(); 
			} catch (Exception e) { 
			 System.out.println("Errore nella scrittura");
			}
			
		}
	
}
