package no.hvl.dat102.klient;

import no.hvl.dat102.*;

public class KlientFilmarkiv {

	public static void main(String[] args) {
		
		Filmarkiv filma = new Filmarkiv(100);
		Meny meny = new Meny(filma);
		meny.start();

	}

}
