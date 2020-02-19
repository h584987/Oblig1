package no.hvl.dat102.adt;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

public interface FILMarkivADT {// Bruk gjerne javadoc her i
    				// stedet for vanlige
					// kommentarlinjer som her
//Returnere en tabell av Filmer
Film[] hentFilmTabell();


//Legger til en ny Film
void leggTilFilm(Film nyFilm);

// Sletter en Film hvis den fins
boolean slettFilm(int filmNr);
//S�ker og henter Filmer med en gitt delstreng 

Film[] sokTittel(String delstreng);
//S�ker og henter produsenter med en gitt delstreng 

Film[] sokProdusent(String delstreng);
//Henter antall Filmer for en gitt sjanger 

int antallSjanger(Sjanger sjanger);


// Returnerer antall Filmer
int antall();

}//interface