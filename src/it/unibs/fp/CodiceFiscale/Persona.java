package it.unibs.fp.CodiceFiscale;
/**
 * La classe Persona memorizza i dati anagrafici e da questi genera il codice fiscale.
 * @author Lil Main
 *
 */
public class Persona {
	
	private String cognome;
	private String nome;
	private String sesso;
	private String comuneNascita;
	private Comune comune;


	private int giorno;
	private int mese;
	private int anno;
	private String CF;
	
	private boolean checkCF = false;
	
	

	public Persona(String cognome, String nome, String sesso, String comuneNascita, int giorno, int mese, int anno) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.sesso = sesso;
		this.comuneNascita = comuneNascita;
		this.giorno = giorno;
		this.mese = mese;
		this.anno = anno;
	
	}
	
	
	


	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getGiorno() {
		return giorno;
	}
	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}
	public int getMese() {
		return mese;
	}
	public void setMese(int mese) {
		this.mese = mese;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getComuneNascita() {
		return comuneNascita;
	}
	public void setComuneNascita(String comuneNascita) {
		this.comuneNascita = comuneNascita;
	}
	public boolean isCheckCF() {
		return checkCF;
	}
	public void setCheckCF(boolean checkCF) {
		this.checkCF = checkCF;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	public Comune getComune() {
		return comune;
	}
	public void setComune(Comune comune) {
		this.comune = comune;
	}
	
	/**
	 * Il metodo generaCF genera i codici fiscali.
	 */
	
public void generaCF(){
		
		String cognomeCF = "";
		String nomeCF = "";
		String cons = "";
		String voc = "";
		String meseCF = "";
		String giornoESessoCF = "";
		String comuneCF= "";
		String carattereControllo = "";
		
	
		
	//cognome CF
		//....
		for (int i = 0; i < cognome.length() && cognomeCF.length() < 3 ; i++) {
			if(!cognome.substring(i, i+1).matches("[AEIOU]+")) //aggiunge solo le consonanti fino a max 3
			{
				cognomeCF+=cognome.charAt(i);
			}
			
				} 
		
		while(cognomeCF.length() < 3 ){
			for (int i = 0; i < cognome.length() && cognomeCF.length() < 3 ; i++) {
				if(cognome.substring(i, i+1).matches("[AEIOU]+"))
					{ cognomeCF += cognome.charAt(i); }					
				} 
			
			cognomeCF += 'X'; // aggiunge la X se non ci sono abbastanza lettere

			} // aggiunge vocali in caso ci siano meno di 3 consonanti
		
		
		
	//nomeCF
		//....
		for(int i=0; i< nome.length(); i++) { //conta le consonanti
			if(!nome.substring(i, i+1).matches("[AEIOU]+")) {
				cons+= nome.charAt(i);
			}
		}
			if (cons.length() >= 4) { //se sono 4 o più prendeono la prima la terza e la quarta
				nomeCF = nomeCF + cons.charAt(0) + cons.charAt(2) + cons.charAt(3);
		}
			else if (cons.length()== 3) { // se sono 3 prende solo quelle
				nomeCF = nomeCF + cons.charAt(0) +  cons.charAt(1) +  cons.charAt(2);
			}
			else if(cons.length() < 3) {//se sono meno di 3 prende anche le vocali a completare
				for(int i=0; i<nome.length() && (cons.length() + voc.length()) < 4; i++) {
					if(nome.substring(i, i+1).matches("[AEIOU]+")) {
						voc += nome.charAt(i);
					}
					
				}
				nomeCF = nomeCF + cons + voc;
				
			while(nomeCF.length() < 3)	{
				if(nomeCF.length()<3) nomeCF+='X';// se il cognome ha meno di 3 lettere aggiunge una X
			}
}
		
			
	//annoCF
		//....
			int annoCFN = anno % 100;
			String annoCF = Integer.toString(annoCFN);
			if(annoCF.length() < 2) annoCF = "0" + annoCF;
			
			
			
	//meseCF
		//....
			switch(mese) {// assegna le lettere ai mesi
			case 1:
				meseCF = "A";
				break;
			case 2:
				meseCF = "B";
				break;
			case 3:
				meseCF = "C";
				break;
			case 4:
				meseCF = "D";
				break;
			case 5:
				meseCF = "E";
				break;
			case 6:
				meseCF = "H";
				break;
			case 7: 
				meseCF = "L";
				break;
			case 8: 
				meseCF = "M";
				break;
			case 9:
				meseCF = "P";
				break;
			case 10:
				meseCF = "R";
				break;
			case 11: 
				meseCF = "S";
				break;
			case 12: 
				meseCF = "T";
				break;
				
			}
	
	//giornoCF e sessoCF
		//....
			switch(sesso) {
			case "M":
				
					giornoESessoCF=Integer.toString(giorno);
					if(giornoESessoCF.length()<2) giornoESessoCF = "0" + giornoESessoCF; //se il giorno è compreso tra 1 e 9 aggiunge zero davanti
				break;
			
			case "F":
					giornoESessoCF=Integer.toString(giorno+40);
					if(giornoESessoCF.length()<2) giornoESessoCF = "0" + giornoESessoCF;
				break;
			}
			
			
	//comune di nascita CF
			comuneCF = comune.getCodice();
			
	// codice fiscale senza carattere di controllo		
			String CFTemporaneo = "";
			CFTemporaneo = cognomeCF + nomeCF + annoCF + meseCF + giornoESessoCF + comuneCF;
			
		
			carattereControllo = CodiciFiscali.calcoloCarattereControllo(CFTemporaneo);
			
				String CodiceFiscale = CFTemporaneo + carattereControllo;
				this.CF = CodiceFiscale;
}

}

