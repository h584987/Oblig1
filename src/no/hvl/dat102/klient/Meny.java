package no.hvl.dat102;

import no.hvl.dat102.adt.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filma;
	
	public Meny(FilmarkivADT filma) {
		tekstgr = new Tekstgrensesnitt();
		this.filma = filma;
	}
	
	public void start() {
		
		boolean start = true;
		
		while(start) {
			String startValg = showInputDialog("Velkommen til Andreas og Daniel sitt filmarkiv!\n(1) ønsker du informasjon om en film eller skrive til fil? \n(2) ønsker du å lese inn data fra fil? "
					+ "\n(3) Avslutt programmet.");
			int sValg = parseInt(startValg);
			
			switch(sValg) {
			
			//Skriver til fil
			case(1):{
				String valgTxt = showInputDialog("Valg:\n" + "1. Legg til en film. \n" + "2. Slett en film. \n" + "3. Vis informasjon om en film. \n"
						+ "4. Finn film basert på tittel. \n" + "5. Finn film basert på produsent. \n" + "6. Skriv ut statistikk om filmarkivet.\n7. Avslutt programmet.");
				int valg = parseInt(valgTxt);
				
				switch(valg) {
			
				//Lager ny film
				case(1):{
					filma.leggTil(tekstgr.lesFilm());
					Fil.skrivTilFil(filma, "Filmarkiv");
					showMessageDialog(null, "Skrevet til filen Filmarkiv.txt");
					break;
					
				}
				
				//Sletter film
				case(2):{
					String nr = showInputDialog(null, "Angi filmnummer som skal slettes:");
					int filmNr = parseInt(nr);
					boolean slettet = false;
					
					while(!slettet) {
						if(filma.slettFilm(filmNr) == true) {
							showMessageDialog(null, "Sletting vellykket.");
							slettet = true;
							break;
						}else {
							showMessageDialog(null, "Feil med sletting.");
							break;
						}
					}
					break;
				}
				
				//Viser film
				case(3):{
					String fnr = showInputDialog(null, "Angi filmnummer:");
					int filmnummer = parseInt(fnr);
					try {
						Film film = filma.finnFilm(filmnummer);
						if (film.getProdusent() == null && film.getTittel() == null && film.getSelskap() == null) {
							throw new Exception();
						}
						
						else {
						tekstgr.visFilm(film);
						}
					} catch(Exception e) {
						showMessageDialog(null, "Fant ikke filmen.");
					}
					break;
				}
				
				//Skriver ut filmtittelen
				case(4):{
					String tittel = showInputDialog(null, "Søk etter filmtittel: ");
					tekstgr.skrivUtFilmDelstrengTittel(filma, tittel);
					break;
				}
				
				//Skriv ut filmprodusenten
				case(5):{
					String produsent = showInputDialog(null, "Søk etter produsent: ");
					tekstgr.skrivUtFilmProdusent(filma, produsent);
					break;
				}
				
				//Skriver ut informasjon
				case(6):{
					tekstgr.SkrivUtStatistikk(filma);
					break;
				}
				
				case(7):{
					System.exit(0);
				}
				}
				break;
			}
			
			//Leser fra fil
			case(2):{
				try {
				filma = Fil.lesFraFil("Filmarkiv");
				Fil.skrivTilFil(filma, "Filmarkiv");
				showMessageDialog(null, "Lest fra filen Filmarkiv.txt");
				
				} catch(Exception e) {
					showMessageDialog(null, "Fant ikke filen.");
				}
				break;
				}
			
			case(3):{
				System.exit(0);				
			}
			}
		}
		
		
	}
}
