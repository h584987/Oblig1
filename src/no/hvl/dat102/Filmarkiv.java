package no.hvl.dat102;

import no.hvl.dat102.adt.*;
import no.hvl.dat102.Film;

public class Filmarkiv implements FilmarkivADT {
	
	private int antall;
	private LinearNode<Film> start;
	
	//Konstruktør
	public Filmarkiv(){
		start = null;
		antall = 0;
	}
	
	public Filmarkiv(int max) {
		
	}
	
	@Override	
	public LinearNode<Film> hentFilmTabell() {
		 return start;
	 }
	
	@Override	
	public void leggTil(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<Film>(nyFilm);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
          }
	
	@Override	
	public boolean slettFilm(int filmNr) {
	
		boolean slettet = false;
		
		if (Antall() != 0) {
		
		LinearNode<Film> slett = start;
		
		for (int i = 0; i < antall; i++) {
			
			if (filmNr == slett.getElement().getNr()) {
			slett = start.getNeste();
			antall --;
			slettet = true;
			}
			try {
				slett = start.getNeste();
			} catch(EmptyCollectionException e) {
		}
			
		}
		}
		return slettet;	
	}
	
	@Override	
	public Film sokTittel(String delstreng) {
		LinearNode<Film> tittel = hentFilmTabell();
		Film funnet = null;
		
		
		for (int i = 0; i < Antall(); i++) {
			if (tittel.getElement().getTittel().contains(delstreng)) 
						funnet = tittel.getElement();
			try { 
				tittel = start.getNeste();
			} catch(EmptyCollectionException e) {
		}
		}
		return funnet;
		}

	@Override	
	public Film sokProdusent(String delstreng) {
		LinearNode<Film> produsent = hentFilmTabell();
		Film funnet = null;
		
		for (int i = 0; i < Antall(); i++) {
			if (produsent.getElement().getProdusent().contains(delstreng)) 
						funnet = produsent.getElement();
			try { 
				produsent = start.getNeste();
			} catch(EmptyCollectionException e) {
		}
		}
		return funnet;
		}

	@Override	
	public int antallSjanger(Sjanger sjanger) {
		 int antallSjanger = 0;
		LinearNode<Film> sjang = hentFilmTabell();
		 
		 for (int i = 0; i < Antall(); i++) {
	
		 if (sjang.getElement().getSjanger() == sjanger) 
		 antallSjanger++;
		
		 try { 
			 sjang = start.getNeste(); 
		 } catch(EmptyCollectionException e) {
			 
		 }
		 }
		 return antallSjanger;
	}

	@Override	
	public int Antall() {
		return antall;
		}	

	@Override	
	public Film finnFilm(int filmNr) {
		Film funnet = new Film();
		LinearNode<Film> film = hentFilmTabell();
		
		for (int i = 0; i < Antall(); i++)	
			if (filmNr == film.getElement().getNr())
				funnet = film.getElement();
		
		try {
			film = start.getNeste();
			} catch(EmptyCollectionException e) {
				
			}
	
	return funnet;
}
	
}