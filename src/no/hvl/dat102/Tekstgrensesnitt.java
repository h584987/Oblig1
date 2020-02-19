package no.hvl.dat102;

import no.hvl.dat102.adt.*;
import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class Tekstgrensesnitt {
	
	//Ta inn opplysninger om en film med input fra tastatur
	public Film lesFilm() {
		
		String nr = showInputDialog(null, "Skriv inn filmnummer: ");
		int filmNr = parseInt(nr);
		String produsent = showInputDialog(null, "Skriv inn produsent: ");
		String tittel = showInputDialog(null, "Skriv inn tittel: ");
		String ar = showInputDialog(null, "Skriv inn årstall: ");
		int aar = parseInt(ar);
		String sjang = showInputDialog(null, "Skriv inn sjanger:\n action, drama, history eller scfi.");
		Sjanger sjanger = Sjanger.finnSjanger(sjang);
		String fSelskap = showInputDialog(null, "Skriv inn filmselskapet: ");
		
		Film nyFilm = new Film(filmNr, produsent, tittel, aar, sjanger, fSelskap);

		return nyFilm;
	}
	  
    //Vise film der alle opplysninger vises på skjermen
    public void visFilm(Film film) {
        showMessageDialog(null, "Filmnummer: " + film.getNr() + "\n Produsent: " + film.getProdusent() + "\n Tittel: " +                 
        film.getTittel() + "\når: " + film.getAar() + "\n Sjanger: " + film.getSjanger() + "\n Filmselskap: " + film.getSelskap());
    }
    
    //Skrive ut alle filmar med ein spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengTittel(FilmarkivADT filma, String delstreng){
    	Film funnet = filma.sokTittel(delstreng);
    	if (funnet == null) {
    		showMessageDialog(null, "Fant ikke tittelen.");
    	} else if (funnet != null) {
    		funnet.skrivUt(funnet);
    	}
    }
    
    //Skrive ut alle filmer av ein produsent
    public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
    	Film funnet = filma.sokProdusent(delstreng);
    	if (funnet == null) {
    		showMessageDialog(null, "Fant ikke produsenten.");
    	} else if (funnet != null) {
    		funnet.skrivUt(funnet);
    	}
    }
    //Skrive ut ein enkel statistikk som inneheld antall filmar totalt og kor mange det er i kvar sjangar
    public void SkrivUtStatistikk(FilmarkivADT filma) {
    	int filmAnt = filma.Antall();
 
    	int sci = filma.antallSjanger(Sjanger.SCIFI);
    	int act = filma.antallSjanger(Sjanger.ACTION);
    	int dram = filma.antallSjanger(Sjanger.DRAMA);
    	int his = filma.antallSjanger(Sjanger.HISTORY);
    	
    	String statistikk = "Totalt antall filmer: " + filmAnt + "\n Antall i de ulike sjangere: " + sci + " er sci-fi, " + act + " er action, " + dram + " er drama og " + his + " er history.";
    	showMessageDialog(null, statistikk);

    	}
    	}