package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat102.adt.FILMarkivADT;

/**
 * @author Ole Olsen
 * 
 */
/* Ref: Mughal: Java som f�rste programmeringsspr�k
 * 
 * ein tekstfil er bygd opp av tekstlinjer. Ein tekstlinje er bygd opp av ein sekvens av ulike tegn som blir avsluttet med en streng.
 * strengen er plattformavhegig.
 * 
 * Me nyttar ein tegnstr�m som er koblet til ein bytestr�m. bytes blir letst ifra byte-innstr�mmen
 * Denne blir deretter oversatt til eit Unicode-tegn av tegn-str�mmen. Unicode-tegn blir deretter oversatt til bytes
 * av tegn-utsr�mmen og til slut blir skivet ut av bytestr�mmen.
 *  
 */
public class Fil {
/*  
 *i Menyen der lesFrafil blir tatt i bruk, m� vi ta i bruk try og catch-blokk for at det skal fungere.
 * 
 */
	private static final String SKILLE = "#";

	/**
	 * @param filnavn
	 * @return Referansen til Film-arkivet
	 * @throws java.io.IOException
	 */
	public static Filmarkiv lesFraFil(String filnavn)  {
		Filmarkiv filmarkiv = null;
			try {
			/*  1 - FileReader
			 * Klassen FileReader s�rgjer for at byte-innstr�mmen blir lagt til.
			 * Den s�rger ogs� at bytes fra filen f�r rett tolkning som eit tegn i 
			 * f�lgende tegnkodinsformatet for plattformen.
			*/    
			 FileReader ansFil = new FileReader(filnavn);
			 			 
            
			/*  2 - BufferedReader
			 *      F�rst Definerer vi eit BufferReader-objekt.
			 *      Dette blir koblet til FileReader-objektet
			 *      n�r metoden v�r readLine() leser ein linje.
			 */
			BufferedReader innfil = new BufferedReader(ansFil);

			// 3 - Leser den f�rste posten som er antall info-poster
			       
			String linje = innfil.readLine();
			int n = Integer.parseInt(linje);
			filmarkiv = new Filmarkiv(n);

			// 4 - Les postene en hel gang om gangen
			for (int i = 0; i < n; i++) {
				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);
				int nr = Integer.parseInt(felt[0]);
				String produsent = felt[1];
				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				String sjStr = felt[4];
				Sjanger sj = Sjanger.finnSjanger(sjStr);
				String selskap = felt[5];

				Film film = new Film(nr, produsent, tittel, aar, sj, selskap);

				filmarkiv.leggTil(film);
			}

			// 4 - Lukk filen
			innfil.close();

		} catch (FileNotFoundException unntak) {// arver fra IOE.. Dette m� st� helt i starten
			                                    // Dersom dette ikkje skjer vil unntaket for IOException skygge
			javax.swing.JOptionPane.showMessageDialog(null, "Finner ikke filen " + filnavn);
		
		} catch (IOException e) {
			javax.swing.JOptionPane.showMessageDialog(null,"Feil ved lesing av fil: " + e);
			
		}
      
	return filmarkiv;
       
	}// metode
	
		
	
	public static void skrivTilFil(FilmarkivADT filma, String filnavn)  {
		try {
			/* 1 - FileWriter
			 *     Definerer et FileWriter-objekt, dette �pner filen.
			 *     Byte-str�m blir opprettet for skriving av bytes til filen.
			 *     Tegna som blir brukt blir lagret i standard tegnkodingsformat for plattformen.
			 *     Dersom utvid blir true vil filen utvides ved skriving p� slutten
			 *     av filen. Dersom utvid blir false, da vil skrivingen begynne i begynnnelsen 
			 *     av filen.			 *     
			 *     viss filen ikkje eksisterer, vil den bli opprettet. 
			 *     viss filen ikkje kan �pnes, vil metoden kaste et unntak av typen IOException.
			 * 
			 */
			FileWriter ansFil = new FileWriter(filnavn, false);

			/* 2 - PrintWriter
			 *     Vi Definerer et PrintWriter-objekt som blir koblet til FileWriter-objektet.
			 *     PrintWriter-objektet leverer tegn til FileWriter-objektet.
			 *     FileWriter skal gi riktig koding av tegna i bytes og lagring p� fil.
			 *      
			 * 
			 */
			PrintWriter utfil = new PrintWriter(ansFil);
			int antall = filma.Antall();
			// 3 - Skriver foerst ut antall ansatt-info-er p� f�rste linje
			utfil.println(antall);
			LinearNode<Film> tabell = filma.hentFilmTabell();
			for (int i = 0; i < antall; i++) {
				// 3 - Skriver postene, felt for felt
				utfil.print(tabell.getElement().getNr());
				utfil.print(SKILLE);
				utfil.print(tabell.getElement().getProdusent());
				utfil.print(SKILLE);
				utfil.print(tabell.getElement().getTittel());
				utfil.print(SKILLE);
				utfil.print(tabell.getElement().getAar());
				utfil.print(SKILLE);
				utfil.print(tabell.getElement().getSjanger());
				utfil.print(SKILLE);
				utfil.println(tabell.getElement().getSelskap());
			} // for
				// 4 - Lukk filen
			utfil.close();
		} // try
		catch (IOException e) {
			javax.swing.JOptionPane.showMessageDialog(null,"Feil p� skriving til fil : " + e);
		
		}

	}// metode

}// class