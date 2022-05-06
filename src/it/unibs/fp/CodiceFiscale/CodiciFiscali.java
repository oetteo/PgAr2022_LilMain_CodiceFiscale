package it.unibs.fp.CodiceFiscale;

/**
 * La classe CodiciFiscali esegue controlli sui codici fiscali in input, controllandone la validita'.
 * @author Lil Main
 *
 */
public interface CodiciFiscali {
/**
 * Il metodo calcoloCarattereControllo genera l'ultimo carattere del codice fiscale, ossia quello di controllo.
 * @param CF
 * @return
 */
	public static String calcoloCarattereControllo(String CF) {
		int caratterePari = 0;
		int  carattereDispari = 0;
		int sommaPariEDispari = 0;
		String carattereControllo = "";
		
		for (int i = 0; i < 15; i++) {
			if ((i + 1) % 2 == 0) {
				switch (CF.charAt(i)) {
					case '0':
						caratterePari += 0;
						break;
					case '1':
						caratterePari += 1;
						break;
					case '2':
						caratterePari += 2;
						break;
					case '3':
						caratterePari += 3;
						break;
					case '4':
						caratterePari += 4;
						break;
					case '5':
						caratterePari += 5;
						break;
					case '6':
						caratterePari += 6;
						break;
					case '7':
						caratterePari += 7;
						break;
					case '8':
						caratterePari += 8;
						break;
					case '9':
						caratterePari += 9;
						break;
					case 'A':
						caratterePari += 0;
						break;
					case 'B':
						caratterePari += 1;
						break;
					case 'C':
						caratterePari += 2;
						break;
					case 'D':
						caratterePari += 3;
						break;
					case 'E':
						caratterePari += 4;
						break;
					case 'F':
						caratterePari += 5;
						break;
					case 'G':
						caratterePari += 6;
						break;
					case 'H':
						caratterePari += 7;
						break;
					case 'I':
						caratterePari += 8;
						break;
					case 'J':
						caratterePari += 9;
						break;
					case 'K':
						caratterePari += 10;
						break;
					case 'L':
						caratterePari += 11;
						break;
					case 'M':
						caratterePari += 12;
						break;
					case 'N':
						caratterePari += 13;
						break;
					case 'O':
						caratterePari += 14;
						break;
					case 'P':
						caratterePari += 15;
						break;
					case 'Q':
						caratterePari += 16;
						break;
					case 'R':
						caratterePari += 17;
						break;
					case 'S':
						caratterePari += 18;
						break;
					case 'T':
						caratterePari += 19;
						break;
					case 'U':
						caratterePari += 20;
						break;
					case 'V':
						caratterePari += 21;
						break;
					case 'W':
						caratterePari += 22;
						break;
					case 'X':
						caratterePari += 23;
						break;
					case 'Y':
						caratterePari += 24;
						break;
					case 'Z':
						caratterePari += 25;
						break;
				}


			} else {
				switch (CF.charAt(i)) {
					case '0':
						carattereDispari += 1;
						break;
					case '1':
						carattereDispari += 0;
						break;
					case '2':
						carattereDispari += 5;
						break;
					case '3':
						carattereDispari += 7;
						break;
					case '4':
						carattereDispari += 9;
						break;
					case '5':
						carattereDispari += 13;
						break;
					case '6':
						carattereDispari += 15;
						break;
					case '7':
						carattereDispari += 17;
						break;
					case '8':
						carattereDispari += 19;
						break;
					case '9':
						carattereDispari += 21;
						break;
					case 'A':
						carattereDispari += 1;
						break;
					case 'B':
						carattereDispari += 0;
						break;
					case 'C':
						carattereDispari += 5;
						break;
					case 'D':
						carattereDispari += 7;
						break;
					case 'E':
						carattereDispari += 9;
						break;
					case 'F':
						carattereDispari += 13;
						break;
					case 'G':
						carattereDispari += 15;
						break;
					case 'H':
						carattereDispari += 17;
						break;
					case 'I':
						carattereDispari += 19;
						break;
					case 'J':
						carattereDispari += 21;
						break;
					case 'K':
						carattereDispari += 2;
						break;
					case 'L':
						carattereDispari += 4;
						break;
					case 'M':
						carattereDispari += 18;
						break;
					case 'N':
						carattereDispari += 20;
						break;
					case 'O':
						carattereDispari += 11;
						break;
					case 'P':
						carattereDispari += 3;
						break;
					case 'Q':
						carattereDispari += 6;
						break;
					case 'R':
						carattereDispari += 8;
						break;
					case 'S':
						carattereDispari += 12;
						break;
					case 'T':
						carattereDispari += 14;
						break;
					case 'U':
						carattereDispari += 16;
						break;
					case 'V':
						carattereDispari += 10;
						break;
					case 'W':
						carattereDispari += 22;
						break;
					case 'X':
						carattereDispari += 25;
						break;
					case 'Y':
						carattereDispari += 24;
						break;
					case 'Z':
						carattereDispari += 23;
						break;
				}

			}

		}

		 sommaPariEDispari = caratterePari + carattereDispari;
		
		
		int codiceIdentificativo = sommaPariEDispari % 26;
		
		switch(codiceIdentificativo) {
		case 0:
			carattereControllo = "A";
			break;
		case 1:
			carattereControllo = "B";
			break;
		case 2:
			carattereControllo = "C";
			break;
		case 3:
			carattereControllo = "D";
			break;
		case 4:
			carattereControllo = "E";
			break;
		case 5:
			carattereControllo = "F";
			break;
		case 6:
			carattereControllo = "G";
			break;
		case 7:
			carattereControllo = "H";
			break;
		case 8:
			carattereControllo = "I";
			break;
		case 9:
			carattereControllo = "J";
			break;
		case 10:
			carattereControllo = "K";
			break;
		case 11:
			carattereControllo = "L";
			break;
		case 12:
			carattereControllo = "M";
			break;
		case 13:
			carattereControllo = "N";
			break;
		case 14:
			carattereControllo = "O";
			break;
		case 15:
			carattereControllo = "P";
			break;
		case 16:
			carattereControllo = "Q";
			break;
		case 17:
			carattereControllo = "R";
			break;
		case 18:
			carattereControllo = "S";
			break;
		case 19:
			carattereControllo = "T";
			break;
		case 20:
			carattereControllo = "U";
			break;
		case 21:
			carattereControllo = "V";
			break;
		case 22:
			carattereControllo = "W";
			break;
		case 23:
			carattereControllo = "X";
			break;
		case 24:
			carattereControllo = "Y";
			break;
		case 25:
			carattereControllo = "Z";
			break;
		} 
		
		return  carattereControllo;
		
	}
/**
 * Il metodo controlloCF controlla che il codice fiscale sia valido.	
 * @param CF
 * @return
 */
	public static boolean controlloCF (String CF) {
		boolean check = false;
		boolean checkCaratteri = false;
		boolean checkGiorno = false;
		boolean checkMese = false;
		boolean checkCC = false;
		boolean checkGiorniMese = true;
		
		
		//controllo Caratteri
		if(CF.substring(0, 6).matches("[0-9]+")) return checkCaratteri;
		if(CF.substring(6, 8).matches("[A-Z]+")) return checkCaratteri;
		if(CF.substring(8, 9).matches("[0-9]+")) return checkCaratteri;
		if(CF.substring(9, 11).matches("[A-Z]+")) return checkCaratteri;
		if(CF.substring(11, 12).matches("[0-9]+")) return checkCaratteri;
		if(CF.substring(12, 15).matches("[A-Z]+")) return checkCaratteri;
		if(CF.substring(15).matches("[0-9]+")) return checkCaratteri;
		
		checkCaratteri = true;
		
		

		//fine controllo caratteri
		
	//controllo validità giorno
		
		if(Integer.parseInt(CF.substring(9, 11)) > 71 || ( Integer.parseInt(CF.substring(9, 11)) > 31 && Integer.parseInt(CF.substring(9, 11)) < 41 ) ) {
           return checkGiorno;
        }
		else checkGiorno = true;
		
		
	//fine controllo validità giorno
		
	//controllo mese
		
		if(CF.substring(8, 9).matches("[ABCDEHLMPRST]+"))  
			{
				 checkMese = true;
			}
		
		else return checkMese = false;
		
	//fine controllo mese
		
	
		
		//controllo Carettere Controllo
           
		if(CF.substring(15).equals(calcoloCarattereControllo(CF))) checkCC = true;
		else return checkCC;
		
	//fine controllo carattere conrtollo
            	
      //controllo giorniMese
           		
            	
				if(CF.charAt(8)=='B')
				{
					if(Integer.parseInt(CF.substring(9, 11)) > 68 || ( Integer.parseInt(CF.substring(9, 11)) > 28 && Integer.parseInt(CF.substring(9, 11)) < 41 )) 
						return checkGiorniMese = false;
										
				}
				
				if(CF.charAt(8)=='D' || CF.charAt(8)=='H' || CF.charAt(8)=='P' || CF.charAt(8)=='S') {
					if(Integer.parseInt(CF.substring(9, 11)) > 70 || ( Integer.parseInt(CF.substring(9, 11)) > 30 && Integer.parseInt(CF.substring(9, 11)) < 41 ))
						return checkGiorniMese = false;
				}
				
      //fine controllo giorniMese
				
	if(checkCaratteri && checkCC && checkGiorniMese && checkGiorno && checkMese) check = true;
	
	return check;
}
}
